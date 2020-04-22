package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatRepository {
    private static ChatRepository sInstance;

    private ChatRepository() {
    }

    public static ChatRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ChatRepository();
        }
        return sInstance;
    }

    public void sendMessage(Message message, String channel) {
        DatabaseReference messageRef = FirebaseConfig.getDatabase();

        String key = messageRef.child("chats").child(channel).push().getKey();
        message.setId(key);

        messageRef.child("chats").child(channel).child(key).setValue(message);
    }

    public void deleteMessages(String channel) {
        DatabaseReference channelRef = FirebaseConfig.getDatabase()
                .child("chats")
                .child(channel);

        channelRef.removeValue();
    }

    private DatabaseReference mMessagesRef;
    private ChildEventListener mMessagesEventListener;

    public void addOnMessagesListener(String channel, MessagesListener listener) {
        removeMessagesListener();

        List<Message> messageList = new ArrayList<>();

        mMessagesRef = FirebaseConfig.getDatabase().child("chats").child(channel);

        mMessagesEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Message newMessage = dataSnapshot.getValue(Message.class);
                messageList.add(newMessage);
                listener.onMessagesChanged(messageList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Message messageRemoved = dataSnapshot.getValue(Message.class);
                messageList.remove(messageRemoved);
                listener.onMessagesChanged(messageList);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        mMessagesRef.addChildEventListener(mMessagesEventListener);
    }

    public void removeMessagesListener() {
        if (mMessagesEventListener != null) {
            mMessagesRef.removeEventListener(mMessagesEventListener);
            mMessagesEventListener = null;
        }
    }

    public interface MessagesListener {
        void onMessagesChanged(List<Message> messages);
    }
}
