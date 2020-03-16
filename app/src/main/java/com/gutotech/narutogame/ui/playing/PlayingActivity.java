package com.gutotech.narutogame.ui.playing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.databinding.ActivityPlayingBinding;
import com.gutotech.narutogame.databinding.DialogGameRoutinesBinding;
import com.gutotech.narutogame.databinding.NavHeaderPlayingBinding;
import com.gutotech.narutogame.ui.WarningDialog;
import com.gutotech.narutogame.ui.adapter.BagItemsAdapter;
import com.gutotech.narutogame.ui.adapter.ChatMessageAdapter;
import com.gutotech.narutogame.ui.adapter.ExpandableLoggedinAdapter;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayingActivity extends AppCompatActivity {
    private ActivityPlayingBinding mBinding;
    private PlayingViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlayingViewModel.class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_playing);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(mViewModel);

        NavHeaderPlayingBinding navHeaderBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_playing, mBinding.navView, false);
        mBinding.navView.addHeaderView(navHeaderBinding.getRoot());
        navHeaderBinding.setViewModel(mViewModel);

        ExpandableLoggedinAdapter menuAdapter = new ExpandableLoggedinAdapter();
        mBinding.expandableListView.setAdapter(menuAdapter);
        mViewModel.getMenuGroups().observe(this, menuAdapter::setMenuGroups);
        mBinding.expandableListView.setOnChildClickListener(mViewModel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mViewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtil.goTo(this, (Fragment) sectionFragment);
            closeDrawer();
        });

        mViewModel.getTitles().observe(this, titlesId -> {
            List<String> titles = new ArrayList<>();

            for (int titleId : titlesId) {
                titles.add(getString(titleId));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, titles);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            mBinding.titlesSpinner.setAdapter(adapter);
        });

        mViewModel.getShowWarningDialogEvent().observe(this, resid -> {
            WarningDialog dialog = WarningDialog.newInstance(resid);
            dialog.openDialog(getSupportFragmentManager());
        });

        setUpChat();
    }

    public void showGameRoutines(View view) {
        Dialog routinesDialog = new Dialog(this);
        routinesDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        DialogGameRoutinesBinding binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.dialog_game_routines, null, false);

        routinesDialog.setContentView(binding.getRoot());

        binding.setViewModel(mViewModel);

        routinesDialog.show();
    }

    public void showBag(View view) {
        Dialog bagDialog = new Dialog(this);
        bagDialog.setContentView(R.layout.dialog_bag);

        RecyclerView ramensRecyclerView = bagDialog.findViewById(R.id.ramensRecyclerView);
        RecyclerView scrollsRecyclerView = bagDialog.findViewById(R.id.scrollsRecyclerView);

        ramensRecyclerView.setHasFixedSize(true);
        scrollsRecyclerView.setHasFixedSize(true);

        mViewModel.updateBag();

        mViewModel.getDismissBagDialog().observe(this, aVoid -> bagDialog.dismiss());

        BagItemsAdapter ramensAdapter = new BagItemsAdapter(this,
                mViewModel.onRamenClickListener);
        ramensRecyclerView.setAdapter(ramensAdapter);

        mViewModel.getRamens().observe(this, ramens -> {
            LinearLayout ramensLinearLayout = bagDialog.findViewById(R.id.ramensLinearLayout);
            if (ramens != null) {
                ramensAdapter.setItems(new ArrayList<>(ramens));
                ramensLinearLayout.setVisibility(View.VISIBLE);
            } else {
                ramensLinearLayout.setVisibility(View.GONE);
            }
        });

        BagItemsAdapter scrollsAdapter = new BagItemsAdapter(this,
                mViewModel.onScrollClickListener);
        scrollsRecyclerView.setAdapter(scrollsAdapter);

        mViewModel.getScrolls().observe(this, scrolls -> {
            LinearLayout scrollsLinearLayout = bagDialog.findViewById(R.id.scrollsLinearLayout);

            if (scrolls != null) {
                scrollsAdapter.setItems(new ArrayList<>(scrolls));
                scrollsLinearLayout.setVisibility(View.VISIBLE);
            } else {
                scrollsLinearLayout.setVisibility(View.GONE);
            }
        });

        bagDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bagDialog.show();
    }

    private void setUpChat() {
        mViewModel.getStartChatAnimationEvent().observe(this, openChat -> {
            Animation animation;

            if (openChat) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                mBinding.scrollView.postDelayed(() ->
                                mBinding.scrollView.smoothScrollTo(0, mBinding.scrollView.getBottom() + 500),
                        500);
            } else {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
            }

            mBinding.chatTopImageView.startAnimation(animation);
        });

        mBinding.messagesRecyclerView.setHasFixedSize(true);
        ChatMessageAdapter adapter = new ChatMessageAdapter(this);
        mBinding.messagesRecyclerView.setAdapter(adapter);
        mViewModel.getChatMessages().observe(this, messages -> {
            adapter.setMessageList(messages);
            mBinding.messagesRecyclerView.smoothScrollToPosition(adapter.getItemCount());
        });

        mBinding.messageEditText.setOnEditorActionListener((v, actionId, event) -> {
            mViewModel.onSendMessageButtonPressed();
            return true;
        });
    }

    public void onLogoutClick(View view) {
        mViewModel.logout();
        AuthRepository.getInstance().signOut();
        startActivity(new Intent(PlayingActivity.this, HomeActivity.class));
        finish();
    }

    public void closeDrawer() {
        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
    }


    // Pinch to zoom
    private ScaleGestureDetector mScaleGestureDetector;

    public void registerScaleGestureDetector(ScaleGestureDetector scaleGestureDetector) {
        mScaleGestureDetector = scaleGestureDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mScaleGestureDetector != null) {
            mScaleGestureDetector.onTouchEvent(event);
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mScaleGestureDetector != null) {
            mScaleGestureDetector.onTouchEvent(ev);
        }

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public void onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.destroy();
    }
}
