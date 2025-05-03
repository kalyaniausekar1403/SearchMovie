package com.kalyani.searchmovie.model

data class MovieResponse(
    val Response: String,
    val Search: List<MovieDetail>,
    val totalResults: String
)