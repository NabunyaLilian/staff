package com.example.staff.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
public class User {

  @PrimaryKey
  @SerializedName("id")
  @Expose
  private Integer id;


  @SerializedName("email")
  @Expose
  private String email;

  @SerializedName("first_name")
  @Expose
  private String f_name;

  @SerializedName("last_name")
  @Expose
  private String l_name;

  @SerializedName("avatar")
  @Expose
  private String profile_photo;


    public User(Integer id, String email, String f_name, String l_name, String profile_photo) {
        this.id = id;
        this.email = email;
        this.f_name = f_name;
        this.l_name = l_name;
        this.profile_photo = profile_photo;
    }

    @Ignore
    public User() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
