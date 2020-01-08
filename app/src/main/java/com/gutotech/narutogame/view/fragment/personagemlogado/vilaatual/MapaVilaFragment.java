package com.gutotech.narutogame.view.fragment.personagemlogado.vilaatual;


import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.view.adapter.MapaGridAdapter;
import com.gutotech.narutogame.config.FirebaseConfig;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.PersonagemOn;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class MapaVilaFragment extends Fragment {
    private GridView mapa;
    private final int TAMANHO_MAPA = 140;

    private List<Personagem> personagensNoMapa = new ArrayList<>();
    private MapaGridAdapter mapaAdapter;

    private Personagem personagemOn = PersonagemOn.personagem;

    private DatabaseReference referenceMapa;
    private ValueEventListener valueEventListenerMapa;
    private ChildEventListener childEventListenerMapa;

    private long lastTouchTime = 0;
    private long currentTouchTime = 0;

    public MapaVilaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa_vila, container, false);

        if (personagemOn.getMapa_posicao() == -1) {
            personagemOn.setMapa_posicao(new SecureRandom().nextInt(TAMANHO_MAPA));
        }
        referenceMapa = FirebaseConfig.getDatabase().child("mapa_da_vila").child(personagemOn.getVila());
        DatabaseReference referenceEntrarNoMapa = FirebaseConfig.getDatabase().child("mapa_da_vila").child(personagemOn.getVila()).child(personagemOn.getNick());
        referenceEntrarNoMapa.setValue(personagemOn);

        mapa = view.findViewById(R.id.mapavila);

        String vila = personagemOn.getVila();
        if (vila.equals("Folha"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_1);
        else if (vila.equals("Areia"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_2);
        else if (vila.equals("Névoa"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_3);
        else if (vila.equals("Pedra"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_4);
        else if (vila.equals("Nuvem"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_5);
        else if (vila.equals("Akatsuki"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_6);
        else if (vila.equals("Som"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_7);
        else if (vila.equals("Chuva"))
            mapa.setBackgroundResource(R.drawable.layout_mapa_8);

        mapaAdapter = new MapaGridAdapter(getActivity(), TAMANHO_MAPA, personagensNoMapa);
        mapa.setAdapter(mapaAdapter);

        mapa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

                lastTouchTime = currentTouchTime;
                currentTouchTime = System.currentTimeMillis();

                if (currentTouchTime - lastTouchTime < 350) {
                    doubleClick(position);
                    lastTouchTime = 0;
                    currentTouchTime = 0;
                } else
                    singleClick(view, position);
            }
        });

        /*mapa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                boolean vazio = true;

                for (int i = 0; i < personagensNoMapa.size(); i++) {
                    if (personagensNoMapa.get(i).getMapa_posicao() == position) {
                        Personagem personagem = personagensNoMapa.get(i);

                        if (personagem.getNick().equals(PersonagemOn.personagem.getNick())) {
                            PopupMenu menu = new PopupMenu(getActivity(), view);
                            menu.getMenu().add("Você está aqui").setCheckable(false);
                            menu.show();
                        } else {
                            MenuBuilder menuBuilder = new MenuBuilder(getActivity());
                            MenuInflater inflater = new MenuInflater(getActivity());
                            inflater.inflate(R.menu.pop_menu_mapa, menuBuilder);
                            MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, view);
                            optionsMenu.setForceShowIcon(true);

                            menuBuilder.findItem(R.id.infoNinja).setTitle(String.format("%s [%d]", personagem.getNick(), personagem.getLevel()));
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

        atualizar();
        return view;
    }

    @SuppressLint("RestrictedApi")
    private void singleClick(final View view, final int position) {
        boolean vazio = true;

        for (int i = 0; i < personagensNoMapa.size(); i++) {
            if (personagensNoMapa.get(i).getMapa_posicao() == position) {
                Personagem personagem = personagensNoMapa.get(i);

                if (personagem.getNick().equals(PersonagemOn.personagem.getNick())) {
                    PopupMenu menu = new PopupMenu(getActivity(), view);
                    menu.getMenu().add("Você está aqui").setCheckable(false);
                    menu.show();
                } else {
                    MenuBuilder menuBuilder = new MenuBuilder(getActivity());
                    MenuInflater inflater = new MenuInflater(getActivity());
                    inflater.inflate(R.menu.pop_menu_mapa, menuBuilder);
                    MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, view);
                    optionsMenu.setForceShowIcon(true);

                    menuBuilder.findItem(R.id.infoNinja).setTitle(String.format("%s [%d]", personagem.getNick(), personagem.getLevel()));
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

    private void doubleClick(final int position) {
        personagemOn.setMapa_posicao(position);
        DatabaseReference referenceEntrarNoMapa = FirebaseConfig.getDatabase().child("mapas").child(personagemOn.getVila()).child(personagemOn.getNick());
        referenceEntrarNoMapa.setValue(personagemOn);

        /*for (int i = 0; i < personagensNoMapa.size(); i++) {
            if (personagemOn.getNick().equals(personagensNoMapa.get(i).getNick())) {
                personagensNoMapa.remove(i);
                mapaAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "teste", Toast.LENGTH_SHORT).show();
                break;
            }
        }*/
    }

    private void atualizar() {
        childEventListenerMapa = referenceMapa.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(getActivity(), "added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Personagem personagem = dataSnapshot.getValue(Personagem.class);
                for (int i = 0; i < personagensNoMapa.size(); i++) {
                    if (personagem.getNick().equals(personagensNoMapa.get(i).getNick())) {
                        personagensNoMapa.remove(i);
                        personagensNoMapa.add(i, personagem);
                        mapaAdapter.notifyDataSetChanged();

                        break;
                    }
                }
                Toast.makeText(getActivity(), "changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(getActivity(), "removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(getActivity(), "moved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void carregarPersonagens() {
        valueEventListenerMapa = referenceMapa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                personagensNoMapa.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Personagem personagem = data.getValue(Personagem.class);
                    personagensNoMapa.add(personagem);
                }

                mapaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        carregarPersonagens();
    }

    @Override
    public void onStop() {
        super.onStop();
        referenceMapa.removeEventListener(valueEventListenerMapa);
        referenceMapa.removeEventListener(childEventListenerMapa);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DatabaseReference referenceSairDoMapa = FirebaseConfig.getDatabase()
                .child("mapa")
                .child(personagemOn.getVila())
                .child(personagemOn.getNick());

        referenceSairDoMapa.removeValue();
        personagemOn.setMapa_posicao(-1);
    }
}
