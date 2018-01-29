package com.sheygam.contactapp.presentetion.contactinfo.presenter;

import android.support.annotation.NonNull;

/**
 * Created by gregorysheygam on 29/01/2018.
 */

public interface IContactInfoPresenter {
    void actionEdit(@NonNull String email, @NonNull String password, @NonNull String phone, @NonNull String description);
    void actionDone(@NonNull String email,@NonNull String password,@NonNull String phone,@NonNull String description);
}
