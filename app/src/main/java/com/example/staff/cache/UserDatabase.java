package com.example.staff.cache;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.staff.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDoa userDoa();
}
