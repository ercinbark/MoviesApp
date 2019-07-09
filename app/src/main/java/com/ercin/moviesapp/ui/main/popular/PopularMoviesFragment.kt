package com.ercin.moviesapp.ui.main.popular

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ercin.moviesapp.R
import com.ercin.moviesapp.ui.main.MovieAdapter
import com.ercin.moviesapp.ui.main.MovieAdapterNavigatorInterface

class PopularMoviesFragment : Fragment(), MovieAdapterNavigatorInterface {

    lateinit var viewModel: PopularMoviesViewModel
    var rv: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)
        viewModel.setNavigator(this)
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.recyclerView)
        viewModel.updateAdapter()

    }

    override fun setMovieAdapter(adapter: MovieAdapter) {
        rv?.layoutManager = GridLayoutManager(context, 2)
        rv?.adapter = adapter
    }
}