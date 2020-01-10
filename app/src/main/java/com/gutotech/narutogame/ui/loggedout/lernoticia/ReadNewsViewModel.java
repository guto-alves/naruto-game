package com.gutotech.narutogame.ui.loggedout.lernoticia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Comment;
import com.gutotech.narutogame.data.model.News;

import java.util.List;

public class ReadNewsViewModel extends ViewModel {
    private News news;
    private MutableLiveData<List<Comment>> comments;

    public ReadNewsViewModel() {
        comments = new MutableLiveData<>();
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public LiveData<List<Comment>> getComments() {
        return comments;
    }

    public void comment() {

    }

}
