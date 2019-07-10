package com.ercin.moviesapp.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ercin.moviesapp.R
import com.ercin.moviesapp.databinding.ItemMovieBinding
import com.ercin.moviesapp.model.movie.MovieResponse
import com.ercin.moviesapp.model.movie.MovieResult

class MovieAdapter(var movies: MutableLiveData<List<MovieResult>>, val clickFunction: (Int, MovieResult?) -> Unit ) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies.value?.get(position)
        holder.binding.movie = movie

        holder.binding.itemMoviePoster.setOnClickListener {
            clickFunction(movie?.movieId ?:0, movie)
        }
    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    fun dataChangeObserve() {
        movies.observeForever {
            notifyDataSetChanged()
        }
    }
}