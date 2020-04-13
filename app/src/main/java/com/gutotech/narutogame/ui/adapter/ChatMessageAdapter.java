package com.gutotech.narutogame.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Message;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView senderTextView;
        private TextView messageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            senderTextView = itemView.findViewById(R.id.senderTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
        }
    }

    private Context context;
    private List<Message> messageList;

    public ChatMessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_chat_message, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if (messageList != null) {
            Message message = messageList.get(i);

            holder.senderTextView.setText(context.getString(R.string.sender, message.getSender()));
            holder.messageTextView.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList != null ? messageList.size() : 0;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
        notifyDataSetChanged();
    }
}
