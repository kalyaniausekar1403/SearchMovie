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

    val api: ApiService by lazy {
        retrofitInstance().create(ApiService::class.java)
    }
}

// another way
object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .build()
            .create(ApiService::class.java) // crete api service class here
    }
}

