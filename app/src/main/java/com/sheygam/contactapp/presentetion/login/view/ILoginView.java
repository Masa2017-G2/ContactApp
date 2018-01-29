package com.sheygam.contactapp.presentetion.login.view;

import android.support.annotation.NonNull;

/**
 * Created by gregorysheygam on 29/01/2018.
 */

public interface ILoginView {
    void showProgress();
    void hideProgress();
    void onLoginSuccess();
    void showError(@NonNull String error);
}
