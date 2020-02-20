package com.gutotech.narutogame.ui.playing.currentvillage;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.ItemType;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.data.model.Scroll;
import com.gutotech.narutogame.data.model.ShopItem;
import com.gutotech.narutogame.data.model.ShopUtils;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.ui.adapter.ItemShopRecyclerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NinjaShopViewModel extends ViewModel implements
        ItemShopRecyclerAdapter.OnBuyClickListener {

    private MutableLiveData<List<ShopItem>> mShopItems = new MutableLiveData<>();
    private ItemType mItemTypeSelected;

    private ShopUtils shop = new ShopUtils();

    public NinjaShopViewModel() {
        mItemTypeSelected = ItemType.SCROLL;
        mShopItems.postValue(loadItems());
    }

    public ItemType getItemTypeSelected() {
        return mItemTypeSelected;
    }

    public LiveData<List<ShopItem>> getShopItems() {
        return mShopItems;
    }

    public void onItemTypeSelected(ItemType type) {
        mItemTypeSelected = type;
    }

    public List<ShopItem> loadItems() {
        List<ShopItem> mItems = new ArrayList<>();

        mItems.add(new Scroll("1", R.string.scroll_to_leaf, R.string.scroll_to_leaf_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.FOLHA));

        mItems.add(new Scroll("2", R.string.scroll_to_sand, R.string.scroll_to_sand_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.AREIA));

        mItems.add(new Scroll("3", R.string.scroll_to_mist, R.string.scroll_to_mist_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.NEVOA));

        mItems.add(new Scroll("4", R.string.scroll_to_stone, R.string.scroll_to_stone_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.PEDRA));

        mItems.add(new Scroll("5", R.string.scroll_to_cloud, R.string.scroll_to_cloud_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.NUVEM));

        mItems.add(new Scroll("6", R.string.scroll_to_akatsuki, R.string.scroll_to_akatsuki_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.AKATSUKI));

        mItems.add(new Scroll("7", R.string.scroll_to_sound, R.string.scroll_to_sound_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.SOM));

        mItems.add(new Scroll("8", R.string.scroll_to_rain, R.string.scroll_to_rain_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.CHUVA));

        mItems.add(new Scroll("9", R.string.scroll_to_snow, R.string.scroll_to_snow_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.NEVE));

        mItems.add(new Scroll("10", R.string.scroll_to_waterfall, R.string.scroll_to_waterfall_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.CACHOEIRA));

        mItems.add(new Scroll("11", R.string.scroll_to_hot_springs, R.string.scroll_to_hot_springs_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.FONTES_TERMAIS));

        mItems.add(new Scroll("12", R.string.scroll_to_grass, R.string.scroll_to_grass_des,
                Collections.singletonList(new Requirement() {
                    @Override
                    public Object value() {
                        return 5;
                    }

                    @Override
                    public boolean check() {
                        return CharOn.character.getLevel() >= (int) value();
                    }

                    @Override
                    public String toString(Context context) {
                        return context.getString(R.string.requires_level, (int) value());
                    }
                }), Village.GRAMA));

        return mItems;
    }

    @Override
    public void onBuyButtonClick(ShopItem item, int quantity) {
        item.setRequirements(null);

    }
}
