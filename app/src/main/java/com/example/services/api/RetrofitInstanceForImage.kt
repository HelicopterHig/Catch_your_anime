package com.example.services.api


import com.example.services.util.Constants.Companion.BASE_URL_IMAGE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceForImage {
    private  val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_IMAGE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiImage :SimpleApiImage by lazy {
        retrofit.create(SimpleApiImage::class.java)
    }





}























