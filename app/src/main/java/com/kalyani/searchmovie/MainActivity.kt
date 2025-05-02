package com.kalyani.searchmovie

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.kalyani.searchmovie.model.Search
import com.kalyani.searchmovie.model.SearchMovieResponse
import com.kalyani.searchmovie.remote.ApiInterface
import com.kalyani.searchmovie.remote.RetrotfitInstance
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var searchview: SearchView
    private lateinit var movieAdapter : ArrayAdapter<Search>
    var searchList: ArrayList<Search> = ArrayList<Search>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        searchview = findViewById<SearchView>(R.id.search)
        apiInterface = RetrotfitInstance.retrofitInstance().create(ApiInterface::class.java)
        movieAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,searchList)



        searchview.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchMovie(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                movieAdapter.filter.filter(newText)
                return false

            }

        })


    }

    fun searchMovie(search: String) {

            val call = apiInterface.getMovieBySearch(search,1)
            call.enqueue(object : retrofit2.Callback<List<SearchMovieResponse>> {
                override fun onResponse(
                    p0: Call<List<SearchMovieResponse>>,
                    response: Response<List<SearchMovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", "onResponse: $response")
                    }
                }

                override fun onFailure(p0: Call<List<SearchMovieResponse>>, p1: Throwable) {
                    TODO("Not yet implemented")
                }


            })

    }

}

