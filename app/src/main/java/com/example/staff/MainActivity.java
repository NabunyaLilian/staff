package com.example.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserView{
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserPresenter presenter = new UserPresenter();
        presenter.fetchUsers(this);

    }


    private void initRecyclerView(List<User> users) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        ListViewAdapter adapter = new ListViewAdapter(users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void readyUsers(List<User> userList) {
        users = userList;
        initRecyclerView(users);
    }
}
