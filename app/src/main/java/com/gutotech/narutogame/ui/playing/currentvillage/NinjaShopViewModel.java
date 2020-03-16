package com.gutotech.narutogame.ui.playing.currentvillage;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.ItemType;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.data.model.Scroll;
import com.gutotech.narutogame.data.model.ShopItem;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.ItemShopAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NinjaShopViewModel extends ViewModel implements
        ItemShopAdapter.OnBuyClickListener {
    private MutableLiveData<List<ShopItem>> mShopItems = new MutableLiveData<>();
    public final ObservableField<ItemType> itemTypeSelected = new ObservableField<>(ItemType.SCROLL);

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    public NinjaShopViewModel() {
        mShopItems.postValue(loadItems());
    }

    LiveData<List<ShopItem>> getShopItems() {
        return mShopItems;
    }

    public LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    public void onItemTypeSelected(ItemType type) {
        itemTypeSelected.set(type);
        mShopItems.postValue(loadItems());
    }

    private List<ShopItem> loadItems() {
        List<ShopItem> mItems = new ArrayList<>();

        if (itemTypeSelected.get() == ItemType.SCROLL) {
            mItems.add(new Scroll("1", R.string.scroll_to_leaf, R.string.scroll_to_leaf_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.FOLHA));
            mItems.add(new Scroll("2", R.string.scroll_to_sand, R.string.scroll_to_sand_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.AREIA));
            mItems.add(new Scroll("3", R.string.scroll_to_mist, R.string.scroll_to_mist_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.NEVOA));
            mItems.add(new Scroll("4", R.string.scroll_to_stone, R.string.scroll_to_stone_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.PEDRA));
            mItems.add(new Scroll("5", R.string.scroll_to_cloud, R.string.scroll_to_cloud_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.NUVEM));
            mItems.add(new Scroll("6", R.string.scroll_to_akatsuki, R.string.scroll_to_akatsuki_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.AKATSUKI));
            mItems.add(new Scroll("7", R.string.scroll_to_sound, R.string.scroll_to_sound_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.SOM));
            mItems.add(new Scroll("8", R.string.scroll_to_rain, R.string.scroll_to_rain_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.CHUVA));
            mItems.add(new Scroll("9", R.string.scroll_to_snow, R.string.scroll_to_snow_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.NEVE));
            mItems.add(new Scroll("10", R.string.scroll_to_waterfall, R.string.scroll_to_waterfall_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.CACHOEIRA));
            mItems.add(new Scroll("11", R.string.scroll_to_hot_springs, R.string.scroll_to_hot_springs_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.FONTES_TERMAIS));
            mItems.add(new Scroll("12", R.string.scroll_to_grass, R.string.scroll_to_grass_des,
                    Collections.singletonList(new Requirement() {
                        public int getValue() {
                            return 1;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getGraduationId() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_grade,
                                    context.getString(GraduationUtils.getName(getValue())));
                        }
                    }), Village.GRAMA));
        }

        return mItems;
    }

    @Override
    public void onBuyButtonClick(ShopItem item, int quantity) {
        int price = item.getValue() * quantity;

        if (CharOn.character.getRyous() >= price) {
            CharOn.character.subRyous(price);

            item.setRequirements(null);
            CharOn.character.getBag().addScroll((Scroll) item, quantity);

            CharacterRepository.getInstance().save(CharOn.character);
            mShowWarningDialogEvent.setValue(R.string.warning_items_purchased);
        } else {
            mShowWarningDialogEvent.setValue(R.string.warning_dont_have_enough_ryous);
        }
    }
}
