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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentElementalsJutsusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.JutsusLearnAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

public class ElementalJutsusFragment extends Fragment implements SectionFragment {
    private FragmentElementalsJutsusBinding mBinding;

    public ElementalJutsusFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ElementalJutsusViewModel viewModel = new ViewModelProvider(this)
                .get(ElementalJutsusViewModel.class);

        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_elementals_jutsus, container, false);

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
                            getResources().getColor(android.R.color.holo_orange_light)),
                    index, message.length(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

            message.append("\n");
            message.append(getString(R.string.keep_training));

            showTrainingResult(R.string.congratulations_you_made_it, message);

            mBinding.scrollView.post(() -> {
                mBinding.scrollView.smoothScrollTo(0, mBinding.trainingResultLayout.getTop());
                YoYo.with(Techniques.Tada)
                        .duration(1200)
                        .repeat(1)
                        .playOn(mBinding.trainingResultLayout);
            });
        });

        viewModel.getShowWarningEvent().observe(getViewLifecycleOwner(), resId -> {
            showTrainingResult(R.string.problem,
                    getString(R.string.insufficient_chakra_or_stamina, getString(resId)));

            mBinding.scrollView.post(() -> {
                mBinding.scrollView.smoothScrollTo(0, mBinding.trainingResultLayout.getTop());
                YoYo.with(Techniques.Shake)
                        .duration(1200)
                        .repeat(2)
                        .playOn(mBinding.trainingResultLayout);
            });
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_elemental_jutsus);

        return mBinding.getRoot();
    }


    private void showTrainingResult(@StringRes int title, CharSequence message) {
        mBinding.msgTitleTextView.setText(title);
        mBinding.msgTextView.setText(message);
        mBinding.trainingResultLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public int getDescription() {
        return R.string.elemental_jutsus;
    }
}
