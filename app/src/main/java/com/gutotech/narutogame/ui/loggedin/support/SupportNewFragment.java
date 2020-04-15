package com.gutotech.narutogame.ui.loggedin.support;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentSupportNewBinding;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class SupportNewFragment extends Fragment {
    private static final int PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private SupportNewViewModel mViewModel;
    private FragmentSupportNewBinding mBinding;

    public SupportNewFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_support_new,
                container, false);

        mViewModel = new ViewModelProvider(this).get(SupportNewViewModel.class);

        mBinding.setViewModel(mViewModel);

        mViewModel.getTicket().setDateOccurred(DateCustom.getDate());
        mBinding.dateOccurredEditText.setText(DateCustom.getDate());
        mBinding.dateOccurredEditText.setOnFocusChangeListener((v, hasFocus) -> {
            dismissKeyboard(v);
            if (hasFocus) {
                mBinding.calendarView.setVisibility(View.VISIBLE);
            } else {
                mBinding.calendarView.setVisibility(View.GONE);
            }
        });
        mBinding.dateOccurredEditText.setOnTouchListener((v, event) -> {
            dismissKeyboard(v);
            int inputType = mBinding.dateOccurredEditText.getInputType();
            mBinding.dateOccurredEditText.setInputType(InputType.TYPE_NULL);
            mBinding.dateOccurredEditText.onTouchEvent(event);
            mBinding.dateOccurredEditText.setInputType(inputType);
            return true;
        });
        mBinding.dateOccurredEditText.setOnKeyListener((v, keyCode, event) -> {
            dismissKeyboard(v);
            return false;
        });

        mBinding.calendarView.setVisibility(View.GONE);
        mBinding.calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            String date = String.format(Locale.US,
                    "%02d/%02d/%04d", dayOfMonth, month + 1, year);
            mViewModel.getTicket().setDateOccurred(date);
            mBinding.dateOccurredEditText.setText(date);
            mBinding.calendarView.setVisibility(View.GONE);
            mBinding.descriptionEditText.requestFocus();
        });


        List<String> hoursList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            hoursList.add(String.format(Locale.US, "%02d", i));
        }

        ArrayAdapter<String> hoursAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, hoursList);
        hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.hourOccurredSpinner.setAdapter(hoursAdapter);
        mBinding.hourOccurredSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.getTicket().setTimeOccurred(String.format(Locale.US,
                        "%s:%s:00", mBinding.hourOccurredSpinner.getSelectedItem(),
                        mBinding.minuteOccurredSpinner.getSelectedItem()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> minutesList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            minutesList.add(String.format(Locale.US, "%02d", i));
        }

        ArrayAdapter<String> minutesAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, minutesList);
        minutesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.minuteOccurredSpinner.setAdapter(minutesAdapter);
        mBinding.minuteOccurredSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.getTicket().setTimeOccurred(String.format(Locale.US,
                        "%s:%s:00", mBinding.hourOccurredSpinner.getSelectedItem(),
                        mBinding.minuteOccurredSpinner.getSelectedItem()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mBinding.attachImageButton.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSION_REQUEST_READ_EXTERNAL_STORAGE);
            } else {
                openGallery();
            }
        });

        mViewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), messageIds -> {
            StringBuilder message = new StringBuilder();

            message.append(getString(R.string.ticket_errors)).append("\n\n");

            for (int messageId : messageIds) {
                message.append(getString(messageId)).append("\n");
            }

            WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(message.toString());
            warningDialog.openDialog(getParentFragmentManager());
        });

        mViewModel.getTicketCreatedEvent().observe(getViewLifecycleOwner(), aVoid -> {
            SupportFragment supportFragment = new SupportFragment();
            supportFragment.setArguments(new Bundle());
            FragmentUtil.popBackStack(getActivity(), this, supportFragment);
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_support_new_ticket);

        return mBinding.getRoot();
    }

    private void dismissKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(intent, 200);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = null;

            try {
                if (requestCode == 200) {
                    Uri uri = data.getData();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        bitmap = ImageDecoder.decodeBitmap(
                                ImageDecoder.createSource(
                                        getActivity().getContentResolver(), uri
                                ));
                    } else {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    }
                }

                if (bitmap != null) {
                    StorageUtils.upload(bitmap, imageName -> {
                                mViewModel.getTicket().setImage(imageName);
                                mBinding.imageNameTextView.setText(imageName);
                            },
                            exception ->
                                    Toasty.error(getActivity(),
                                            R.string.error_uploading_image,
                                            Toasty.LENGTH_SHORT)
                                            .show()
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                showAlertPermissionDenied();
            }
        }
    }

    private void showAlertPermissionDenied() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.permission_denied);
        builder.setMessage(R.string.permission_denied_message);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", null);
        builder.create();
        builder.show();
    }
}
