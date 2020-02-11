package com.example.staff;

import android.app.Application;

import com.example.staff.ui.di.ApplicationComponent;
import com.example.staff.ui.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class StaffApp extends DaggerApplication {
    public static ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        return applicationComponent;
    }
}
