package com.example.staff.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.staff.StaffApp;
import com.example.staff.model.User;
import com.example.staff.repo.UserRepository;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {
    @Inject UserRepository userRepository;


    public MutableLiveData<List<User>> users = new MutableLiveData<>();

    void init() {
        StaffApp.applicationComponent.injectHomeViewModel(this);
        users = userRepository.fetchUser();
    }


    public LiveData<List<User>> getUserList(){
     return users;
    }


}
