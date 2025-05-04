package com.kalyani.searchmovie

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var detailsText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_details)
        detailsText = findViewById(R.id.detailsText)


        val movie_title = intent.getStringExtra("movie_title")

        detailsText.text = movie_title
    }
}