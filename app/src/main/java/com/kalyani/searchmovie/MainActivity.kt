package com.kalyani.searchmovie

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.doAfterTextChanged
import com.kalyani.searchmovie.model.Search
import com.kalyani.searchmovie.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel : MovieViewModel by viewModels()
    private lateinit var searchText : AutoCompleteTextView
    private var movies : List<Search> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        searchText = findViewById(R.id.movieName)



        viewModel.movies.observe(this) { movieList ->
            movies = movieList
            val titles = movieList.map { it.Title }
            val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, titles)
            searchText.setAdapter(adapter)
            searchText.showDropDown()

//            searchText.setOnItemClickListener { _, _, position, _ ->
//                val selectedMovie = movieList[position]
//                val intent = Intent(this, MovieDetailsActivity::class.java)
//                //intent.putExtra("movie", selectedMovie)
//                startActivity(intent)
//            }
        }
        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        searchText.doAfterTextChanged { text ->
            val query = text.toString()
            if (query.length >= 3) {
                viewModel.getMovies(query)
            }
        }
    }

}

