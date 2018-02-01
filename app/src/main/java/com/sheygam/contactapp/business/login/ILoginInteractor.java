package com.sheygam.contactapp.business.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public interface ILoginInteractor {
    void onLogin(@NonNull String email,
                 @NonNull String password,
                 @Nullable ILoginInteractorCallback callback)
            throws InteractorEmailException,InteractorPasswordException;
    void onRegistration(@NonNull String email,
                 @NonNull String password,
                 @Nullable ILoginInteractorCallback callback)
            throws InteractorEmailException,InteractorPasswordException;
}
