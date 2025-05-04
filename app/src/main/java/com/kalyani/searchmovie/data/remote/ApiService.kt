package com.kalyani.searchmovie.data.remote

import com.kalyani.searchmovie.data.model.MovieDetail
import com.kalyani.searchmovie.data.model.MovieResponse
import retrofit2.http.GET


import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun searchMovies(
        @Query("s") query : String,
        @Query("page") page : Int = 1,
        @Query("apiKey") apiKey : String) : MovieResponse

    @GET("/")
    suspend fun getMovieDetails(
        @Query("apikey") apiKey: String,
        @Query("i") imdbId: String
    ): MovieDetail

}