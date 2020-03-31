package com.gutotech.narutogame.ui.home.readnews;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.News;

public class ReadNewsViewModelFactory implements ViewModelProvider.Factory {
    private News news;

    ReadNewsViewModelFactory(News news) {
        this.news = news;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ReadNewsViewModel(news);
    }
}
