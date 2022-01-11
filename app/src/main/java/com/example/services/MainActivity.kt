package com.example.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.services.databinding.ActivityMainBinding
import com.example.services.repository.Repository
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.services.model.PostImage


class MainActivity : AppCompatActivity() {
    private lateinit var  viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding


   // private val mImageAddress = "https://tse4.mm.bing.net/th?id=OIP.7zx7U0QXkdaDrM_HhFs4uwHaHa&amp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val anime: TextView = binding.anime
        val character: TextView = binding.character
        val quote: TextView = binding.phrase
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        binding.generate.setOnClickListener {
            val imagePath = binding.imageView


            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            //val myPost = PostImage()
          //  viewModel.pushPostImage(myPost)
            viewModel.getPost()


            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                 // Glide.with(this)
                 //     .load(response.body()?.res)
                 //     .into(imagePath)

                    Log.d("Response", response.body()?.anime.toString())
                    binding.anime.setText(response.body()?.anime.toString())

                    Log.d("Response", response.body()?.character.toString())
                    binding.character.setText(response.body()?.character.toString())

                    Log.d("Response", response.body()?.quote.toString())
                    binding.phrase.setText(response.body()?.quote.toString())

                } else {
                    Log.d("Response", response.errorBody().toString())
                }
                val myTitle = response.body()?.anime.toString().replace(" ", "_").lowercase()
                Log.d("myTitle", myTitle)

                viewModel.getPostImage((myTitle))
                viewModel.myResponseImage.observe(this, Observer { response ->
                    if (response.isSuccessful) {
                        Glide.with(this)
                            .load(response.body()?.img)
                            .into(imagePath)
                        Log.d("ResponseImage", response.body()?.img.toString())
                    }
                })
            })
            //val myTitle =  binding.anime.text.toString().replace(" ", "_").lowercase()



        }
    }



























}