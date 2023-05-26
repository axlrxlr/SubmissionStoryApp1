package com.mizu.submissionstoryapp.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("stories")
    fun getAllStories(
        @Header("Authorization") token : String
    ): Call<ListStoryResponse>

    @Multipart
    @POST("stories")
    fun postStory(
        @Header("Authorization") token : String,
        @Part photo: MultipartBody.Part,
        @Part("description") description : RequestBody
    ): Call<RegisterResponse>

}