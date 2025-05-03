package com.kalyani.searchmovie.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalyani.searchmovie.model.MovieDetail
import com.kalyani.searchmovie.remote.RetrotfitInstance
import kotlinx.coroutines.launch

class MovieViewModel() : ViewModel() {

    val movieListLiveData = MutableLiveData<List<MovieDetail>>()
    private val apiKey = "5b5ecd89"

    suspend fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrotfitInstance.api.searchMovies(query,1,apiKey)
                Log.d("API_RESPONSE", response.toString()) // ✅ Add this
                if (response.Response == "True") {
                    movieListLiveData.value = response.Search ?: emptyList()
                } else {
                    movieListLiveData.value = emptyList()
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", e.message ?: "Error")
                movieListLiveData.value = emptyList()
            }
        }
    }
}