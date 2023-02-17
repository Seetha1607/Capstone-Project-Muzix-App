package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.UserModel;

import java.util.Map;

public interface SecurityTokenGenerator
{
    public abstract Map<String, String> generateToken(UserModel user);


}
