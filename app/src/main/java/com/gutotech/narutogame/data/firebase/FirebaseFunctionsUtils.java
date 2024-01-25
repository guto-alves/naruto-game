package com.gutotech.narutogame.data.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ServerValue;
import com.gutotech.narutogame.data.model.CharOn;

public abstract class FirebaseFunctionsUtils {

    public interface OnGetServerTimeListener {
        void onSuccess(long currentTimestamp);

        default void onFailure() {
        }
    }

    public static void getServerTime(OnGetServerTimeListener onGetServerTime) {
        DatabaseReference reference = FirebaseConfig.getDatabase()
                .child("-times")
                .child(CharOn.character.getId());

        reference
                .setValue(ServerValue.TIMESTAMP)
                .addOnSuccessListener(unused -> {
                    reference.get().addOnSuccessListener(snapshot -> {
                        Long value = snapshot.getValue(Long.class);
                        if (value != null) {
                            onGetServerTime.onSuccess(value);
                        }
                    });
                });

//        FirebaseFunctions.getInstance().getHttpsCallable("getTime")
//                .call()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        onGetServerTime.onSuccess((long) task.getResult().getData());
//                    } else {
//                        onGetServerTime.onFailure();
//                    }
//                });
    }

}
