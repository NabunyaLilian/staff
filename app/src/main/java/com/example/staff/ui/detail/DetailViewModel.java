package com.example.staff.ui.detail;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.staff.model.User;
import com.example.staff.remote.RemoteUserRepository;
import com.example.staff.repo.UserRepository;

public class DetailViewModel extends ViewModel {

    private UserRepository userRepository;

    public MutableLiveData<User> userProfile = new MutableLiveData<>();


    public void init(int id) {
        if(userProfile == null){
            return;
        }
        userRepository = new  UserRepository();
        userProfile = userRepository.fetchProfile(id);

    }

    public LiveData<User> getUserProfile(){
        return userProfile;
    }


}
