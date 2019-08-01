package com.ercin.movies.ui.main.movies

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
import com.ercin.movies.ui.main.MainActivity
import com.ercin.movies.ui.main.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), PopularMovieAdapterNavigatorInterface {

    lateinit var viewModel: MoviesViewModel
    var rv: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        viewModel.setNavigator(this)
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv=view.findViewById(R.id.rc_popular)
        viewModel.requestPopularMovies()
    }

    override fun setAdapter(adapter: MovieAdapter) {
        rv?.layoutManager = GridLayoutManager(context, 2)
        rv?.adapter = adapter
    }

    override fun goToMovieID(moveiID: Int) {
        Log.e("comeID", moveiID.toString())
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra("movieID", moveiID)
        startActivity(intent)
    }
}