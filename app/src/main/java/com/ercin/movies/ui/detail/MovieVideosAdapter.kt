package com.ercin.movies.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ercin.movies.R
import com.ercin.movies.model.movie.MovieResult
import com.ercin.movies.model.videos.MovieVideoResults
import com.ercin.movies.util.Constant
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MovieVideosAdapter(val clickVideoFunction: (String) -> Unit) :
    RecyclerView.Adapter<MovieVideosAdapter.MovieVideoViewHolder>() {

    var moviesVideoList: List<MovieVideoResults> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return MovieVideoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (moviesVideoList.size > 5)
            return 5
        else
            return moviesVideoList.size
        //return moviesVideoList.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieVideoViewHolder, position: Int) {
        val movieVideo = moviesVideoList[position]

        holder.videoPlayer.initialize(Constant.YOUTUBE_API_KEY, object : YouTubeThumbnailView.OnInitializedListener {
            override fun onInitializationSuccess(pView: YouTubeThumbnailView?, pLoader: YouTubeThumbnailLoader?) {
                pLoader?.setVideo(movieVideo.key)
                Log.e("YYYY", "Step1-InitializeSuccess")

                pLoader?.setOnThumbnailLoadedListener(object : YouTubeThumbnailLoader.OnThumbnailLoadedListener {
                    override fun onThumbnailLoaded(p0: YouTubeThumbnailView?, p1: String?) {
                        Log.e("YYYY", "Step2-ThumbnailLoaded")
                        pLoader.release()
                    }

                    override fun onThumbnailError(p0: YouTubeThumbnailView?, p1: YouTubeThumbnailLoader.ErrorReason?) {
                        Log.e("YYYY", "ThumbnailError")
                    }
                })
            }

            override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {
                Log.e("YYYY", "InitializeError")
            }
        })

        holder.videoPlayer.setOnClickListener {
            clickVideoFunction(movieVideo.key)
        }
    }

    class MovieVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoPlayer: YouTubeThumbnailView = itemView.findViewById(R.id.item_video_thumb)
    }
}