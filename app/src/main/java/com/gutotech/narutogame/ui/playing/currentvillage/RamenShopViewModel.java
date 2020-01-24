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

import java.util.List;

public class RamenShopViewModel extends ViewModel
        implements ItemShopRecyclerAdapter.OnBuyButtonListener {
    private SingleLiveEvent<Integer> showWarningEvent = new SingleLiveEvent<>();

    public RamenShopViewModel() {
    }

    public LiveData<Integer> getShowWarningEvent() {
        return showWarningEvent;
    }

    @Override
    public void onBuyButtonClick(ShopItem item, int quantity) {
        int price = item.getValue() * quantity;

        if (CharOn.character.getRyous() >= price) {
            CharOn.character.subRyous(price);

            int itemIndex = contains(item, CharOn.character.getBag().getRamensList());

            if (itemIndex == -1) {
                item.setRequirements(null);
                item.setInventory(quantity);
                CharOn.character.getBag().getRamensList().add((Ramen) item);
            } else {
                Ramen ramen = CharOn.character.getBag().getRamensList().get(itemIndex);
                ramen.setInventory(ramen.getInventory() + quantity);
                CharOn.character.getBag().getRamensList().set(itemIndex, ramen);
            }

            CharacterRepository.getInstance().saveCharacter(CharOn.character);

            showWarningEvent.setValue(R.string.warning_items_purchased);
        } else {
            showWarningEvent.setValue(R.string.warning_dont_have_enough_ryous);
        }
    }

    private int contains(ShopItem newItem, List<Ramen> items) {
        final int SIZE = items.size();

        for (int i = 0; i < SIZE; i++) {
            if (newItem.getName() == items.get(i).getName()) {
                return i;
            }
        }

        return -1;
    }
}
