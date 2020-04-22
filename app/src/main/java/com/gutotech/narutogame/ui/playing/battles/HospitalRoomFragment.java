package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class HospitalRoomFragment extends Fragment implements SectionFragment,
        WarningDialogFragment.WarningDialogListener {
    private int mPayment;

    public HospitalRoomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_room, container, false);

        StorageUtils.downloadProfileForMsg(getContext(), view.findViewById(R.id.profileImageView));

        CharOn.character.setMapId(CharOn.character.getVillage().ordinal());

        if (CharOn.character.getFormulas().isFull()) {
            CharOn.character.setHospital(false);
        } else {
            mPayment = 20 * CharOn.character.getLevel();

            TextView textView = view.findViewById(R.id.descriptionTextView);
            textView.setText(getString(R.string.pay_specialist_description, mPayment));

            Button payButton = view.findViewById(R.id.payButton);
            payButton.setText(getString(R.string.pay_ry, mPayment));
            payButton.setOnClickListener(view1 -> {
                if (CharOn.character.getRyous() >= mPayment) {
                    WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(
                            this, R.string.paid_hospital);
                    warningDialog.openDialog(getParentFragmentManager());
                } else {
                    WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(
                            R.string.dont_enough_money_for_treatment);
                    warningDialog.openDialog(getParentFragmentManager());
                }

                SoundUtil.play(getContext(), R.raw.sound_pop);
            });
        }

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_hospital_room);

        return view;
    }

    @Override
    public void onCloseClick() {
        CharOn.character.subRyous(mPayment);
        CharOn.character.full();
        CharOn.character.setHospital(false);
    }

    @Override
    public int getDescription() {
        return R.string.hospital;
    }
}
