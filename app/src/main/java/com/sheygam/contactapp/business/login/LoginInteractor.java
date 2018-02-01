package com.sheygam.contactapp.business.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.sheygam.contactapp.data.login.store.ILoginStoreRepository;
import com.sheygam.contactapp.data.login.web.ILoginWebRepository;
import com.sheygam.contactapp.data.login.web.ILoginWebRepositoryCallback;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public class LoginInteractor implements ILoginInteractor {
    ILoginWebRepository webRepository;
    ILoginStoreRepository storeRepository;

    public LoginInteractor(ILoginWebRepository webRepository, ILoginStoreRepository storeRepository) {
        this.webRepository = webRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public void onLogin(@NonNull String email, @NonNull String password, @Nullable ILoginInteractorCallback callback) throws InteractorEmailException, InteractorPasswordException {
        if (!isEmailValid(email)){
            throw new InteractorEmailException("Email need contains @");
        }

        if(!isPasswordValid(password)){
            throw new InteractorPasswordException("Password too short! min 4 symbols");
        }

        webRepository.onLogin(email, password, new ILoginWebRepositoryCallback() {
            @Override
            public void onRequestSuccess(@NonNull String token) {
                storeRepository.saveToken(token);
                if(callback != null) {
                    callback.onLoginSuccess();
                }
            }

            @Override
            public void onRequestFailure(@NonNull String error) {
                if(callback != null) {
                    callback.onError(error);
                }
            }
        });
    }

    @Override
    public void onRegistration(@NonNull String email, @NonNull String password, @Nullable ILoginInteractorCallback callback) throws InteractorEmailException, InteractorPasswordException {

        if (!isEmailValid(email)){
            throw new InteractorEmailException("Email need contains @");
        }

        if(!isPasswordValid(password)){
            throw new InteractorPasswordException("Password too short! min 4 symbols");
        }

        webRepository.onRegistration(email, password, new ILoginWebRepositoryCallback() {
            @Override
            public void onRequestSuccess(@NonNull String token) {
                storeRepository.saveToken(token);
                if (callback != null) {
                    callback.onLoginSuccess();
                }
            }

            @Override
            public void onRequestFailure(@NonNull String error) {
                if (callback != null) {
                    callback.onError(error);
                }
            }
        });
    }

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPasswordValid(String password){
        return password.length() >= 4;
    }
}
