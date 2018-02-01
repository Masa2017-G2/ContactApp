package com.sheygam.contactapp.di.login;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by gregorysheygam on 01/02/2018.
 */
@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LoginScope {
}
