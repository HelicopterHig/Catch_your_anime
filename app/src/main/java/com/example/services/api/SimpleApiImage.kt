package com.example.services.api

import com.example.services.model.Post
import com.example.services.model.PostImage
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SimpleApiImage {


  // @GET( "/api/v1/fma_brotherhood")
  // suspend fun getPostImage(): Response<PostImage>

    @POST
    suspend fun pushPostImage(
        @Body postImage: PostImage
    ):Response<PostImage>

    @GET( "/api/v1/{anime_title}")
    suspend fun getPostImage2(
        @Path( "anime_title") title : String
    ): Response<PostImage>
}




















