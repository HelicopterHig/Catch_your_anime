package com.example.services

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.services.model.Post
import com.example.services.model.PostImage
import com.example.services.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseImage: MutableLiveData<Response<PostImage>> = MutableLiveData()

    fun pushPostImage(postImage: PostImage){
        viewModelScope.launch {
            val response = repository.pushPostImage(postImage)
            myResponseImage.value = response
        }
    }

    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPostImage(title : String){
        viewModelScope.launch {
            val responseImage : Response<PostImage> = repository.getPostImage(title)
            myResponseImage.value = responseImage
        }
    }










}