package com.example.services.repository

import com.example.services.api.RetrofitInstance
import com.example.services.api.RetrofitInstanceForImage
import com.example.services.model.Post
import com.example.services.model.PostImage
import retrofit2.Response
import retrofit2.Retrofit

class Repository {
    suspend fun  getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
  // suspend fun getPostImage(): Response<PostImage> {
  //     return RetrofitInstanceForImage.apiImage.getPostImage()
  // }

    suspend fun pushPostImage(postImage: PostImage): Response<PostImage>{
        return  RetrofitInstanceForImage.apiImage.pushPostImage(postImage)
    }

    suspend fun getPostImage(title : String): Response<PostImage> {
        return RetrofitInstanceForImage.apiImage.getPostImage2(title)
    }
}






























