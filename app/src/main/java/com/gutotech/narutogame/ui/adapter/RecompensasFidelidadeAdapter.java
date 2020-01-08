package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.data.model.RecompensaFidelidade;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.List;
import java.util.Locale;

public class RecompensasFidelidadeAdapter extends BaseAdapter {
    private Context context;
    private List<RecompensaFidelidade> recompensas;

    public RecompensasFidelidadeAdapter(Context context, List<RecompensaFidelidade> recompensas) {
        this.context = context;
        this.recompensas = recompensas;
    }

    @Override
    public int getCount() {
        return recompensas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridview_recompensas_fidelidade, null, false);
        }

        final int dia = position + 1;

        final RecompensaFidelidade recompensa = recompensas.get(position);

        ImageView diaImageView = convertView.findViewById(R.id.diaImageView);
        StorageUtil.baixarFidelityDia(context, diaImageView, dia);

        TextView diaTextView = convertView.findViewById(R.id.diaTextView);
        diaTextView.setText(String.format(Locale.getDefault(), "Logar %d dia(s) seguidos", dia));

        TextView recompensaTextView = convertView.findViewById(R.id.recompensaTextView);
        recompensaTextView.setText(recompensa.toString());

        Button receberButton = convertView.findViewById(R.id.receberButton);

        final int diasLogadosFidelidade = PersonagemOn.personagem.getDiasLogadosFidelidade();

        if (dia == diasLogadosFidelidade && PersonagemOn.personagem.isTemRecompensaFidelidade()) {
            receberButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    recompensa.receberRecompensa(dia);
                }
            });
        } else {
            receberButton.setEnabled(false);

            if (dia >= diasLogadosFidelidade) {
                receberButton.setText(R.string.button_nao_recebido);
                receberButton.setBackgroundColor(Color.RED);
            } else {
                receberButton.setText(R.string.button_recebido);
                receberButton.setBackgroundColor(Color.GREEN);
            }
        }

        return convertView;
    }
}
