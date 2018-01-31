package com.sheygam.contactapp.presentetion.login.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.contactapp.presentetion.login.view.ILoginView;

/**
 * Created by gregorysheygam on 31/01/2018.
 */
@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements ILoginPresenter {

    @Override
    public void actionLogin(@NonNull String email, @NonNull String password) {
        getViewState().showProgress();
        //Todo send request to server
    }

    @Override
    public void actionRegistration(@NonNull String email, @NonNull String password) {
        getViewState().showProgress();
        //Todo send request to server
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

}
