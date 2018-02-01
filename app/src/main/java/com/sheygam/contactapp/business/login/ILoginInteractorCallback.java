package com.sheygam.contactapp.business.login;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public interface ILoginInteractorCallback {
    void onLoginSuccess();
    void onRegistrationSuccess();
    void onError(String error);
}
