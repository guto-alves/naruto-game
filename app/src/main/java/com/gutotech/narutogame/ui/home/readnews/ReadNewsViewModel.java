package com.gutotech.narutogame.ui.home.readnews;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Comment;
import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.NewsRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class ReadNewsViewModel extends ViewModel {
    public final ObservableInt likesCount = new ObservableInt();
    public final ObservableField<String> comment = new ObservableField<>();

    private News mNews;
    private NewsRepository mNewsRepository = NewsRepository.getInstance();

    private MutableLiveData<List<Comment>> mComments = new MutableLiveData<>();

    private SingleLiveEvent<Boolean> mLikeEvent = new SingleLiveEvent<>();

    private String mUid;

    ReadNewsViewModel(News news) {
        mNews = news;

        if (AuthRepository.getInstance().isSignedIn()) {
            mUid = AuthRepository.getInstance().getUid();
            mLikeEvent.setValue(mNews.getLikes() != null && mNews.getLikes().contains(mUid));
        }
    }

    public void onLikeClick() {
        mNewsRepository.like(mNews.getId(), mUid,
                mLikeEvent::setValue);
    }

    public void onCommentClick() {
        if (!TextUtils.isEmpty(comment.get())) {
            mNewsRepository.saveComment(mNews.getId(),
                    new Comment(
                            mNewsRepository.generateId(),
                            AuthRepository.getInstance().getCurrentUser().getDisplayName(),
                            comment.get(),
                            DateCustom.getDate() + " - " + DateCustom.getTime()));
            comment.set("");
        }
    }

    void start() {
        mNewsRepository.registerOnLikesChangeListener(mNews.getId(), likesCount::set);
        mNewsRepository.registerOnCommentsChangeListener(mNews.getId(), mComments::setValue);
    }

    void stop() {
        mNewsRepository.removeListeners();
    }


    public News getNews() {
        return mNews;
    }

    LiveData<List<Comment>> getComments() {
        return mComments;
    }

    LiveData<Boolean> getLikeEvent() {
        return mLikeEvent;
    }
}
