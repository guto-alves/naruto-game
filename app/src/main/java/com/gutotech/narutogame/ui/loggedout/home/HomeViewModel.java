package com.gutotech.narutogame.ui.loggedout.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.NewsRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.ui.loggedout.AuthListener;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<News>> news = new MutableLiveData<>();

    public String email;
    public String senha;

    private AuthRepository mAuthRepository;
    private AuthListener mAuthListener;

    private NewsRepository mNewsRepository;

    private NinjaStatisticsRepository mNinjaStatisticsRepository;

    public int kageEVilaAtual = 1;

    public HomeViewModel() {
        mAuthRepository = new AuthRepository();
        mNewsRepository = new NewsRepository();
        mNinjaStatisticsRepository = new NinjaStatisticsRepository();
    }

    public LiveData<List<News>> getNews() {
        return news;
    }

    public void setAuthListener(AuthListener mAuthListener) {
        this.mAuthListener = mAuthListener;
    }

    public void jogar() {
        if (validarCampos(email, senha)) {
            mAuthRepository.loginPlayer(email, senha);
        }
    }

    private boolean validarCampos(String email, String senha) {
        boolean valid = true;

        if (email.isEmpty()) {
//            emailEditText.setError("Preencha o email");
            valid = false;
        }

        if (senha.isEmpty()) {
//            senhaEditText.setError("Preencha a senha");
            valid = false;
        }
        return valid;
    }
}
