package com.gutotech.narutogame.data.firebase;

import com.google.firebase.functions.FirebaseFunctions;

public abstract class FirebaseFunctionsUtils {

    public interface OnGetServerTimeListener {
        void onSuccess(long currentTimestamp);

        default void onFailure() {
        }
    }

    public static void getServerTime(OnGetServerTimeListener onGetServerTime) {
        FirebaseFunctions.getInstance().getHttpsCallable("getTime")
                .call()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        onGetServerTime.onSuccess((long) task.getResult().getData());
                    } else {
                        onGetServerTime.onFailure();
                    }
                });
    }

}
