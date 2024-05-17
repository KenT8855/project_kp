package com.example.petwellapp.service;

import com.example.petwellapp.Entity.Product;
import com.example.petwellapp.Entity.User;
import com.example.petwellapp.response.BaseWebResponse;

import java.io.File;
import java.util.Base64;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("api/auth/register")
    Call<BaseWebResponse<User>> registerUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password

    );
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<BaseWebResponse<User>> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/product")
    Call<BaseWebResponse<Product>> insertProduct(
            @Field("name") String name,
            @Field("description") String description,
            @Field("price") Double price,
            @Field("image")File image
            );

}

