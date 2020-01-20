package com.gutotech.narutogame.ui.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Arma;
import com.gutotech.narutogame.data.model.Graduacao;
import com.gutotech.narutogame.data.model.ItemShop;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.List;
import java.util.Locale;

public class ItemShopRecyclerAdapter extends RecyclerView.Adapter<ItemShopRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<ItemShop> itensList;

    public ItemShopRecyclerAdapter(Context context, List<ItemShop> itensList) {
        this.itensList = itensList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_shop_item, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final ItemShop itemShop = itensList.get(i);

        switch (itemShop.getTipoItem()) {
            case RAMEN:
                StorageUtil.downloadRamen(context, myViewHolder.itemImageView, itemShop.getImage());
                myViewHolder.itemImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        exibirRecuperaRamen((Ramen) itemShop);
                    }
                });
                break;
            case ARMA:
                Arma arma = (Arma) itemShop;

                if (arma.getAlcance() == Arma.Alcance.LONGO)
                    StorageUtil.baixarArmaImage(context, myViewHolder.itemImageView, itemShop.getImage(), "longo");
                else
                    StorageUtil.baixarArmaImage(context, myViewHolder.itemImageView, itemShop.getImage(), "curto");

                myViewHolder.itemImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case PERGAMINHO:
                StorageUtil.baixarPergaminhoImage(context, myViewHolder.itemImageView, itemShop.getImage());
                myViewHolder.itemImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                break;
        }

        myViewHolder.nomeTextView.setText(itemShop.getNome());
        myViewHolder.requerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirRequerimentos(itemShop.getRequerGraducao(), Graduacao.getGraducao(itemShop.getRequerGraducao()), itemShop.getRequerLevel());
            }
        });
        myViewHolder.descricaoTextView.setText(itemShop.getDescricao());

        if (itemShop.getTipoPgto() == ItemShop.TipoPgto.RYOUS)
            myViewHolder.valorTextView.setText("RY$ " + itemShop.getValor());
        else
            myViewHolder.valorTextView.setText(itemShop.getValor() + " Créditos\nVip");


        if (validarRequerimentos(itemShop.getRequerGraducao(), itemShop.getRequerLevel())) {
            myViewHolder.comprarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!myViewHolder.qtdeEditText.getText().toString().isEmpty()) {
                        int quantidade = Integer.parseInt(myViewHolder.qtdeEditText.getText().toString());
                        int total_a_pagar = itemShop.getValor() * quantidade;

                        if (CharOn.character.getRyous() >= total_a_pagar) {
                            CharOn.character.setRyous(CharOn.character.getRyous() - total_a_pagar);
                            CharOn.character.getBag().getRamensList().add((Ramen) itemShop);
                            CharOn.character.salvar();
                            exibirAlerta("Item(s) comprado(s) com sucesso");
                        } else
                            exibirAlerta("Você não tem ryous suficientes para comprar essa quantidade");
                    }
                }
            });
            myViewHolder.comprarButton.setEnabled(true);
            myViewHolder.comprarButton.setClickable(true);
        } else {
            myViewHolder.comprarButton.setEnabled(false);
            myViewHolder.comprarButton.setClickable(false);
            myViewHolder.comprarButton.setOnClickListener(null);
        }

        Arma arma = new Arma();
        if (itemShop.getTipoItem() == ItemShop.TipoItem.ARMA)
            arma = (Arma) itemShop;

        if (itemShop.getTipoItem() == ItemShop.TipoItem.RAMEN || arma.getAlcance() == Arma.Alcance.LONGO) {
            myViewHolder.qtdeEditText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (!myViewHolder.qtdeEditText.getText().toString().isEmpty()) {
                        int quantidade = Integer.parseInt(myViewHolder.qtdeEditText.getText().toString());
                        myViewHolder.valorTextView.setText("RY$ " + itemShop.getValor() * quantidade);
                    }
                    return false;
                }
            });
            myViewHolder.qtdeEditText.setEnabled(true);
            myViewHolder.qtdeEditText.setText("1");
        } else {
            myViewHolder.qtdeEditText.setOnKeyListener(null);
            myViewHolder.qtdeEditText.setEnabled(false);
            myViewHolder.qtdeEditText.setText("x1");
        }

        if (i % 2 == 0)
            myViewHolder.bgLayout.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgLayout.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    private void exibirRecuperaRamen(Ramen ramen) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_info_ramen);

        TextView nomeTextView = dialog.findViewById(R.id.nomeTextView);
        TextView recuperaHp = dialog.findViewById(R.id.recuperaHpTextView);
        TextView recuperaChak = dialog.findViewById(R.id.recuperaChakraTextView);
        TextView recuperaSta = dialog.findViewById(R.id.recuperaStaminaTextView);

        nomeTextView.setText(ramen.getNome());

        recuperaHp.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecupera()));
        recuperaChak.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecupera()));
        recuperaSta.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecupera()));
        dialog.show();
    }

    private boolean validarRequerimentos(int graduacao, int level) {
//        return PersonagemOn.character.getIdGraducao() >= graduacao && PersonagemOn.character.getLevel() >= level;
        return false;
    }

    private void exibirRequerimentos(int numGraduacao, String graduacao, int level) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_requerimento);
        TextView graduacaoTextView = dialog.findViewById(R.id.requerGraduacaoTextView);
        TextView levelTextView = dialog.findViewById(R.id.requerLevelTextView);

        graduacaoTextView.setText(String.format(Locale.getDefault(), "Requer graduação: %s", graduacao));
        levelTextView.setText(String.format(Locale.getDefault(), "Requer level %d ou maior", level));

        if (level == 0)
            levelTextView.setVisibility(View.GONE);

        if (!validarRequerimentos(numGraduacao, level)) {
            graduacaoTextView.setTextColor(Color.RED);
            levelTextView.setTextColor(Color.RED);
        } else {
            graduacaoTextView.setPaintFlags(graduacaoTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            levelTextView.setPaintFlags(levelTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        dialog.show();
    }

    private void exibirAlerta(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Aviso!");
        builder.setMessage(message);
        builder.setPositiveButton("Fechar", null);
        builder.setCancelable(false);
        builder.create();
        builder.show();
    }

    @Override
    public int getItemCount() {
        return itensList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView nomeTextView;
        private TextView descricaoTextView;
        private TextView valorTextView;
        private ImageView requerImageView;
        private EditText qtdeEditText;
        private Button comprarButton;
        private ConstraintLayout bgLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            nomeTextView = itemView.findViewById(R.id.nomeItemTextView);
            descricaoTextView = itemView.findViewById(R.id.descriTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            valorTextView = itemView.findViewById(R.id.valorTextView);
            qtdeEditText = itemView.findViewById(R.id.qtdEditText);
            comprarButton = itemView.findViewById(R.id.comprarButton);
            bgLayout = itemView.findViewById(R.id.bgLayout);
        }
    }
}
