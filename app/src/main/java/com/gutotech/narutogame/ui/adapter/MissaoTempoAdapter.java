package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.MissaoDeTempo;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.List;

public class MissaoTempoAdapter extends RecyclerView.Adapter<MissaoTempoAdapter.MyViewHolder> {
    private Context context;
    private List<MissaoDeTempo> missaoDeTempos;

    public MissaoTempoAdapter(Context context, List<MissaoDeTempo> tarefas) {
        this.context = context;
        this.missaoDeTempos = tarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_tarefas, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final MissaoDeTempo missao = missaoDeTempos.get(i);

        myViewHolder.titulo.setText(missao.getTitulo());
        myViewHolder.descricao.setText(missao.getDescricao());
        myViewHolder.graduacao.setText(missao.getGraduacao());
        myViewHolder.level.setText("Lvl. " + missao.getLevel());

        if (missao.getLevel() > PersonagemOn.character.getLevel()) {
            myViewHolder.aceitar.setEnabled(false);
            myViewHolder.aceitar.setOnClickListener(null);
        } else {
            myViewHolder.aceitar.setEnabled(true);
            myViewHolder.aceitar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    missao.aceitarMissao(i);
                }
            });
        }

        if (i % 2 == 0)
            myViewHolder.bgLayout.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgLayout.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return missaoDeTempos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView descricao;
        private TextView graduacao;
        private TextView level;
        private Button aceitar;
        private ConstraintLayout bgLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tituloTarefaTextView);
            descricao = itemView.findViewById(R.id.descricaoTarefaTextView);
            graduacao = itemView.findViewById(R.id.graduacaoTarefaTextView);
            level = itemView.findViewById(R.id.lvlTarefaTextView);
            aceitar = itemView.findViewById(R.id.aceitarTarefaButton);
            bgLayout = itemView.findViewById(R.id.bgLayout);
        }
    }
}
