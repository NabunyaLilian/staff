package com.example.staff.ui.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.staff.StaffApp;
import com.example.staff.cache.CachedUserRepository;
import com.example.staff.remote.UserApi;
import com.example.staff.util.Helpers;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteModule  {
    private static final String BASE_URL = "https://reqres.in";

    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    OkHttpClient  getOkHttpClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    UserApi getUserApi(OkHttpClient client){
        Retrofit  retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit.create(UserApi.class);
    }

    @Provides
    CachedUserRepository getCachedUserRepository(Application application){
        return new CachedUserRepository(application.getApplicationContext());
    }

    @Provides
    Context getContext(StaffApp app){
        return app ;
    }

    @Provides
    boolean checkNetwork(Context context){
        return Helpers.isNetworkConnected(context);
    }

}
