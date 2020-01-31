package com.example.staff;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter {
    private UserService service;

    public UserPresenter() {
        if(this.service == null){
            this.service = new UserService();
        }
    }

    public void throwException(){
        try {
            throw new InterruptedException("Ooops something went wrong!");
        }catch (InterruptedException e){
        }
    }

    public void fetchUsers(final UserView userView){
        service
              .getRetrofitInstance()
              .getUsers()
              .enqueue(new Callback<UserList>() {
                  @Override
                  public void onResponse(Call<UserList> call, Response<UserList> response) {
                      UserList userList = response.body();
                      if(userList != null && userList.getUsers() != null){
                          List<User> user = userList.getUsers();
                          userView.readyUsers(user);
                      }
                  }

                  @Override
                  public void onFailure(Call<UserList> call, Throwable t) {
                      throwException();
                  }
              });
    }


    public void fetchProfile( Integer id, final ProfileView profileView){
        service
                .getRetrofitInstance()
                .getUser(id)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        profileView.userProfile(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        throwException();
                    }
                });
    }
}
