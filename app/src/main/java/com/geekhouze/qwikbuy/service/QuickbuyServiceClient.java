package com.geekhouze.qwikbuy.service;

import com.geekhouze.qwikbuy.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface QuickbuyServiceClient {

    @GET("/Quickbuy/users/")
    Call<List<User>> getUsers();

}
