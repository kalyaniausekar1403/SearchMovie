package com.kalyani.searchmovie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kalyani.searchmovie.adapter.MoviesAdapter
import com.kalyani.searchmovie.ui.viewmodel.MovieViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MoviesAdapter
    private lateinit var etSearch: EditText
    private lateinit var recyclerView: RecyclerView
    private var searchJob: Job? = null  // debounce


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch = findViewById(R.id.etSearch)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = MoviesAdapter { selectedMovie ->

            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("movie_title", selectedMovie.Title)
            startActivity(intent)

        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        viewModel.movieListLiveData.observe(this@MainActivity, Observer { list ->
            adapter.submitList(list)
        })


        // 🔍 Realtime search with debounce
        etSearch.addTextChangedListener {
            searchJob?.cancel()
            searchJob = lifecycleScope.launch {
                delay(300)
                val query = it.toString()
                if (query.length >= 3) {
                    Log.d("SEARCH_QUERY", query) // ✅ Check if query is logged
                    viewModel.searchMovies(query)
                }
            }
        }
    }

}

