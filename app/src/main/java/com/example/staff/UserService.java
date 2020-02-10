package com.example.staff;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://reqres.in";

    public UserApi getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit
                     .Builder()
                     .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
        }
        return retrofit.create(UserApi.class);
    }
}
