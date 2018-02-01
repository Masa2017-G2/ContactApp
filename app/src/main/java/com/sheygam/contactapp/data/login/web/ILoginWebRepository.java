package com.sheygam.contactapp.data.login.web;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public interface ILoginWebRepository {
    void onLogin(@NonNull String email, @NonNull String password, @Nullable ILoginWebRepositoryCallback callback);
    void onRegistration(@NonNull String email, @NonNull String password, @Nullable ILoginWebRepositoryCallback callback);
}
