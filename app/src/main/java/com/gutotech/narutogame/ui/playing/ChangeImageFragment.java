package com.gutotech.narutogame.ui.playing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ProfilesAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class ChangeImageFragment extends Fragment implements SectionFragment,
        QuestionDialogFragment.QuestionDialogListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_image, container, false);

        RecyclerView profilesRecyclerView = view.findViewById(R.id.profilesRecyclerView);
        profilesRecyclerView.setHasFixedSize(true);

        ProfilesAdapter adapter = new ProfilesAdapter(mOnProfileClickListener);
        profilesRecyclerView.setAdapter(adapter);

        ChangeImageViewModel viewModel = new ViewModelProvider(this)
                .get(ChangeImageViewModel.class);

        viewModel.getStorageRefs().observe(getViewLifecycleOwner(), adapter::setProfileList);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_change_image);

        return view;
    }

    private String mProfilePath;

    private final ProfilesAdapter.OnProfileClickListener mOnProfileClickListener = profilePath -> {
        mProfilePath = profilePath;

        QuestionDialogFragment questionDialog = QuestionDialogFragment.newInstance(
                this, R.string.question_change_profile_image);
        questionDialog.openDialog(getParentFragmentManager());
    };

    @Override
    public void onPositiveClick() {
        CharOn.character.setProfilePath(mProfilePath);

        try {
            DrawerLayout drawer = getActivity().findViewById(R.id.drawerLayout);
            drawer.openDrawer(GravityCompat.START);
            ScrollView scrollView = getActivity().findViewById(R.id.scrollView);
            scrollView.post(() -> scrollView.smoothScrollTo(0, 0));
        } catch (NullPointerException ignored) {
        }
    }

    public void onCancelClick() {
    }

    @Override
    public int getDescription() {
        return 0;
    }
}
