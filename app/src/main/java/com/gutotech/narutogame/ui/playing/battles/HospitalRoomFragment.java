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
import com.gutotech.narutogame.ui.WarningDialog;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class HospitalRoomFragment extends Fragment implements SectionFragment {

    public HospitalRoomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_room, container, false);

        StorageUtil.downloadProfileForMsg(getContext(), view.findViewById(R.id.profileImageView));

        if (CharOn.character.getFormulas().isFull()) {
            CharOn.character.setHospital(false);
        } else {
            int payment = 20 * CharOn.character.getLevel();

            TextView textView = view.findViewById(R.id.descriptionTextView);
            textView.setText(getString(R.string.pay_specialist_description, payment));

            Button payButton = view.findViewById(R.id.payButton);
            payButton.setText(getString(R.string.pay_ry, payment));
            payButton.setOnClickListener(view1 -> {
                if (CharOn.character.getRyous() >= payment) {
                    WarningDialog warningDialog = new WarningDialog(getString(R.string.paid_hospital));
                    warningDialog.setOnCloseListener(view2 -> {
                        CharOn.character.subRyous(payment);
                        CharOn.character.full();
                        CharOn.character.setHospital(false);
                    });
                    warningDialog.show(getParentFragmentManager(), "WarningDialog");
                } else {
                    // you don't have ryous enough
                }
            });
        }

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_hospital_room);

        return view;
    }

    @Override
    public int getDescription() {
        return R.string.hospital;
    }
}
