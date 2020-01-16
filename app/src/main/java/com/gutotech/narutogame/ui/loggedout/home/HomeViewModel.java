package com.gutotech.narutogame.ui.loggedout.home;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.NewsRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.ui.ResultListener;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public String email;
    public String password;

    private AuthRepository mAuthRepository;
    private ResultListener mAuthListener;

    private NewsRepository mNewsRepository;
    private NinjaStatisticsRepository mNinjaStatisticsRepository;

    private MutableLiveData<List<News>> news = new MutableLiveData<>();

    private MutableLiveData<List<NinjaStatisticsRepository>> ninjaStatistics;

    public int kageEVilaAtual = 1;

    public HomeViewModel() {
        mAuthRepository = AuthRepository.getInstance();
        mNewsRepository = new NewsRepository();
        mNinjaStatisticsRepository = new NinjaStatisticsRepository();
    }

    public LiveData<List<News>> getNews() {
        return news;
    }

    public void setAuthListener(ResultListener authListener) {
        mAuthListener = authListener;
    }

    public void onPlayButtonPressed() {
        mAuthListener.onStarted();

        if (validateFields()) {
            mAuthRepository.loginPlayer(email, password,
                    new AuthRepository.Completable() {
                        @Override
                        public void onComplete() {
                            mAuthListener.onSuccess();
                        }

                        @Override
                        public void onError(int resId) {
                            mAuthListener.onFailure(resId);
                        }
                    });
        }
    }

    private boolean validateFields() {
        boolean valid = true;

        if (TextUtils.isEmpty(email)) {
            mAuthListener.onFailure(R.string.email_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(password)) {
            mAuthListener.onFailure(R.string.password_field_requered);
            valid = false;
        }
        return valid;
    }
}
