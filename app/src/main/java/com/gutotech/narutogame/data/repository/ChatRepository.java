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

    private DatabaseReference messagesRef;
    private ChildEventListener messagesListener;

    public void getMessages(String channel, MessagesListener listener) {
        List<Message> messageList = new ArrayList<>();

        removeEventListener();

        messagesRef = FirebaseConfig.getDatabase().child("chats").child(channel);

        messagesListener = new ChildEventListener() {
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

                int size = messageList.size();

                for (int i = 0; i < size; i++) {
                    if (messageList.get(i).getId().equals(messageRemoved.getId())) {
                        messageList.remove(i);
                        break;
                    }
                }

                listener.onMessagesChanged(messageList);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        messagesRef.addChildEventListener(messagesListener);
    }

    public void removeEventListener() {
        if (messagesListener != null) {
            messagesRef.removeEventListener(messagesListener);
        }
    }

    public interface MessagesListener {
        void onMessagesChanged(List<Message> messages);
    }
}
