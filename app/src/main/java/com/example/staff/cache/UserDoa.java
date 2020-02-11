package com.example.staff.cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.staff.model.User;

import java.util.List;

@Dao
public interface UserDoa {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id = :userId")
    User getUserById(int userId);

    @Update
    void saveUser(List<User> user);


}
