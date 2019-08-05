package com.ercin.movies.ui.main.movies

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
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.coroutines.Job
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment(), PopularMovieAdapterNavigatorInterface {

    val myMoviesViewModel: MovieListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myMoviesViewModel.setNavigator(this)
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myMoviesViewModel.requestPopularMovies()

    }

    override fun setAdapter(adapter: MovieAdapter) {
        rc_popular?.layoutManager = GridLayoutManager(context, 2)
        rc_popular?.adapter = adapter
    }

    override fun goToMovieID(moveiID: Int) {
        Log.e("comeID", moveiID.toString())
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra("movieID", moveiID)
        startActivity(intent)
    }
}