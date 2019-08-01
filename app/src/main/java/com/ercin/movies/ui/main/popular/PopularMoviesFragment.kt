package com.ercin.movies.ui.main.popular

import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ercin.movies.R
import com.ercin.movies.ui.detail.MovieDetailActivity
import com.ercin.movies.ui.main.MovieAdapter
import com.ercin.movies.ui.main.MovieAdapterNavigatorInterface

class PopularMoviesFragment : Fragment(), MovieAdapterNavigatorInterface {

    lateinit var viewModel: PopularMoviesViewModel
    var rv: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)
       // viewModel.setNavigator(this)
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.recyclerView)
        //viewModel.updateAdapter()

    }

    override fun setMovieAdapter(adapter: MovieAdapter) {
        rv?.layoutManager = GridLayoutManager(context, 2)
        rv?.adapter = adapter
    }

    override fun goToMovieID(movieId: Int) {
        Log.e("comeID", movieId.toString())
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra("movieID", movieId)
        startActivity(intent)
    }
}