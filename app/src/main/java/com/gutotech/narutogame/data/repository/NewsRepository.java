package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

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
    private Query newsQuery;
    private ValueEventListener valueEventListener;

    private List<News> newsList;

    public NewsRepository() {
        newsList = new ArrayList<>();

        DatabaseReference newsRef = FirebaseConfig.getDatabase().child("news");
        newsQuery = newsRef.orderByKey();
    }

    public void getAllNews(Callback callback) {
        valueEventListener = newsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newsList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    News news = data.getValue(News.class);
                    newsList.add(0, news);
                }

                callback.onNewsReceived(newsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public interface Callback {
        void onNewsReceived(List<News> newsList);
    }
}
