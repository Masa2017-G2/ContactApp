package com.sheygam.contactapp.presentetion.login.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by gregorysheygam on 29/01/2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface ILoginView extends MvpView{
    void showProgress();
    void hideProgress();
    void onLoginSuccess(@NonNull String message);
    void showError(@NonNull String error);
    void hideErrorDialog();
    void putEmailError(String error);
    void putPasswordError(String error);
    void clearInputError();
}
