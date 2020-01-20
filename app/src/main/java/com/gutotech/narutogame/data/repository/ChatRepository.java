package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
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

    public void send(Message mensagem, String channel) {
        DatabaseReference messageRef = FirebaseConfig.getDatabase()
                .child("chats")
                .child(channel)
                .push();

        messageRef.setValue(mensagem);
    }

    private DatabaseReference messageRef;
    private ValueEventListener valueEventListener;

    public MutableLiveData<List<Message>> getMessages(String channel) {
        MutableLiveData<List<Message>> data = new MutableLiveData<>();

        List<Message> messageList = new ArrayList<>();

        removeEventListener();

        messageRef = FirebaseConfig.getDatabase()
                .child("chats")
                .child(channel);

        valueEventListener = messageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                messageList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    messageList.add(data.getValue(Message.class));
                }

                data.postValue(messageList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    public void removeEventListener() {
        if (valueEventListener != null) {
            messageRef.removeEventListener(valueEventListener);
        }
    }
}
