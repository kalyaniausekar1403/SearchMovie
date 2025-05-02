package com.kalyani.searchmovie.model

data class SearchMovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)