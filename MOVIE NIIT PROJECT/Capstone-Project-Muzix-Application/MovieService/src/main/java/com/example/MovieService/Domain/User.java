package com.example.MovieService.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "User")
public class User {
    @Id
    private String email;
    private String username;
    private String password;
    private String gender;
    private String phoneNumber;
    private String imageName;
    private byte[] image;

    public User(String email, String username, String password, String gender, String phoneNumber, String imageName, byte[] image) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.imageName = imageName;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imageName='" + imageName + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public User() {
    }

    }
