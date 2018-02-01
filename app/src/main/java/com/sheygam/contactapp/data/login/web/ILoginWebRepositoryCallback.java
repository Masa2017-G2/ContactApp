package com.sheygam.contactapp.data.login.web;

import android.support.annotation.NonNull;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public interface ILoginWebRepositoryCallback {
    void onRequestSuccess(@NonNull String token);
    void onRequestFailure(@NonNull String error);
}
