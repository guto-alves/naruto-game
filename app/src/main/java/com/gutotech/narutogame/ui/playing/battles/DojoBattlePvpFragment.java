package com.gutotech.narutogame.ui.playing.battles;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.databinding.FragmentDojoBattlePvpBinding;
import com.gutotech.narutogame.databinding.PopupAttributesStatusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.BattleLogAdapter;
import com.gutotech.narutogame.ui.adapter.BuffsDebuffStatusAdapter;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

public class DojoBattlePvpFragment extends Fragment implements SectionFragment {
    private FragmentDojoBattlePvpBinding mBinding;

    private DojoBattlePvpViewModel mViewModel;

    public DojoBattlePvpFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dojo_battle_pvp,
                container, false);

        mViewModel = new ViewModelProvider(this).get(DojoBattlePvpViewModel.class);
        mBinding.setViewModel(mViewModel);

        mBinding.classJutsusButton.setText(CharOn.character.getClasse().name.substring(0, 3));

        mBinding.myStatusImageView.setOnClickListener(v ->
                showStatus(v, mViewModel.getPlayerFormulas())
        );

        mBinding.oppStatusImageView.setOnClickListener(v ->
                showStatus(v, mViewModel.getOppFormulas())
        );

        mBinding.myBuffsDebuffsStatusRecyclerView.setHasFixedSize(true);
        BuffsDebuffStatusAdapter adapter = new BuffsDebuffStatusAdapter(getContext());
        mBinding.myBuffsDebuffsStatusRecyclerView.setAdapter(adapter);
        mViewModel.getmPlayerBuffsDebuffsStatus().observe(getViewLifecycleOwner(), adapter::setBuffsDebuffsList);

        mBinding.oppBuffsDebuffsStatusRecyclerView.setHasFixedSize(true);
        BuffsDebuffStatusAdapter adapter2 = new BuffsDebuffStatusAdapter(getContext());
        mBinding.oppBuffsDebuffsStatusRecyclerView.setAdapter(adapter2);
        mViewModel.getmOppBuffsDebuffsStatus().observe(getViewLifecycleOwner(), adapter2::setBuffsDebuffsList);

        mBinding.battleLogRecyclerView.setHasFixedSize(true);
        BattleLogAdapter logAdapter = new BattleLogAdapter(getActivity(), this::showJutsuInfo);
        mBinding.battleLogRecyclerView.setAdapter(logAdapter);
        mViewModel.getBattleLogs().observe(getViewLifecycleOwner(), battlesLogs -> {
            logAdapter.setBattleLogs(battlesLogs);
            mBinding.battleLogRecyclerView.smoothScrollToPosition(logAdapter.getItemCount());
        });

        mBinding.myJutsusRecyclerView.setHasFixedSize(true);
        JutsusAdapter jutsusAdapter = new JutsusAdapter(getActivity(), mViewModel);
        mBinding.myJutsusRecyclerView.setAdapter(jutsusAdapter);
        mViewModel.getJutsus().observe(getViewLifecycleOwner(), jutsusAdapter::setJutsusList);

        mViewModel.getShowJutsuInfoPopupEvent().observe(getViewLifecycleOwner(), this::showJutsuInfo);

        mViewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), this::showWarningDialog);

        mBinding.battleResultLayout.descriptionTextView.setMovementMethod(
                LinkMovementMethod.getInstance()
        );

        mViewModel.getShowWonEvent().observe(getViewLifecycleOwner(), rewards -> {
            SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
            description.append(getString(R.string.combat_won_description, rewards[0], rewards[1]));
            description.append();
            description.append(CharOn.character.battleId.contains("MAP-PVP") ?
                            R.string.village_map : R.string.dojo,
                    new ForegroundColorSpan(Color.BLUE),
                    new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View widget) {
                            mViewModel.exit();

                            if (CharOn.character.battleId.contains("MAP-PVP")) {
                                FragmentUtil.goTo(getActivity(), new VillageMapFragment());
                            } else {
                                FragmentUtil.goTo(getActivity(), new DojoFragment());
                            }
                        }
                    });
            description.append(R.string.training_points_for_your_participation);

            showBattleResult(R.string.end_of_the_battle, description.getStringBuilder());
        });

        mViewModel.getShowLostEvent().observe(getViewLifecycleOwner(), aVoid -> {
            SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
            description.append(R.string.you_have_lost_the_battle);
            description.append();
            description.append(R.string.hospital,
                    new ForegroundColorSpan(Color.BLUE),
                    new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View widget) {
                            mViewModel.exit();
                            CharOn.character.setHospital(true);
                        }
                    });
            description.append(getString(R.string.training_points_for_your_participation));

            showBattleResult(R.string.too_bad, description.getStringBuilder());
        });

        mViewModel.getShowDrawnEvent().observe(getViewLifecycleOwner(), aVoid -> {
            SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
            description.append(getString(R.string.drawn_description));
            description.append();
            description.append(R.string.hospital,
                    new ForegroundColorSpan(Color.BLUE),
                    new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View widget) {
                            mViewModel.exit();
                            CharOn.character.setHospital(true);
                        }
                    });

            showBattleResult(R.string.empate, description.getStringBuilder());
        });

        mViewModel.getShowInactivatedEvent().observe(getViewLifecycleOwner(), aVoid -> {
            SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
            description.append(R.string.lost_by_inactivity);
            description.append(R.string.click_here,
                    new ForegroundColorSpan(Color.BLUE),
                    new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View widget) {
                            mViewModel.exit();
                            CharOn.character.setHospital(true);
                        }
                    });
            description.append();
            description.append(R.string.to_preceed);
            showBattleResult(R.string.too_bad, description.getStringBuilder());
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_dojo);
        return mBinding.getRoot();
    }

    private void showStatus(View view, Formulas formulas) {
        PopupWindow popupWindow = new PopupWindow(getContext());

        PopupAttributesStatusBinding binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.popup_attributes_status, null, false);

        popupWindow.setContentView(binding.getRoot());
        binding.setFormulas(formulas);

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(view);
    }

    private void showJutsuInfo(Object[] objects) {
        JutsuInfoPopupWindow jutsuInfoPopupWindow = new JutsuInfoPopupWindow(getContext());
        jutsuInfoPopupWindow.setJutsu((Jutsu) objects[1], (Integer) objects[0]);
        jutsuInfoPopupWindow.showAsDropDown((View) objects[2]);
    }

    private void showJutsuInfo(View anchor, BattleLog battleLog) {
        JutsuInfoPopupWindow jutsuInfoPopupWindow = new JutsuInfoPopupWindow(getContext());
        jutsuInfoPopupWindow.setBattleLog(battleLog);
        jutsuInfoPopupWindow.showAsDropDown(anchor);
    }

    private void showWarningDialog(@StringRes int resid) {
        WarningDialogFragment dialog = WarningDialogFragment.newInstance(resid);
        dialog.openDialog(getParentFragmentManager());
    }

    private void showBattleResult(@StringRes int title, SpannableStringBuilder description) {
        if (mBinding.battleResultLayout.msgConstraintLayout.getVisibility() == View.GONE) {
            StorageUtils.downloadProfileForMsg(getActivity(), mBinding.battleResultLayout.profileImageView);
            mBinding.battleResultLayout.titleTextView.setText(title);
            mBinding.battleResultLayout.descriptionTextView.setText(description);
            mBinding.battleResultLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
            mBinding.myJutsusRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getDescription() {
        return R.string.battle_pvp;
    }
}
