package com.kalyani.searchmovie.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrotfitInstance {

    fun retrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiInterface by lazy {
        retrofitInstance().create(ApiInterface::class.java)
    }
}

