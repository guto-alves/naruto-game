package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.ShopItem;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class RamenShopViewModel extends ViewModel
        implements ItemShopRecyclerAdapter.OnBuyClickListener {
    private SingleLiveEvent<Integer> showWarningEvent = new SingleLiveEvent<>();

    public RamenShopViewModel() {
    }

    LiveData<Integer> getShowWarningEvent() {
        return showWarningEvent;
    }

    @Override
    public void onBuyButtonClick(ShopItem item, int quantity) {
        int price = item.getValue() * quantity;

        if (CharOn.character.getRyous() >= price) {
            CharOn.character.subRyous(price);

            CharOn.character.getBag().addRamen((Ramen) item, quantity);

            CharacterRepository.getInstance().save(CharOn.character);

            showWarningEvent.setValue(R.string.warning_items_purchased);
        } else {
            showWarningEvent.setValue(R.string.warning_dont_have_enough_ryous);
        }
    }
}
