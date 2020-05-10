package com.gutotech.narutogame.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

import java.util.List;

import static android.graphics.Typeface.BOLD;

public class ChatMessagesAdapter extends RecyclerView.Adapter<ChatMessagesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView messageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
        }
    }

    private List<Message> mMessageList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_chat_message, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if (mMessageList != null) {
            Message message = mMessageList.get(i);
            SpannableStringBuilderCustom stringBuilder = new SpannableStringBuilderCustom(
                    holder.messageTextView.getContext());
            stringBuilder.append(message.getSender() + ": ", new StyleSpan(BOLD));
            stringBuilder.append(message.getMessage());
            holder.messageTextView.setText(stringBuilder.getString());
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
