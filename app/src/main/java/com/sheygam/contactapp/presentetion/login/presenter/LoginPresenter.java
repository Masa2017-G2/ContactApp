package com.sheygam.contactapp.presentetion.login.presenter;


import android.os.Handler;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.contactapp.App;
import com.sheygam.contactapp.business.login.ILoginInteractor;
import com.sheygam.contactapp.business.login.ILoginInteractorCallback;
import com.sheygam.contactapp.business.login.InteractorEmailException;
import com.sheygam.contactapp.business.login.InteractorPasswordException;
import com.sheygam.contactapp.di.login.LoginModule;
import com.sheygam.contactapp.presentetion.login.view.ILoginView;

import javax.inject.Inject;


/**
 * Created by gregorysheygam on 31/01/2018.
 */
@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements ILoginPresenter, ILoginInteractorCallback {


    @Inject
    ILoginInteractor mInteractor;

    private Handler handler;



    public LoginPresenter() {
        App.get().plusLoginModul(new LoginModule()).inject(this);
        handler = new Handler();
    }

    @Override
    public void actionLogin(@NonNull String email, @NonNull String password) {
        getViewState().clearInputError();
        getViewState().showProgress();
        try {
            mInteractor.onLogin(email, password, this);
        } catch (InteractorEmailException e) {
            getViewState().putEmailError(e.getMessage());
            getViewState().hideProgress();
        } catch (InteractorPasswordException e) {
            getViewState().putPasswordError(e.getMessage());
            getViewState().hideProgress();
        }
    }

    @Override
    public void actionRegistration(@NonNull String email, @NonNull String password) {
        getViewState().clearInputError();
        getViewState().showProgress();
        try {
            mInteractor.onRegistration(email, password, this);
        } catch (InteractorEmailException e) {
            getViewState().putEmailError(e.getMessage());
            getViewState().hideProgress();
        } catch (InteractorPasswordException e) {
            getViewState().putPasswordError(e.getMessage());
            getViewState().hideProgress();
        }
    }

    @Override
    public void onErrorDialogDismiss() {
        getViewState().hideErrorDialog();
    }

    private void handleLoginSuccess(){
        getViewState().hideProgress();
        getViewState().onLoginSuccess("Login success");
    }

    private void handleError(String error){
        getViewState().hideProgress();
        getViewState().showError(error);
    }

    private void handleRegSuccess(){
        getViewState().hideProgress();
        getViewState().onLoginSuccess("Registration success");
    }

    @Override
    public void onLoginSuccess() {
        handler.post(() -> handleLoginSuccess());
    }

    @Override
    public void onRegistrationSuccess() {
        handler.post(() -> handleRegSuccess());
    }

    @Override
    public void onError(String error) {
        handler.post(() -> handleError(error));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.get().clearLoginComponent();
    }
}
