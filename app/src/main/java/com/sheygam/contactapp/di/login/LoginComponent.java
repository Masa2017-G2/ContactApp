package com.sheygam.contactapp.di.login;

import com.sheygam.contactapp.presentetion.login.presenter.LoginPresenter;

import dagger.Subcomponent;

/**
 * Created by gregorysheygam on 01/02/2018.
 */
@Subcomponent(modules = {LoginModule.class})
@LoginScope
public interface LoginComponent {
    void inject(LoginPresenter loginPresenter);
}
