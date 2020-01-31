package com.example.staff;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements ProfileView{
    Integer id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIncomingIntent();
        UserPresenter presenter = new UserPresenter();
        presenter.fetchProfile(id, this);
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("profile_pic") && getIntent().hasExtra("first_names")&& getIntent().hasExtra("last_names")  && getIntent().hasExtra("emails")){
            String profile_photo = getIntent().getStringExtra("profile_pic");
            String first_names = getIntent().getStringExtra("first_names");
            String last_names = getIntent().getStringExtra("last_names");
            String emails = getIntent().getStringExtra("emails");
            setImage(profile_photo, first_names, last_names, emails);

        }
    }

    private void setImage(String profile_photo, String f_names, String l_names, String emails) {
        TextView first_name = findViewById(R.id.first_name_view);
        TextView last_name = findViewById(R.id.last_name_view);
        TextView email = findViewById(R.id.email_view);
        CircleImageView image = findViewById(R.id.profile_photo_view);
        first_name.setText(f_names);
        last_name.setText(l_names);
        email.setText(emails);
        Glide.with(this)
                    .asBitmap()
                    .load(profile_photo)
                    .into(image);

    }

    @Override
    public void userProfile(User user) {
        Integer id = user.getId();

    }
}
