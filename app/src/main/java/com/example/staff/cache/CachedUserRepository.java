package com.example.staff.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.staff.model.User;

import java.util.List;

import javax.inject.Inject;

public class CachedUserRepository {

    private UserDoa userDoa;
    private MutableLiveData<List<User>> userListMutable = new MutableLiveData<>();
    private MutableLiveData<User> userMutable = new MutableLiveData<>();

    @Inject
    public CachedUserRepository(Context context){
        UserDatabase db = Room.databaseBuilder(context,UserDatabase.class, "staff_db").build();
        userDoa = db.userDoa();
    }


    @SuppressLint("StaticFieldLeak")
    public MutableLiveData<List<User>> fetchUser() {

        new AsyncTask<Void, Void, List<User>>() {

            @Override
            protected List<User> doInBackground(Void... voids) {
                return userDoa.getAll();
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                userListMutable.setValue(users);
            }
        }.execute();


        return userListMutable;
    }


    @SuppressLint("StaticFieldLeak")
    public MutableLiveData<User> fetchProfile(Integer id){
        new FetchUserAsync().execute(id);
        return userMutable;
    }


    public void saveData(final List<User> user){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDoa.saveUser(user);
            }
        });
    }


    class FetchUserAsync extends AsyncTask<Integer, Void, User> {

        @Override
        protected User doInBackground(Integer... id) {
            return userDoa.getUserById(id[0]);
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            userMutable.setValue(user);
        }
    }


}
