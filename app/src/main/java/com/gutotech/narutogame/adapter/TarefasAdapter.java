package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.MissaoDeTempo;
import com.gutotech.narutogame.model.Tarefa;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.List;

public class TarefasAdapter extends RecyclerView.Adapter<TarefasAdapter.MyViewHolder> {
    private Context context;
    private List<MissaoDeTempo> tarefas;

    public TarefasAdapter(Context context, List<MissaoDeTempo> tarefas) {
        this.context = context;
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_tarefas, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final MissaoDeTempo tarefa = tarefas.get(i);

        myViewHolder.titulo.setText(tarefa.getTitulo());
        myViewHolder.descricao.setText(tarefa.getDescricao());
        myViewHolder.graduacao.setText(tarefa.getGraduacao());
        myViewHolder.level.setText("Lvl. " + tarefa.getLevel());

        if (tarefa.getLevel() > PersonagemOn.personagem.getLevel())
            myViewHolder.aceitar.setEnabled(false);
        else {
            myViewHolder.aceitar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tarefa.aceitarMissao(i);
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
        return tarefas.size();
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
