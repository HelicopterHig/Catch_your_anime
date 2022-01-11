package com.example.services.api

import com.example.services.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET( "api/random")
    suspend fun getPost(): Response<Post>


}