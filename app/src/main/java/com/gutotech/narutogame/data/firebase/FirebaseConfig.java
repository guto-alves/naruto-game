package com.gutotech.narutogame.data.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseConfig {
    private static DatabaseReference sDatabase;
    private static StorageReference sStorage;

    public static DatabaseReference getDatabase() {
        if (sDatabase == null) {
            sDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return sDatabase;
    }

    public static StorageReference getStorage() {
        if (sStorage == null) {
            sStorage = FirebaseStorage.getInstance().getReference();
        }
        return sStorage;
    }
}
