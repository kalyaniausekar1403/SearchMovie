package com.kalyani.searchmovie.repository

import com.kalyani.searchmovie.model.MovieResponse
import com.kalyani.searchmovie.remote.RetrotfitInstance

class MovieRepository {

    suspend fun searchMovies(query:String,page:Int) : MovieResponse {
        return RetrotfitInstance.api.searchMovies(query,page,"5b5ecd89")
    }

}