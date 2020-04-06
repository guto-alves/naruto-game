package com.gutotech.narutogame.data.firebase;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.Callback;

import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

public class StorageUtils {
    private final static SecureRandom random = new SecureRandom();

    // @param path Example: images/profile/4/
    public static void listAll(String path, Callback<List<StorageReference>> callback) {
        StorageReference listRef = FirebaseConfig.getStorage().child(path);

        listRef.listAll().addOnSuccessListener(listResult -> callback.call(listResult.getItems()));
    }

    public static void downloadImage(Context context, StorageReference imageReference, ImageView imageView) {
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imageReference)
                .into(imageView);
    }

    public static void downloadProfileForMsg(Context context, ImageView imageView) {
        StorageReference imageReference;

        if (CharOn.character != null) {
            imageReference = FirebaseConfig.getStorage().child("images")
                    .child("msg")
                    .child(String.valueOf(CharOn.character.getVillage().ordinal() + 1))
                    .child(generateProfileId() + ".png");
        } else {
            imageReference = FirebaseConfig.getStorage().child("images")
                    .child("msg")
                    .child(generateVillageId())
                    .child(generateProfileId() + ".png");
        }

        downloadImage(context, imageReference, imageView);
    }

    public static void downloadProfile(Context context, ImageView imageView, String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }

        StorageReference imageReference = FirebaseConfig.getStorage().child(path);
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadSmallProfile(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images/criacao/pequenas")
                .child(ninjaId + ".png");
        downloadImage(context, imageRef, imageView);
    }

    public static void downloadLotteryItem(ImageView imageView, String image) {
        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images/loteria")
                .child(image + ".png");
        downloadImage(imageView.getContext(), imageRef, imageView);
    }

    public static void downloadSprite(ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/sprites")
                .child(ninjaId + ".png");
        downloadImage(imageView.getContext(), imageReference, imageView);
    }

    public static void downloadJutsu(ImageView imageView, String image) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/jutsu")
                .child(image);
        downloadImage(imageView.getContext(), imageReference, imageView);
    }

    public static void downloadRamen(Context context, ImageView imageView, String image) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/comidas")
                .child(image + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadScroll(Context context, ImageView imageView, String id) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/pergaminhos")
                .child(id + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadTopImage(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/topo-logado")
                .child(ninjaId + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadFidelityImage(Context context, ImageView imageView, int day) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/fidelity")
                .child(day + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarArmaImage(Context context, ImageView imageView, String name, String alcance) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/armas")
                .child(alcance)
                .child(name + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadDojo(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/dojo")
                .child(ninjaId + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadKageImage(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/home")
                .child(ninjaId + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadTeamImage(Context context, ImageView imageView, String path) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/teams")
                .child(path);
        downloadImage(context, imageReference, imageView);
    }

    private static String generateVillageId() {
        return String.valueOf(new SecureRandom().nextInt(8) + 1);
    }

    private static String generateProfileId() {
        return String.valueOf(random.nextInt(6) + 1);
    }


    public static void upload(Bitmap bitmap, Callback<String> successListener,
                              Callback<Exception> failureListener) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();

        final String imageName = UUID.randomUUID().toString() + ".png";

        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images/tickets")
                .child(imageName);

        UploadTask uploadTask = imageRef.putBytes(bytes);

        uploadTask.addOnFailureListener(failureListener::call);

        uploadTask.addOnSuccessListener(taskSnapshot -> successListener.call(imageName));
    }

    public static void uploadTeamImage(Bitmap bitmap, Callback<String> successListener,
                                       Callback<Exception> failureListener) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();

        final String imageName = UUID.randomUUID().toString() + ".png";

        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images/teams")
                .child(imageName);

        UploadTask uploadTask = imageRef.putBytes(bytes);

        uploadTask.addOnFailureListener(failureListener::call);

        uploadTask.addOnSuccessListener(taskSnapshot -> successListener.call(imageName));
    }

}
