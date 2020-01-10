package com.gutotech.narutogame.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.security.SecureRandom;

public class StorageUtil {

    public static void downloadImage(Context context, StorageReference imageReference, ImageView imageView) {
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imageReference)
                .into(imageView);
    }

    public static void baixarImagemParaMsg(Context context, ImageView imageView) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("msg")
                .child(String.valueOf(new SecureRandom().nextInt(8) + 1))
                .child((new SecureRandom().nextInt(6) + 1) + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarImagemParaMsg(Context context, ImageView imageView, int vila) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("msg")
                .child(String.valueOf(vila))
                .child((new SecureRandom().nextInt(6) + 1) + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarProfile(Context context, ImageView imageView, int idProfile) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(idProfile))
                .child("1.png");
        downloadImage(context, imageReference, imageView);
    }

    public static void downloadSmallProfile(Context context, ImageView imageView, int profileId) {
        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images")
                .child("criacao")
                .child("pequenas")
                .child(profileId + ".png");
        downloadImage(context, imageRef, imageView);

    }

    public static void baixarProfile(Context context, ImageView imageView, int idProfile, int currentProfile) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(idProfile))
                .child(currentProfile + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarTopoLogado(Context context, ImageView imageView, int idProfile) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("topo-logado")
                .child(idProfile + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarJutsu(Context context, ImageView imageView, String classe, String nomeImage) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("jutsu")
                .child(classe)
                .child(nomeImage + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarFidelityDia(Context context, ImageView imageView, int dia) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("fidelity")
                .child(dia + ".png");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarRamenImage(Context context, ImageView imageView, String nomeImage) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("comidas")
                .child(nomeImage + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarArmaImage(Context context, ImageView imageView, String nomeImage, String alcance) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("armas")
                .child(alcance)
                .child(nomeImage + ".jpg");
        downloadImage(context, imageReference, imageView);
    }

    public static void baixarPergaminhoImage(Context context, ImageView imageView, String nomeImage) {
        StorageReference imageReference = FirebaseConfig.getStorage()
                .child("images")
                .child("pergaminhos")
                .child(nomeImage + ".png");
        downloadImage(context, imageReference, imageView);
    }
}
