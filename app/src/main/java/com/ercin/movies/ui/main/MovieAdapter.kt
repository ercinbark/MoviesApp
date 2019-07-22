package com.ercin.movies.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ercin.movies.R
import com.ercin.movies.databinding.ItemMovieBinding
import com.ercin.movies.model.movie.MovieResult

class MovieAdapter(val clickFunction: (Int, MovieResult?) -> Unit ) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: List<MovieResult> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies.get(position)
        holder.binding.movie = movie

        holder.binding.itemMoviePoster.setOnClickListener {
            clickFunction(movie.movieId ?:0, movie)
        }
    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    /*fun dataChangeObserve() {
        movies {
            notifyDataSetChanged()
        }
    }*/
}

