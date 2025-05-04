package com.kalyani.searchmovie.data.model

data class MovieResponse(
    val Response: String,
    val Search: List<MovieDetail>,
    val totalResults: String
)