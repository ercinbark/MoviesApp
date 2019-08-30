package com.ercin.movies.ui.detail.tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ercin.movies.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MovieYoutubePlayerDialog : DialogFragment() {
    var movieYoutubeId: String = ""

    companion object{
        fun showMovieYoutubePlayerDialog(videoId: String): MovieYoutubePlayerDialog {
            val args = Bundle()
            args.putString("movieVideoID", videoId)
            val movieYoutubePlayerDialog =
                MovieYoutubePlayerDialog()
            movieYoutubePlayerDialog.arguments = args
            Log.e("YYYY", "Step-2 VideoID : $videoId")
            return movieYoutubePlayerDialog
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieYoutubeId = arguments?.getString("movieVideoID", "0").toString()
        Log.e("YYYY", "Step-3 VideoID $movieYoutubeId")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.movie_video_player_dialog, container, false)

        val player = v.findViewById<YouTubePlayerView>(R.id.yt_player)

        player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                Log.e("YYYY", "Step-4 VideoID $movieYoutubeId")
                youTubePlayer.loadVideo(movieYoutubeId, 0f)
            }
        })
        return v

    }

}