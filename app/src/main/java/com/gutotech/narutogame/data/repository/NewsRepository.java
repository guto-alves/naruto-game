package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Comment;
import com.gutotech.narutogame.data.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    private static final NewsRepository sInstance = new NewsRepository();

    private NewsRepository() {
    }

    public static NewsRepository getInstance() {
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

        DatabaseReference newsRef = FirebaseConfig.getDatabase().child("news");
        Query newsQuery = newsRef.orderByKey();
        newsQuery.addValueEventListener(new ValueEventListener() {
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

    private DatabaseReference mLikesCountReference;
    private ValueEventListener mLikesCountEventListener;

    public void registerOnLikesChangeListener(String newsId, Callback<Integer> callback) {
        mLikesCountReference = FirebaseConfig.getDatabase()
                .child("news")
                .child(newsId)
                .child("likesCount");

        mLikesCountEventListener = mLikesCountReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer likesCount = dataSnapshot.getValue(Integer.class);
                callback.call(likesCount != null ? likesCount : 0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private boolean liked;

    public void like(String newsId, String uid, Callback<Boolean> callback) {
        DatabaseReference newsReference = FirebaseConfig.getDatabase()
                .child("news")
                .child(newsId);

        newsReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                News news = mutableData.getValue(News.class);

                if (news == null) {
                    return Transaction.success(mutableData);
                }

                if (news.getLikes() == null) {
                    news.setLikes(new ArrayList<>());
                }

                if (news.getLikes().contains(uid)) {
                    news.setLikesCount(news.getLikesCount() - 1);
                    news.getLikes().remove(uid);
                    liked = false;
                } else {
                    news.setLikesCount(news.getLikesCount() + 1);
                    news.getLikes().add(uid);
                    liked = true;
                }

                mutableData.setValue(news);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
                callback.call(liked);
            }
        });
    }

    public String generateId() {
        return FirebaseConfig.getDatabase().child("news-comments").push().getKey();
    }

    public void saveComment(String newsId, Comment comment) {
        DatabaseReference commentsReference = FirebaseConfig.getDatabase()
                .child("news-comments")
                .child(newsId)
                .child(comment.getId());

        commentsReference.setValue(comment);
    }

    private DatabaseReference mCommentsReference;
    private ChildEventListener mCommentsEventListener;

    public void registerOnCommentsChangeListener(String newsId, Callback<List<Comment>> callback) {
        mCommentsReference = FirebaseConfig.getDatabase()
                .child("news-comments")
                .child(newsId);

        List<Comment> comments = new ArrayList<>();

        mCommentsEventListener = mCommentsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Comment comment = dataSnapshot.getValue(Comment.class);

                if (comment == null) {
                    return;
                }

                comments.add(0, comment);
                callback.call(comments);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeListeners() {
        if (mLikesCountEventListener != null) {
            mLikesCountReference.removeEventListener(mLikesCountEventListener);
            mLikesCountEventListener = null;
        }

        if (mCommentsEventListener != null) {
            mCommentsReference.removeEventListener(mCommentsEventListener);
            mCommentsEventListener = null;
        }
    }
}
