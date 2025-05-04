package com.kalyani.searchmovie.data.repository

import com.kalyani.searchmovie.data.model.MovieResponse
import com.kalyani.searchmovie.data.remote.RetrotfitInstance

class MovieRepository {

    suspend fun searchMovies(query:String,page:Int) : MovieResponse {
        return RetrotfitInstance.api.searchMovies(query,page,"5b5ecd89")
    }

}