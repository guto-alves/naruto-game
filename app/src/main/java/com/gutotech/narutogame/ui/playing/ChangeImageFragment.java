package com.gutotech.narutogame.ui.playing;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.ui.QuestionDialog;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ProfilesAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class ChangeImageFragment extends Fragment implements SectionFragment, QuestionDialog.OnButtonsClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_image, container, false);

        RecyclerView profilesRecyclerView = view.findViewById(R.id.profilesRecyclerView);
        profilesRecyclerView.setHasFixedSize(true);

        StorageUtil.listAll(
                String.format("images/profile/%s/", CharOn.character.getNinja().getId()),
                data -> {
                    ProfilesAdapter adapter = new ProfilesAdapter(data, mOnProfileClickListener);
                    profilesRecyclerView.setAdapter(adapter);
                });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_change_image);

        return view;
    }

    private String mProfilePath;

    private final ProfilesAdapter.OnProfileClickListener mOnProfileClickListener = profilePath -> {
        mProfilePath = profilePath;

        QuestionDialog questionDialog = QuestionDialog.newInstance(
                R.string.question_change_profile_image);
        questionDialog.openDialog(getParentFragmentManager());
    };

    @Override
    public void onPositiveClick() {
        CharOn.character.setProfilePath(mProfilePath);

        DrawerLayout drawer = getActivity().findViewById(R.id.drawerLayout);
        drawer.openDrawer(GravityCompat.START);
    }

    public void onCancelClick() {
    }

    @Override
    public int getDescription() {
        return 0;
    }
}
