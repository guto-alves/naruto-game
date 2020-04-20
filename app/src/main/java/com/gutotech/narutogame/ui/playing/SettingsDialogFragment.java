package com.gutotech.narutogame.ui.playing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.utils.SettingsUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SettingsDialogFragment extends DialogFragment {

    public interface SettingsDialogListener extends Serializable {
        void onSaveClick();
    }

    private Map<String, Boolean> mSettings = new HashMap<>();

    public static SettingsDialogFragment getInstance(SettingsDialogListener listener) {
        Bundle args = new Bundle();
        args.putSerializable("listener", listener);
        SettingsDialogFragment dialog = new SettingsDialogFragment();
        dialog.setArguments(args);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_settings, container, false);

        getSettings();

        CheckBox bgMusicCheckBox = view.findViewById(R.id.bgMusicCheckBox);
        CheckBox soundFxCheckBox = view.findViewById(R.id.soundFxCheckBox);
        CheckBox notificationsCheckBox = view.findViewById(R.id.notificationsCheckBox);

        bgMusicCheckBox.setChecked(mSettings.get(SettingsUtils.BG_MUSIC_KEY));
        soundFxCheckBox.setChecked(mSettings.get(SettingsUtils.SOUND_KEY));
        notificationsCheckBox.setChecked(mSettings.get(SettingsUtils.NOTIFICATIONS_KEY));

        bgMusicCheckBox.setOnClickListener(v ->
                mSettings.put(SettingsUtils.BG_MUSIC_KEY, bgMusicCheckBox.isChecked())
        );
        soundFxCheckBox.setOnClickListener(v ->
                mSettings.put(SettingsUtils.SOUND_KEY, soundFxCheckBox.isChecked())
        );
        notificationsCheckBox.setOnClickListener(v ->
                mSettings.put(SettingsUtils.NOTIFICATIONS_KEY, notificationsCheckBox.isChecked())
        );

        view.findViewById(R.id.saveButton)
                .setOnClickListener(v -> {
                    saveSettings();
                    ((SettingsDialogListener) getArguments().getSerializable("listener"))
                            .onSaveClick();
                    dismiss();
                });

        return view;
    }

    private void getSettings() {
        mSettings.put(SettingsUtils.BG_MUSIC_KEY,
                SettingsUtils.get(getContext(), SettingsUtils.BG_MUSIC_KEY));
        mSettings.put(SettingsUtils.SOUND_KEY,
                SettingsUtils.get(getContext(), SettingsUtils.SOUND_KEY));
        mSettings.put(SettingsUtils.NOTIFICATIONS_KEY,
                SettingsUtils.get(getContext(), SettingsUtils.NOTIFICATIONS_KEY));
    }

    private void saveSettings() {
        for (String key : mSettings.keySet()) {
            SettingsUtils.set(getContext(), key, mSettings.get(key));
        }
    }
}
