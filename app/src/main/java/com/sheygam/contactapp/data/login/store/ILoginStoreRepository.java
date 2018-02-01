package com.sheygam.contactapp.data.login.store;

import android.support.annotation.NonNull;

/**
 * Created by gregorysheygam on 01/02/2018.
 */

public interface ILoginStoreRepository {
    void saveToken(@NonNull String token);
}
