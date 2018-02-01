package com.sheygam.contactapp.di.login;

import android.content.Context;

import com.google.gson.Gson;
import com.sheygam.contactapp.business.login.ILoginInteractor;
import com.sheygam.contactapp.business.login.LoginInteractor;
import com.sheygam.contactapp.data.login.store.ILoginStoreRepository;
import com.sheygam.contactapp.data.login.store.LoginStoreRepository;
import com.sheygam.contactapp.data.login.web.ILoginWebRepository;
import com.sheygam.contactapp.data.login.web.LoginWebRepository;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by gregorysheygam on 01/02/2018.
 */
@Module
public class LoginModule {
    @Provides
    @LoginScope
    ILoginStoreRepository provideLoginStoreRepository(Context context){
        return new LoginStoreRepository(context);
    }

    @Provides
    @LoginScope
    ILoginWebRepository provideLoginWebRepository(OkHttpClient client, Gson gson){
        return new LoginWebRepository(client,gson);
    }

    @Provides
    @LoginScope
    ILoginInteractor provideLoginInteractor(ILoginWebRepository webRepository, ILoginStoreRepository storeRepository){
        return new LoginInteractor(webRepository, storeRepository);
    }
}
