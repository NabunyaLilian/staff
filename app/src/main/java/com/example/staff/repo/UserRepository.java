package com.example.staff.repo;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.staff.StaffApp;
import com.example.staff.cache.CachedUserRepository;
import com.example.staff.model.User;
import com.example.staff.remote.RemoteUserRepository;

import java.util.List;

import javax.inject.Inject;

public class UserRepository {
    @Inject RemoteUserRepository remoteUserRepository;
    @Inject CachedUserRepository cachedUserRepository;
    boolean isOnline;

    @Inject
    public UserRepository() {
        StaffApp.applicationComponent.inject(this);
        this.isOnline = true;
    }


    private MutableLiveData<List<User>> userList = new MutableLiveData<>();
    public MutableLiveData<List<User>> fetchUser(){
        if(isOnline){
            userList = remoteUserRepository.fetchUser();
        } else {
            userList = cachedUserRepository.fetchUser();
        }
        return userList;

    }

    private MutableLiveData<User> user = new MutableLiveData<>();
    public MutableLiveData<User> fetchProfile(Integer id){
        user = cachedUserRepository.fetchProfile(id);
        return user;
    }
}
