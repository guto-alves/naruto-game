package com.gutotech.narutogame.ui.playing.character;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.Reward;
import com.gutotech.narutogame.data.model.RewardAdapter;
import com.gutotech.narutogame.ui.adapter.FidelityRewardsAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

public class FidelityViewModel extends ViewModel
        implements FidelityRewardsAdapter.OnReceiveClickListener {
    private MutableLiveData<List<Reward>> mRewards;

    private SingleLiveEvent<Void> mUpdateFidelityRewards = new SingleLiveEvent<>();

    public FidelityViewModel() {
        mRewards = new MutableLiveData<>();
        mRewards.postValue(loadRewards());
    }

    @Override
    public void onReceiveClick(Reward reward) {
        reward.receive();
        CharOn.character.setFidelityReward(false);
        mUpdateFidelityRewards.call();
    }

    private List<Reward> loadRewards() {
        List<Reward> rewards = new ArrayList<>();

        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 100;
            }

            @Override
            public void receive() {
                CharOn.character.addRyous(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_ryous, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 200;
            }

            @Override
            public void receive() {
                CharOn.character.incrementExp(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_experience, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 300;
            }

            @Override
            public void receive() {
                CharOn.character.addRyous(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_ryous, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 400;
            }

            @Override
            public void receive() {
                CharOn.character.incrementExp(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_experience, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 1000;
            }

            @Override
            public void receive() {
                CharOn.character.addRyous(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_ryous, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 5;
            }

            @Override
            public void receive() {
                CharOn.character.getBag().addRamen(
                        new Ramen("Shio_Tyashu-Ramen", R.string.shio_tyashu_ramen,
                                R.string.shio_tyashu_ramen_description, 140, 600),
                        value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.reward_in_ramen, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 2000;
            }

            @Override
            public void receive() {
                CharOn.character.addRyous(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_ryous, value());
            }
        });
        rewards.add(new RewardAdapter() {
            @Override
            public int value() {
                return 3000;
            }

            @Override
            public void receive() {
                CharOn.character.addRyous(value());
            }

            @Override
            public CharSequence toString(Context context) {
                return context.getString(R.string.value_in_ryous, value());
            }
        });

        return rewards;
    }

    LiveData<List<Reward>> getRewards() {
        return mRewards;
    }

    LiveData<Void> getUpdateFidelityRewards() {
        return mUpdateFidelityRewards;
    }
}
