package com.ercin.movies.ui.detail.tabs


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ercin.movies.R
import com.ercin.movies.ui.detail.MovieDetailViewModel
import kotlinx.android.synthetic.main.fragment_movie_overview.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.core.parameter.parametersOf

class MovieOverviewFragment : androidx.fragment.app.Fragment(), MovieVideoNavigatorInterface {

    private val viewModelMovieDetail: MovieDetailViewModel by sharedViewModel()
    private var movieVideoDetailId: Int = 0

    private val viewModelMovieOverview: MovieOverviewViewModel by inject {
        parametersOf(
            movieVideoDetailId
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieVideoDetailId = viewModelMovieDetail.movieId

        viewModelMovieDetail.movieDetailResponse.observe(viewLifecycleOwner, Observer {
            tv_movie_detail_runtime.text = it.runtime + " dakika"
            tv_movie_detail_overview.text = it.overview
        })

        viewModelMovieOverview.setMovieVideoNavigator(this)
        viewModelMovieOverview.requestMovieVideos()


    }

    override fun showMovieVideoAdapter(adapter: MovieVideosAdapter) {
        val layoutManagerMovieVideo =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rcMovieVideo.layoutManager = layoutManagerMovieVideo
        rcMovieVideo.adapter = adapter
    }

    override fun watchTrailerDialog(videoID: String) {
        Log.e("YYYY", "Come VideoID : $videoID")
        Log.e("YYYY", "Step-1 VideoID $videoID")
        val videoDialog = MovieYoutubePlayerDialog.showMovieYoutubePlayerDialog(videoId = videoID)
        videoDialog.show(childFragmentManager, "videoDialog")

    }

}
