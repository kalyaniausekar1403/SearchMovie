package com.kalyani.searchmovie.remote

import com.kalyani.searchmovie.model.SearchMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("{apiKey= 5b5ecd89}")
    fun getMovieBySearch(
        @Query("s") search : String,
        @Query("page") page : Int

    ) : Call<List<SearchMovieResponse>>

}