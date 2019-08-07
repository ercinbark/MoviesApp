package com.ercin.movies.ui.main.movies

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ercin.movies.R
import com.ercin.movies.base.BaseFragment
import com.ercin.movies.ui.detail.MovieDetailActivity
import com.ercin.movies.ui.main.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment(), PopularMovieAdapterNavigatorInterface {

    private val myMoviesViewModel: MovieListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myMoviesViewModel.setNavigator(this)
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myMoviesViewModel.requestPopularMovies()
        myMoviesViewModel.loading.observe(viewLifecycleOwner,androidx.lifecycle.Observer<Boolean>{
            if (it)
                getBaseActivity().showFullScreenProgressDialog(false)
            else
                getBaseActivity().dismissFullScreenProgressDialog()
        })

    }

    override fun setAdapter(adapter: MovieAdapter) {
        rc_popular?.layoutManager = GridLayoutManager(context, 2)
        rc_popular?.adapter = adapter

    }

    override fun goToMovieDetail(moveiID: Int) {
        Log.e("comeID", moveiID.toString())
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra("movieID", moveiID)
        startActivity(intent)
    }

}