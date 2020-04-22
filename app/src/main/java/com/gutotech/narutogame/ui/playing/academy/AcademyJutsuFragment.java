package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentAcademyJutsuBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.JutsusLearnAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

public class AcademyJutsuFragment extends Fragment implements SectionFragment {
    private FragmentAcademyJutsuBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyJutsuViewModel viewModel = new ViewModelProvider(this)
                .get(AcademyJutsuViewModel.class);

        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_academy_jutsu, container, false);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(viewModel);

        SpannableStringBuilderCustom stringBuilder = new SpannableStringBuilderCustom(getContext());
        stringBuilder.append(R.string.link_training_jutsus);
        stringBuilder.append();
        stringBuilder.append(R.string.my_jutsus_section, new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        FragmentUtils.goTo(getActivity(), new CharacterJutsusFragment());
                    }
                }, new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.colorGreen))
        );
        stringBuilder.append(".");
        mBinding.linkTrainingJutsuTextView.setText(stringBuilder.getString());
        mBinding.linkTrainingJutsuTextView.setMovementMethod(LinkMovementMethod.getInstance());

        mBinding.jutsusRecyclerView.setHasFixedSize(true);
        JutsusLearnAdapter adapter = new JutsusLearnAdapter(getActivity(),
                getParentFragmentManager(), viewModel);
        mBinding.jutsusRecyclerView.setAdapter(adapter);

        viewModel.getJutsus().observe(getViewLifecycleOwner(), adapter::setJutsusList);

        viewModel.getShowCongratulationsEvent().observe(getViewLifecycleOwner(), resId -> {
            SpannableStringBuilder message = new SpannableStringBuilder();
            message.append(getText(R.string.lerned_a_new_jutsu));
            message.append(" ");

            int index = message.length();
            message.append(getString(resId));
            message.setSpan(new ForegroundColorSpan(
                            ContextCompat.getColor(getContext(), android.R.color.holo_orange_light)),
                    index, message.length(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

            message.append("\n");
            message.append(getString(R.string.keep_training));

            showTrainingResult(R.string.congratulations_you_made_it, message);

            mBinding.scrollView.post(() -> {
                mBinding.scrollView.smoothScrollTo(0, mBinding.trainingResultLayout.getTop());
                YoYo.with(Techniques.Tada)
                        .duration(1200)
                        .playOn(mBinding.trainingResultLayout);
            });
            SoundUtil.play(getContext(), R.raw.aim);
        });

        viewModel.getShowWarningEvent().observe(getViewLifecycleOwner(), resId -> {
            showTrainingResult(R.string.problem,
                    getString(R.string.insufficient_chakra_or_stamina, getString(resId)));

            mBinding.scrollView.post(() -> {
                mBinding.scrollView.smoothScrollTo(0, mBinding.trainingResultLayout.getTop());
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.problem_shake);
                animation.setRepeatCount(3);
                mBinding.trainingResultLayout.startAnimation(animation);
            });
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_learned_jutsus);
        return mBinding.getRoot();
    }

    private void showTrainingResult(@StringRes int title, CharSequence message) {
        mBinding.msgTitleTextView.setText(title);
        mBinding.msgTextView.setText(message);
        mBinding.trainingResultLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public int getDescription() {
        return R.string.leaned_jutsus;
    }
}
