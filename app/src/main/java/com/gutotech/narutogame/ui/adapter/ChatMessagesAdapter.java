package com.gutotech.narutogame.ui.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.databinding.AdapterChatMessageBinding;

import java.util.List;

public class ChatMessagesAdapter extends RecyclerView.Adapter<ChatMessagesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        AdapterChatMessageBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    private List<Message> mMessageList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AdapterChatMessageBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.adapter_chat_message, viewGroup, false
        );
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if (mMessageList != null) {
            holder.binding.setMessage(mMessageList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList != null ? mMessageList.size() : 0;
    }

    public void setMessageList(List<Message> messageList) {
        mMessageList = messageList;
        notifyDataSetChanged();
    }
}
