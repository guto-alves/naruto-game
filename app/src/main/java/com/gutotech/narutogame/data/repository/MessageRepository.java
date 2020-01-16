package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    private static MessageRepository sInstance;

    private MessageRepository() {
    }

    public static MessageRepository getsInstance() {
        if (sInstance == null)
            sInstance = new MessageRepository();
        return sInstance;
    }

    public void send(Message mensagem, String channel) {
        DatabaseReference messageRef = FirebaseConfig.getDatabase()
                .child("chats")
                .child(channel)
                .push();

        messageRef.setValue(mensagem);
    }

    private DatabaseReference messageRef;
    private ValueEventListener valueEventListenerMensagens;

    private void getAllMessagens(String channel) {
        List<Message> messageList = new ArrayList<>();

        messageRef = FirebaseConfig.getDatabase()
                .child("chats")
                .child(channel);

        valueEventListenerMensagens = messageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                messageList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren())
                    messageList.add(data.getValue(Message.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void close() {
        messageRef.removeEventListener(valueEventListenerMensagens);
    }
}
