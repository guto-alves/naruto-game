package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.databinding.FragmentVillageMapBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.VillageMapRecyclerViewAdapter;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.utils.FragmentUtil;

public class VillageMapFragment extends Fragment implements SectionFragment {
    private VillageMapViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVillageMapBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_village_map, container, false);

        String villageName;

        Bundle bundle = getArguments();
        if (bundle != null) {
            Village village = (Village) bundle.getSerializable("village");
            villageName = village.name;
            binding.villageMapRecyclerView.setBackgroundResource(village.mapResId);
        } else {
            villageName = CharOn.character.getVillage().name;
            binding.villageMapRecyclerView.setBackgroundResource(
                    CharOn.character.getVillage().mapResId);
        }

        mViewModel = ViewModelProviders.of(this, new VillageMapViewModelFactory(villageName))
                .get(VillageMapViewModel.class);
        binding.setViewModel(mViewModel);

        VillageMapRecyclerViewAdapter adapter = new VillageMapRecyclerViewAdapter(getActivity(),
                VillageMapViewModel.MAP_LENGTH, mViewModel);

        binding.villageMapRecyclerView.setAdapter(adapter);

        mViewModel.getCharactersOnTheMap().observe(this, adapter::setCharactersOnTheMapList);


        mViewModel.getShowDialogEvent().observe(this, this::showDialog);

//
//        mapa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
//
//                lastTouchTime = currentTouchTime;
//                currentTouchTime = System.currentTimeMillis();
//
//                if (currentTouchTime - lastTouchTime < 350) {
//                    doubleClick(position);
//                    lastTouchTime = 0;
//                    currentTouchTime = 0;
//                } else
//                    singleClick(view, position);
//            }
//        });

        /*mapa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                boolean vazio = true;

                for (int i = 0; i < personagensNoMapa.size(); i++) {
                    if (personagensNoMapa.get(i).getMapa_posicao() == position) {
                        Character character = personagensNoMapa.get(i);

                        if (character.getNick().equals(PersonagemOn.character.getNick())) {
                            PopupMenu menu = new PopupMenu(getActivity(), view);
                            menu.getMenu().add("Você está aqui").setCheckable(false);
                            menu.show();
                        } else {
                            MenuBuilder menuBuilder = new MenuBuilder(getActivity());
                            MenuInflater inflater = new MenuInflater(getActivity());
                            inflater.inflate(R.menu.pop_menu_mapa, menuBuilder);
                            MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, view);
                            optionsMenu.setForceShowIcon(true);

                            menuBuilder.findItem(R.id.infoNinja).setTitle(String.format("%s [%d]", character.getNick(), character.getLevel()));
                            menuBuilder.setCallback(new MenuBuilder.Callback() {
                                @Override
                                public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                                    switch (menuItem.getItemId()) {
                                        case R.id.infoNinja:
                                            return true;
                                        case R.id.batalharMenu:
                                            Toast.makeText(getActivity(), "Batalhaar", Toast.LENGTH_SHORT).show();
                                            return true;
                                        default:
                                            return false;
                                    }
                                }

                                @Override
                                public void onMenuModeChange(MenuBuilder menuBuilder) {
                                }
                            });
                            optionsMenu.show();
                        }

                        vazio = false;
                        break;
                    }
                }

                if (vazio) {
                    PopupMenu menu = new PopupMenu(getActivity(), view);
                    menu.getMenu().add("Este local está vazio");
                    menu.show();
                }
            }
        });*/

//        atualizar();

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_village_map);

        return binding.getRoot();
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.create().show();
    }

    private void singleClick(final View view, final int position) {
        boolean vazio = true;

//        for (int i = 0; i < personagensNoMapa.size(); i++) {
//            if (personagensNoMapa.get(i).getMapa_posicao() == position) {
//                Character character = personagensNoMapa.get(i);
//
//                if (character.getNick().equals(PersonagemOn.cha.getracterNick())) {
//                    PopupMenu menu = new PopupMenu(getActivity(), view);
//                    menu.getMenu().add("Você está aqui").setCheckable(false);
//                    menu.show();
//                } else {
//                    MenuBuilder menuBuilder = new MenuBuilder(getActivity());
//                    MenuInflater inflater = new MenuInflater(getActivity());
//                    inflater.inflate(R.menu.pop_menu_mapa, menuBuilder);
//                    MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, view);
//                    optionsMenu.setForceShowIcon(true);
//
//                    menuBuilder.findItem(R.id.infoNinja).setTitle(String.format("%s [%d]", character.getNick(), character.getLevel()));
//                    menuBuilder.setCallback(new MenuBuilder.Callback() {
//                        @Override
//                        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
//                            switch (menuItem.getItemId()) {
//                                case R.id.infoNinja:
//                                    return true;
//                                case R.id.batalharMenu:
//                                    Toast.makeText(getActivity(), "Batalhaar", Toast.LENGTH_SHORT).show();
//                                    return true;
//                                default:
//                                    return false;
//                            }
//                        }
//
//                        @Override
//                        public void onMenuModeChange(MenuBuilder menuBuilder) {
//                        }
//                    });
//                    optionsMenu.show();
//                }
//
//                vazio = false;
//                break;
//            }
//        }

        if (vazio) {
            PopupMenu menu = new PopupMenu(getActivity(), view);
            menu.getMenu().add("Este local está vazio");
            menu.show();
        }
    }

    @Override
    public int getDescription() {
        return R.string.village_map;
    }
}
