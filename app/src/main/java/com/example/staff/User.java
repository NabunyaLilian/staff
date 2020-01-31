package com.example.staff;

import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("id")
  private Integer id;

  @SerializedName("email")
  private String email;

  @SerializedName("first_name")
  private String f_name;

  @SerializedName("last_name")
  private String l_name;

  @SerializedName("avatar")
  private String profile_photo;


    public User(Integer id, String email, String f_name, String l_name, String profile_photo) {
        this.id = id;
        this.email = email;
        this.f_name = f_name;
        this.l_name = l_name;
        this.profile_photo = profile_photo;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getProfile_photo() {
        return profile_photo;
    }
}
