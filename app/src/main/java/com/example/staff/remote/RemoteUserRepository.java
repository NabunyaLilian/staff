package com.example.staff.remote;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.staff.cache.CachedUserRepository;
import com.example.staff.model.User;
import com.example.staff.model.UserList;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteUserRepository {
    private static final String TAG = "RemoteUserRepository";

    private CachedUserRepository cachedUserRepository;
    private MutableLiveData<List<User>> userListMutable = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    UserApi userApi;

    @Inject
    public RemoteUserRepository(CachedUserRepository cachedUserRepository, UserApi userApi){
        this.cachedUserRepository = cachedUserRepository;
        this.userApi = userApi;
    }

    public void throwException(){
        try {
            throw new InterruptedException("Ooops something went wrong!");
        }catch (InterruptedException e){
        }
    }

    public MutableLiveData<List<User>> fetchUser() {
          userApi
                .getUsers()
                .enqueue(new Callback<UserList>() {
                    @Override
                    public void onResponse(Call<UserList> call, Response<UserList> response) {
                        UserList userList = response.body();
                        if(userList != null && userList.getUsers() != null){
                            List<User> user = userList.getUsers();
                            userListMutable.setValue(user);
                            cachedUserRepository.saveData(user);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserList> call, Throwable t) {
                        throwException();
                    }
                });

        return userListMutable;
    }



    public MutableLiveData<User> fetchProfile(Integer id){
             userApi
                .getUser(id)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        userMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        throwException();
                    }
                });
        return userMutableLiveData;
    }


}
