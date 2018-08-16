package com.geekhouze.qwikbuy.service;

import com.geekhouze.qwikbuy.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


// http://160.119.100.194:8080/Quickbuy/users/
public interface QuickbuyServiceClient {

    @GET("/users/")
    Call<List<User>> getUsers();

}
