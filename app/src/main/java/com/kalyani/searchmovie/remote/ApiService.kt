package com.kalyani.searchmovie.remote

import com.kalyani.searchmovie.model.MovieDetail
import com.kalyani.searchmovie.model.MovieResponse
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