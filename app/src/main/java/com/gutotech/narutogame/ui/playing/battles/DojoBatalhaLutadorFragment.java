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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.databinding.FragmentDojoBatalhaLutadorBinding;
import com.gutotech.narutogame.databinding.PopupAttributesStatusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.BattleLogAdapter;
import com.gutotech.narutogame.ui.adapter.BuffsDebuffStatusAdapter;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class DojoBatalhaLutadorFragment extends Fragment implements SectionFragment {
    private FragmentDojoBatalhaLutadorBinding mBinding;

    private DojoBatalhaLutadorViewModel mViewModel;

    public DojoBatalhaLutadorFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dojo_batalha_lutador,
                container, false);
        mBinding.setContext(getContext());

        BattleRepository.getInstance().get(CharOn.character.battleId, battle -> {
            mViewModel = new ViewModelProvider(this,
                    new DojoBatalhaLutadorViewModelFactory(battle))
                    .get(DojoBatalhaLutadorViewModel.class);

            mBinding.setViewModel(mViewModel);

            mBinding.classJutsusButton.setText(CharOn.character.getClasse().name.substring(0, 3));

            mBinding.myStatusImageView.setOnClickListener(v ->
                    showStatus(v, mViewModel.getPlayerFormulas()));

            mBinding.oppStatusImageView.setOnClickListener(v ->
                    showStatus(v, mViewModel.getNpcFormulas()));

            mBinding.myBuffsDebuffsStatusRecyclerView.setHasFixedSize(true);
            BuffsDebuffStatusAdapter adapter = new BuffsDebuffStatusAdapter(getContext());
            mBinding.myBuffsDebuffsStatusRecyclerView.setAdapter(adapter);
            mViewModel.getMyBuffsDebuffsStatus().observe(getViewLifecycleOwner(), adapter::setBuffsDebuffsList);

            mBinding.oppBuffsDebuffsStatusRecyclerView.setHasFixedSize(true);
            BuffsDebuffStatusAdapter adapter2 = new BuffsDebuffStatusAdapter(getContext());
            mBinding.oppBuffsDebuffsStatusRecyclerView.setAdapter(adapter2);
            mViewModel.getOppBuffsDebuffsStatus().observe(getViewLifecycleOwner(), adapter2::setBuffsDebuffsList);

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

            mViewModel.showJutsuInfoPopupEvent.observe(getViewLifecycleOwner(), this::showJutsuInfo);

            mViewModel.showWarningDialogEvent.observe(getViewLifecycleOwner(), this::showWarningDialog);

            mViewModel.startAnimationEvent.observe(getViewLifecycleOwner(), view -> {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                view.startAnimation(animation);
            });

            mBinding.battleResultLayout.descriptionTextView.setMovementMethod(
                    LinkMovementMethod.getInstance());

            mViewModel.showWonEvent.observe(getViewLifecycleOwner(), rewards -> {
                SpannableStringBuilder description = new SpannableStringBuilder();
                description.append(getString(R.string.combat_won_description, rewards[0], rewards[1]));
                description.append(" ");
                int length = description.length();
                description.append("Dojo");
                description.setSpan(new ForegroundColorSpan(Color.BLUE), length, description.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                description.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        mViewModel.exit();
                        FragmentUtil.goTo(getActivity(), new DojoFragment());
                    }
                }, length, description.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                showBattleResult(R.string.end_of_the_battle, description);
            });

            mViewModel.showLostEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilder description = new SpannableStringBuilder();
                description.append(getString(R.string.you_have_lost_the_battle));
                description.append(" ");
                int length = description.length();
                description.append("Hospital");
                description.setSpan(new ForegroundColorSpan(Color.BLUE), length, description.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                description.setSpan(
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        }, length, description.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                showBattleResult(R.string.too_bad, description);
            });

            mViewModel.showDrawnEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilder description = new SpannableStringBuilder();
                description.append(getString(R.string.drawn_description));
                description.append(" ");
                int length = description.length();
                description.append("Hospital");
                description.setSpan(new ForegroundColorSpan(Color.BLUE), length, description.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                description.setSpan(
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        }, length, description.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                showBattleResult(R.string.empate, description);
            });

            mViewModel.showInactivatedEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilder description = new SpannableStringBuilder();
                description.append(getString(R.string.lost_by_inactivity));
                int length = description.length();
                description.append(getString(R.string.click_here));
                description.setSpan(new ForegroundColorSpan(Color.BLUE), length, description.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                description.setSpan(
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        }, length, description.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                description.append(" ");
                description.append(getString(R.string.to_preceed));

                showBattleResult(R.string.too_bad, description);
            });
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.dojo_challenge);
        return mBinding.getRoot();
    }

    private void showBattleResult(@StringRes int title, SpannableStringBuilder description) {
        StorageUtil.downloadProfileForMsg(getActivity(), mBinding.battleResultLayout.profileImageView);
        mBinding.battleResultLayout.titleTextView.setText(title);
        mBinding.battleResultLayout.descriptionTextView.setText(description);
        mBinding.battleResultLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
        mBinding.myJutsusRecyclerView.setVisibility(View.GONE);
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

    @Override
    public int getDescription() {
        return R.string.npc_battle;
    }
}
