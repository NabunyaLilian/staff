package com.example.staff;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/api/users")
    Call<UserList> getUsers();

    @GET("/api/users/{id}")
    Call<User> getUser(@Path("id") Integer id);
}
