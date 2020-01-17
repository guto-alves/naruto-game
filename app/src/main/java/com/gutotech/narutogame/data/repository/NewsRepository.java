package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    private static NewsRepository sInstance;

    private Query newsQuery;

    private NewsRepository() {
        DatabaseReference newsRef = FirebaseConfig.getDatabase().child("news");
        newsQuery = newsRef.orderByKey();
    }

    public static NewsRepository getInstance() {
        if (sInstance == null) {
            sInstance = new NewsRepository();
        }
        return sInstance;
    }

    public void saveNews(News news) {
        DatabaseReference newsRef = FirebaseConfig.getDatabase()
                .child("news")
                .child(news.getId());

        newsRef.setValue(news);
    }

    public LiveData<List<News>> getAllNews() {
        MutableLiveData<List<News>> data = new MutableLiveData<>();

        List<News> newsList = new ArrayList<>();

        newsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newsList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    News news = data.getValue(News.class);
                    newsList.add(0, news);
                }

                data.postValue(newsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }
}
