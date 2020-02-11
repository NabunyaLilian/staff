package com.example.staff.remote;

import com.example.staff.model.User;
import com.example.staff.model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/api/users")
    Call<UserList> getUsers();

    @GET("/api/users/{id}")
    Call<User> getUser(@Path("id") Integer id);
}
