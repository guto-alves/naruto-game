package com.gutotech.narutogame.ui.adapter;

import static android.graphics.Typeface.BOLD;

import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatMessagesAdapter extends RecyclerView.Adapter<ChatMessagesAdapter.ViewHolder> {
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
            holder.dateTextView.setText(toDate(message.getTimestamp()));
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

    private String toDate(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return sfd.format(date);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView messageTextView;
        private final TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}
