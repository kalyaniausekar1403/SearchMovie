package com.kalyani.searchmovie.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.omdbapi.com"

object RetrotfitInstance {


    private fun retrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofitInstance().create(ApiService::class.java)
    }
}

/*// another way
object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .build()
            .create(ApiService::class.java) // crete api service class here
    }
}*/

