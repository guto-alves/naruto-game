package com.gutotech.narutogame.ui.home.home;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.data.model.NinjaStatistics;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.GameStatusRepository;
import com.gutotech.narutogame.data.repository.KageRepository;
import com.gutotech.narutogame.data.repository.NewsRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public final ObservableField<String> email = new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");

    private AuthRepository mAuthRepository;
    private PlayerRepository mPlayerRepository;

    private ResultListener mAuthListener;

    private SingleLiveEvent<Void> mStartMaintenanceActivityEvent = new SingleLiveEvent<>();

    public HomeViewModel() {
        mAuthRepository = AuthRepository.getInstance();
        mPlayerRepository = PlayerRepository.getInstance();
    }

    public void onPlayButtonPressed() {
        if (validateFields()) {
            mAuthListener.onStarted();

            mAuthRepository.signIn(email.get(), password.get(), new AuthRepository.Completable() {
                @Override
                public void onComplete() {
                    mPlayerRepository.setSignedIn(true, signInResult -> {
                        if (signInResult) {
                            GameStatusRepository.getInstance().getStatus(status -> {
                                if (status.equals(GameStatusRepository.VERSION_NAME)) {
                                    mAuthListener.onSuccess();
                                } else {
                                    mPlayerRepository.setSignedIn(false, null);
                                    mAuthRepository.signOut();
                                    mAuthListener.onFailure(0);
                                    mStartMaintenanceActivityEvent.call();
                                }
                            });
                        } else {
                            mAuthRepository.signOut();
                            mAuthListener.onFailure(R.string.error_multiple_logins);
                        }
                    });
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

        email.set(email.get().trim());
        password.set(password.get().trim());

        if (TextUtils.isEmpty(email.get())) {
            mAuthListener.onFailure(R.string.email_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(password.get())) {
            mAuthListener.onFailure(R.string.password_field_requered);
            valid = false;
        }

        return valid;
    }

    void setAuthListener(ResultListener authListener) {
        mAuthListener = authListener;
    }

    public LiveData<List<News>> getNews() {
        return NewsRepository.getInstance().getAllNews();
    }

    LiveData<List<NinjaStatistics>> getNinjaStatistics() {
        return NinjaStatisticsRepository.getInstance().getAllNinjaStatistics();
    }

    LiveData<List<Character>> getKages() {
        return KageRepository.getInstance().getKages();
    }

    LiveData<Void> getStartMaintenanceActivityEvent() {
        return mStartMaintenanceActivityEvent;
    }
}
