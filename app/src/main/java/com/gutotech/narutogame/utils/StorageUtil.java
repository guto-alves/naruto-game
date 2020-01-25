package com.gutotech.narutogame.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.security.SecureRandom;

public class StorageUtil {
    private static SecureRandom random = new SecureRandom();

    public static void downloadImage(Context context, StorageReference imageReference, ImageView imageView) {
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imageReference)
                .into(imageView);
    }

    public static void downloadProfileForMsg(Context context, ImageView imageView) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("msg")
                .child(generateVillageId())
                .child(generateProfileId() + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadProfileForMsg(Context context, ImageView imageView, int villageId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("msg")
                .child(String.valueOf(villageId))
                .child(generateProfileId() + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadProfile(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(ninjaId))
                .child("1.png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadProfile(Context context, ImageView imageView, int ninjaId, int currentProfile) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(ninjaId))
                .child(currentProfile + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadSmallProfile(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images")
                .child("criacao")
                .child("pequenas")
                .child(ninjaId + ".png");
        downloadImage(context, imageRef, imageView);
    }

    public static void downloadLotteryItem(ImageView imageView, String image) {
        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images/loteria/")
                .child(image + ".png");
        downloadImage(imageView.getContext(), imageRef, imageView);
    }

    public static void downloadSprite(ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images/sprites")
                .child(ninjaId + ".png");
        downloadImage(imageView.getContext(), imageReference, imageView);
    }

    public static void baixarTopoLogado(Context context, ImageView imageView, int ninjaId) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("topo-logado")
                .child(ninjaId + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadJutsu(Context context, ImageView imageView, String name) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("jutsu")
                .child(name + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarFidelityDia(Context context, ImageView imageView, int dia) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("fidelity")
                .child(dia + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadRamen(Context context, ImageView imageView, String image) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("comidas")
                .child(image + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarArmaImage(Context context, ImageView imageView, String name, String alcance) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("armas")
                .child(alcance)
                .child(name + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarPergaminhoImage(Context context, ImageView imageView, String name) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("pergaminhos")
                .child(name + ".png");
        downloadImage(context, imageReference, imageView);
    }

    private static String generateVillageId() {
        return String.valueOf(new SecureRandom().nextInt(8) + 1);
    }

    private static String generateProfileId() {
        return String.valueOf(random.nextInt(6) + 1);
    }
}
