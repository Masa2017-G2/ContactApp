package com.sheygam.contactapp.data.login.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.sheygam.contactapp.Configuration;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public class LoginStoreRepository implements ILoginStoreRepository {
    Context context;

    public LoginStoreRepository(Context context) {
        this.context = context;
    }

    @Override
    public void saveToken(@NonNull String token) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Configuration.AUTH_SP,Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(Configuration.TOKEN_KEY,token)
                .commit();
    }
}
