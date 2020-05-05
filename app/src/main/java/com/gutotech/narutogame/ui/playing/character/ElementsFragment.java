package com.gutotech.narutogame.ui.playing.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Annotation;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Element;
import com.gutotech.narutogame.databinding.FragmentElementsBinding;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.playing.academy.ElementalJutsusFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import es.dmoral.toasty.Toasty;

public class ElementsFragment extends Fragment implements SectionFragment {
    private ElementsViewModel mViewModel;
    private FragmentElementsBinding mBinding;
    private ElementInfoPopupWindow mElementInfoPopupWindow;

    public ElementsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_elements, container, false);
        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this).get(ElementsViewModel.class);
        mBinding.setViewModel(mViewModel);

        mBinding.sectionMsgLayout.titleTextView.setText(R.string.about_elements);
        mBinding.sectionMsgLayout.descriptionTextView.setText(R.string.elements_desc);

        mElementInfoPopupWindow = new ElementInfoPopupWindow(getContext());

        mViewModel.getShowElementInfoEvent().observe(getViewLifecycleOwner(), objects -> {
            mElementInfoPopupWindow.setElement((Element) objects[0]);
            mElementInfoPopupWindow.showAsDropDown((View) objects[1]);
        });

        if (CharOn.character.getGraduationId() < 2 || CharOn.character.getClasse() == Classe.TAI
                || CharOn.character.getClasse() == Classe.BUK) {
            mBinding.learnButton.setEnabled(false);
            mBinding.learnButton.setAlpha(0.5f);
        }

        mBinding.learnButton.setOnClickListener(v -> {
            if (mViewModel.getElementSelected().getValue() == null) {
                Toasty.warning(getContext(), R.string.no_elements_selected).show();
                return;
            }

            QuestionDialogFragment dialog = QuestionDialogFragment.newInstance(
                    Html.fromHtml(getString(
                            R.string.learn_element_question,
                            mViewModel.getElementSelected().getValue().name
                    )).toString(),
                    mLearnQuestionDialogListener
            );
            dialog.openDialog(getParentFragmentManager());
            SoundUtil.play(requireContext(), R.raw.sound_pop);
        });

        mBinding.unlearnedButton.setOnClickListener(v -> {
            QuestionDialogFragment dialog = QuestionDialogFragment.newInstance(
                    R.string.unlearning_warning,
                    mUnlearnQuestionDialogListener);
            dialog.openDialog(getParentFragmentManager());
            SoundUtil.play(requireContext(), R.raw.sound_pop);
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_elements);
        return mBinding.getRoot();
    }

    private final QuestionDialogFragment.QuestionDialogListener mLearnQuestionDialogListener = () -> {
        mViewModel.learnElement();

        SpannedString titleText = (SpannedString) getText(R.string.learned_new_element_desc);
        Annotation[] annotations = titleText.getSpans(0, titleText.length(), Annotation.class);
        SpannableString spannableString = new SpannableString(titleText);
        spannableString.setSpan(
                new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        FragmentUtils.goTo(getActivity(), new ElementalJutsusFragment());
                    }
                },
                titleText.getSpanStart(annotations[0]),
                titleText.getSpanEnd(annotations[0]),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(
                new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.colorGreen)),
                titleText.getSpanStart(annotations[0]),
                titleText.getSpanEnd(annotations[0]),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mBinding.actionMsgLayout.descriptionTextView.setText(spannableString);
        mBinding.actionMsgLayout.descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());

        mBinding.actionMsgLayout.titleTextView.setText(R.string.congrats_learned_new_element);
        mBinding.actionMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

        mBinding.scrollView.post(() -> {
            mBinding.scrollView.smoothScrollTo(0,
                    mBinding.actionMsgLayout.msgConstraintLayout.getRootView().getTop());
            YoYo.with(Techniques.Pulse)
                    .duration(1200)
                    .repeat(1)
                    .playOn(mBinding.actionMsgLayout.msgConstraintLayout);
        });

        SoundUtil.play(getContext(), R.raw.aim);
    };

    private final QuestionDialogFragment.QuestionDialogListener mUnlearnQuestionDialogListener = () -> {
        if (CharOn.character.getRyous() < 3000) {
            WarningDialogFragment.newInstance(getContext(), R.string.warning_dont_have_enough_ryous)
                    .openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.attention2);
            return;
        }

        mViewModel.unlearnElement();
        CharOn.character.validateJutsus();
        CharOn.character.subRyous(3000);
        mBinding.actionMsgLayout.titleTextView.setText(R.string.unlearned_element_title);
        mBinding.actionMsgLayout.descriptionTextView.setText(R.string.unlearned_element_description);
        mBinding.actionMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

        mBinding.scrollView.post(() -> {
            mBinding.scrollView.smoothScrollTo(0,
                    mBinding.actionMsgLayout.msgConstraintLayout.getRootView().getTop());
            YoYo.with(Techniques.Flash)
                    .duration(1200)
                    .playOn(mBinding.actionMsgLayout.msgConstraintLayout);
        });
    };

    @Override
    public int getDescription() {
        return R.string.elements;
    }
}
