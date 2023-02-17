package com.example.UserAuthentication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel
{
    @Id
    private String email;
    private String password;
    private String gender;

    public UserModel()
    {

    }

    public UserModel(String email, String password, String gender) {
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
