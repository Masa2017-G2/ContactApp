package com.sheygam.contactapp.presentetion.login.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;

/**
 * Created by gregorysheygam on 29/01/2018.
 */

public interface ILoginView extends MvpView{
    void showProgress();
    void hideProgress();
    void onLoginSuccess(@NonNull String message);
    void showError(@NonNull String error);
}
