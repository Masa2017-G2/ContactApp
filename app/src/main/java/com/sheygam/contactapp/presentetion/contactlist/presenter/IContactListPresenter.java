package com.sheygam.contactapp.presentetion.contactlist.presenter;

/**
 * Created by gregorysheygam on 29/01/2018.
 */

public interface IContactListPresenter {

    void actionAddNewContact();
    void actionSelectedContact(int position);
    void actionLogout();
    void actionClearAll();
}
