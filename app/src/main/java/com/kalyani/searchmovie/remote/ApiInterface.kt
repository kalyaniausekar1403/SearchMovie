package com.kalyani.searchmovie.remote

import com.kalyani.searchmovie.model.SearchMovieResponse
import retrofit2.http.GET


import retrofit2.http.Query

interface ApiInterface {

    @GET("/")
    fun getMovieBySearch(
        @Query("s") search : String,
        @Query("page") page : Int,
        @Query("apiKey") apiKey : String

    ) : SearchMovieResponse

}