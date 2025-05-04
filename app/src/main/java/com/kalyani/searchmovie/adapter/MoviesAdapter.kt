package com.kalyani.searchmovie.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kalyani.searchmovie.R
import com.kalyani.searchmovie.data.model.MovieDetail

class MoviesAdapter(private val onItemClick: (MovieDetail) -> Unit): ListAdapter<MovieDetail, MoviesAdapter.MovieViewHolder>(DiffCallback()) {


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val poster = view.findViewById<ImageView>(R.id.ivPoster)
        val parentLayout = view.findViewById<LinearLayout>(R.id.parentLayout)

        fun bind(movie: MovieDetail, onClick: (MovieDetail) -> Unit) {
            title.text = movie.Title
           itemView.setOnClickListener { (onClick(movie))}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie,onItemClick)
      //  holder.title.text = movie.Title
        Glide.with(holder.itemView).load(movie.Poster).into(holder.poster)



    }

    class DiffCallback : DiffUtil.ItemCallback<MovieDetail>() {
        override fun areItemsTheSame(old: MovieDetail, new: MovieDetail) = old.imdbID == new.imdbID
        override fun areContentsTheSame(old: MovieDetail, new: MovieDetail) = old == new
    }
}
