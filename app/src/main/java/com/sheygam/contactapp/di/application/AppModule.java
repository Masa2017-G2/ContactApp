package com.sheygam.contactapp.di.application;

import android.content.Context;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by gregorysheygam on 01/02/2018.
 */
@Module
public class AppModule {
    private final Context appContext;
    private final OkHttpClient client;
    private final Gson gson;


    public AppModule(Context appContext) {
        this.appContext = appContext;
        this.gson = new Gson();
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(){
        return appContext;
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        return client;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return gson;
    }
}
