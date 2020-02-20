package com.gutotech.narutogame.ui.playing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Bag;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.databinding.ActivityPlayingBinding;
import com.gutotech.narutogame.databinding.DialogGameRoutinesBinding;
import com.gutotech.narutogame.databinding.NavHeaderPlayingBinding;
import com.gutotech.narutogame.ui.adapter.ChatMessageAdapter;
import com.gutotech.narutogame.ui.adapter.ExpandableLoggedinAdapter;
import com.gutotech.narutogame.ui.adapter.BagItemsAdapter;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {
    private ActivityPlayingBinding mBinding;
    private PlayingViewModel mViewModel;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayingViewModel.class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_playing);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(mViewModel);

        drawer = findViewById(R.id.drawerLayout);

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

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mViewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtil.goTo(this, (Fragment) sectionFragment);
            closeDrawer();
        });

        setUpChat();
    }

    private void setUpChat() {
        mViewModel.getStartChatAnimationEvent().observe(this, openChat -> {
            Animation animation;

            if (openChat) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                mBinding.scrollView.post(() -> mBinding.scrollView.fullScroll(View.FOCUS_DOWN));
                mBinding.scrollView.fullScroll(View.FOCUS_DOWN);
                mBinding.scrollView.post(() ->
                        mBinding.scrollView.smoothScrollTo(0, mBinding.scrollView.getBottom()));
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

        RecyclerView pergaminhosRecyclerView = bagDialog.findViewById(R.id.pergaminhosRecyclerView);
        RecyclerView rangedWaponsRecyclerView = bagDialog.findViewById(R.id.rangedWaponsRecyclerView);

        Bag bag = CharOn.character.getBag();

        if (bag.getRamensList() != null) {
            RecyclerView ramensRecyclerView = bagDialog.findViewById(R.id.ramensRecyclerView);
            ramensRecyclerView.setHasFixedSize(true);

            BagItemsAdapter bagItemsAdapter = new BagItemsAdapter(this,
                    new ArrayList<>(bag.getRamensList()),
                    (item, position) -> {
                        Ramen ramen = (Ramen) item;
                        CharOn.character.getAttributes().getFormulas().addHeath(ramen.getRecovers());
                        CharOn.character.getAttributes().getFormulas().addChakra(ramen.getRecovers());
                        CharOn.character.getAttributes().getFormulas().addStamina(ramen.getRecovers());
                        int inventory = ramen.getInventory() - 1;
                        if (inventory != 0) {
                            bag.getRamensList().set(position, ramen);
                        } else {
                            bag.getRamensList().remove(position);
                        }

                        ramensRecyclerView.getAdapter().notifyDataSetChanged();
                        CharOn.character.setBag(bag);
                        CharacterRepository.getInstance().save(CharOn.character);
                    });
            ramensRecyclerView.setAdapter(bagItemsAdapter);
        } else {
            LinearLayout ramensLinearLayout = bagDialog.findViewById(R.id.ramensLinearLayout);
            ramensLinearLayout.setVisibility(View.GONE);
        }

        bagDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bagDialog.show();
    }

    public void atualizarInformacoes() {
//        if (PersonagemOn.character.isTemRecompensaFidelidade())
//            fidelityImageButton.setImageResource(R.drawable.layout_icones_gift);
//        else
//          fidelityImageButton.setImageResource(R.drawable.layout_icones_gift2);
    }

    public void logout(View view) {
        logout();
        AuthRepository.getInstance().signOut();
        startActivity(new Intent(PlayingActivity.this, HomeActivity.class));
        finish();
    }

    private void logout() {
        mViewModel.logout();
    }

    public void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
        logout();
    }
}
