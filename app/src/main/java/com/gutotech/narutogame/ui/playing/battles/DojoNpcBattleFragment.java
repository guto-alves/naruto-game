package com.gutotech.narutogame.ui.playing.battles;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.databinding.FragmentDojoNpcBattleBinding;
import com.gutotech.narutogame.databinding.PopupAttributesStatusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.BattleLogAdapter;
import com.gutotech.narutogame.ui.adapter.BuffsDebuffStatusAdapter;
import com.gutotech.narutogame.ui.adapter.JutsusAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SettingsUtils;
import com.gutotech.narutogame.utils.SoundUtil;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

public class DojoNpcBattleFragment extends Fragment implements SectionFragment {
    private FragmentDojoNpcBattleBinding mBinding;
    private DojoNpcBattleViewModel mViewModel;

    public DojoNpcBattleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dojo_npc_battle,
                container, false);

        BattleRepository.getInstance().get(CharOn.character.getBattleId(), battle -> {
            mViewModel = new ViewModelProvider(this,
                    new DojoNpcBattleViewModelFactory(battle))
                    .get(DojoNpcBattleViewModel.class);

            mBinding.setViewModel(mViewModel);

            mBinding.classJutsusButton.setText(CharOn.character.getClasse().name.substring(0, 3));

            mBinding.myStatusImageView.setOnClickListener(v ->
                    showStatus(v, mViewModel.getPlayerFormulas())
            );

            mBinding.oppStatusImageView.setOnClickListener(v ->
                    showStatus(v, mViewModel.getNpcFormulas())
            );

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

            mBinding.battleResultLayout.descriptionTextView.setMovementMethod(
                    LinkMovementMethod.getInstance()
            );

            mViewModel.showWonEvent.observe(getViewLifecycleOwner(), rewards -> {
                SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
                description.append(getString(R.string.combat_won_description, rewards[0], rewards[1]));
                description.append();
                description.append(R.string.dojo,
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                FragmentUtils.goTo(getActivity(), new DojoFragment());
                            }
                        },
                        new RelativeSizeSpan(1.5f)
                );
                showBattleResult(R.string.end_of_the_battle, description.getString());
                SoundUtil.play(getContext(), R.raw.win);
            });

            mViewModel.showLostEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
                description.append(R.string.you_have_lost_the_battle);
                description.append();
                description.append(R.string.hospital,
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        },
                        new RelativeSizeSpan(1.5f)
                );
                showBattleResult(R.string.too_bad, description.getString());
                SoundUtil.play(getContext(), R.raw.lose);
            });

            mViewModel.showDrawnEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
                description.append(R.string.drawn_description);
                description.append();
                description.append(R.string.hospital,
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        },
                        new RelativeSizeSpan(1.5f)
                );
                showBattleResult(R.string.empate, description.getString());
            });

            mViewModel.showInactivatedEvent.observe(getViewLifecycleOwner(), aVoid -> {
                SpannableStringBuilderCustom description = new SpannableStringBuilderCustom(getContext());
                description.append(R.string.lost_by_inactivity);
                description.append(R.string.click_here,
                        new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View widget) {
                                mViewModel.exit();
                                CharOn.character.setHospital(true);
                            }
                        },
                        new RelativeSizeSpan(1.5f)
                );
                description.append();
                description.append(getString(R.string.to_preceed));
                showBattleResult(R.string.too_bad, description.getString());
                SoundUtil.play(getContext(), R.raw.lose);
            });
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.dojo_challenge);

        mBinding.adView.loadAd(new AdRequest.Builder().build());
        mBinding.adView1.loadAd(new AdRequest.Builder().build());

        showTour();

        return mBinding.getRoot();
    }

    private void showTour() {
        boolean showBattleTour = SettingsUtils.get(getContext(), SettingsUtils.BATTLE_TOUR_KEY);

        if (showBattleTour) {
            SettingsUtils.set(getContext(), SettingsUtils.BATTLE_TOUR_KEY, false);

            new TapTargetSequence(getActivity())
                    .targets(
                            TapTarget.forView(mBinding.playerProfileImageView,
                                    getString(R.string.tour_your_character),
                                    getString(R.string.tour_battle_your_character_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColorInt(Color.BLACK)
                                    .targetRadius(60)
                                    .drawShadow(true)
                                    .transparentTarget(true)
                                    .cancelable(false),
                            TapTarget.forView(mBinding.opponentLinearLayout,
                                    getString(R.string.tour_battle_your_enemy),
                                    getString(R.string.tour_battle_your_enemy_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColorInt(Color.BLACK)
                                    .targetRadius(70)
                                    .drawShadow(true)
                                    .transparentTarget(true)
                                    .cancelable(false),
                            TapTarget.forView(mBinding.battleLogRecyclerView,
                                    getString(R.string.tour_battle_battle_summary),
                                    getString(R.string.tour_battle_battle_summary_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColorInt(Color.BLACK)
                                    .targetRadius(180)
                                    .transparentTarget(true)
                                    .cancelable(false),
                            TapTarget.forView(mBinding.myJutsusRecyclerView,
                                    getString(R.string.tour_battle_your_scams),
                                    getString(R.string.tour_battle_your_scams_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColorInt(Color.BLACK)
                                    .targetRadius(60)
                                    .transparentTarget(true)
                                    .cancelable(false),
                            TapTarget.forView(mBinding.myJutsusRecyclerView,
                                    getString(R.string.tour_battle_jutsu_information),
                                    getString(R.string.tour_battle_jutsu_information_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColor(android.R.color.black)
                                    .transparentTarget(true)
                                    .targetRadius(60)
                                    .cancelable(false),
                            TapTarget.forView(mBinding.myStatusImageView,
                                    getString(R.string.tour_battle_summarizing),
                                    getString(R.string.tour_battle_summarizing_desc))
                                    .outerCircleAlpha(0.96f)
                                    .dimColor(android.R.color.black)
                                    .targetRadius(50)
                                    .transparentTarget(true)
                                    .cancelable(false)
                    ).start();
        }
    }

    private void showBattleResult(@StringRes int title, SpannableStringBuilder description) {
        StorageUtils.loadProfileForMsg(getActivity(), mBinding.battleResultLayout.profileImageView);
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
        SoundUtil.play(getContext(), R.raw.sound_pop);
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
        WarningDialogFragment dialog = WarningDialogFragment.newInstance(getContext(), resid);
        dialog.openDialog(getFragmentManager());
        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public int getDescription() {
        return R.string.npc_battle;
    }
}
