package com.example.staff.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.example.staff.R;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.main_content, new MainFragment()).commit();
    }



}
