package com.sheygam.contactapp;

import android.app.Application;

import com.sheygam.contactapp.di.application.AppComponent;
import com.sheygam.contactapp.di.application.AppModule;
import com.sheygam.contactapp.di.application.DaggerAppComponent;
import com.sheygam.contactapp.di.login.LoginComponent;
import com.sheygam.contactapp.di.login.LoginModule;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public class App extends Application{
    private AppComponent appComponent;
    private LoginComponent loginComponent;

    private static App app;

    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        app = this;
        appComponent = prepare();
        super.onCreate();
    }

    private AppComponent prepare(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public LoginComponent plusLoginModul(LoginModule loginModule){
        if(loginComponent == null){
            loginComponent = appComponent.plus(loginModule);
        }
        return loginComponent;
    }

    public void clearLoginComponent(){
        loginComponent = null;
    }
}
