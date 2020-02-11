package com.example.staff.ui.di;

import android.app.Application;

import com.example.staff.StaffApp;
import com.example.staff.repo.UserRepository;
import com.example.staff.ui.di.modules.RemoteModule;
import com.example.staff.ui.home.HomeViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, RemoteModule.class})
public interface ApplicationComponent extends AndroidInjector<StaffApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application app);

        ApplicationComponent build();
    }

    void inject(UserRepository userRepository);
    void injectHomeViewModel(HomeViewModel homeViewModel);


}
