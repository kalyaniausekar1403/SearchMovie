package com.kalyani.searchmovie.model

data class MovieResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)