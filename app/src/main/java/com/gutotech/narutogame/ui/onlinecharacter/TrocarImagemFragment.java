package com.gutotech.narutogame.ui.onlinecharacter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.ProfilesAdapter;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.utils.Helper;
import com.gutotech.narutogame.data.model.PersonagemOn;

public class TrocarImagemFragment extends Fragment {

    public TrocarImagemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trocar_imagem, container, false);

        GridView gridView = view.findViewById(R.id.profilesGridView);
        ProfilesAdapter profilesAdapter = new ProfilesAdapter(getActivity(),
                Helper.quantasImagens(PersonagemOn.character.getNinja().getId()));
        gridView.setAdapter(profilesAdapter);
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Aviso");
            builder.setMessage("Deseja alterar a imagem do seu character para escolhida?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    PersonagemOn.character.setProfile(position + 1);

                    ImageView profileLogadoimageView = getActivity().findViewById(R.id.profilePersonagemOnImageView);
                    StorageUtil.downloadProfile(getActivity(), profileLogadoimageView,
                            PersonagemOn.character.getNinja().getId(), PersonagemOn.character.getProfile());

                    PersonagemOn.character.salvar();

                    DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
                    drawer.openDrawer(GravityCompat.START);
                }
            });
            builder.setNegativeButton("Cancelar", null);
            builder.setCancelable(false);
            builder.create();
            builder.show();
        });

        return view;
    }
}
