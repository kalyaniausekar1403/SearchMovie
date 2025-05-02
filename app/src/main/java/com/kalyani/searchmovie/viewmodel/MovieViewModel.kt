package com.kalyani.searchmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.searchmovie.model.Movie
import com.kalyani.searchmovie.repository.MovieRepository

class MovieViewModel() : ViewModel() {

    private val repository = MovieRepository()

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getMovies(query:String, page:Int = 1) {
        try {

            val response = repository.searchMovies(query,page)
            if (response.Response == "True") {
                _movies.value = response.Search ?: emptyList()
            }
            else {
                _error.value = "No Movies Found"
            }
        }catch (e:Exception) {
            e.printStackTrace()
        }
    }
}