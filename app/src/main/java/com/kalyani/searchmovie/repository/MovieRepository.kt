package com.kalyani.searchmovie.repository

import com.kalyani.searchmovie.model.SearchMovieResponse
import com.kalyani.searchmovie.remote.RetrotfitInstance
import retrofit2.http.Query

class MovieRepository {

    fun searchMovies(query:String,page:Int) : SearchMovieResponse {
        return RetrotfitInstance.api.getMovieBySearch(query,page,"5b5ecd89")
    }

}