package com.example.mytest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytest.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.widget_video.view.*

class VideoRecyclerViewAdapter(private var dataList:ArrayList<String>, private val context: Context): RecyclerView.Adapter<VideoRecyclerViewAdapter.ViewHolderVideo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVideo {
        return ViewHolderVideo(LayoutInflater.from(context).inflate(R.layout.widget_video, parent, false))
    }

    override fun getItemCount(): Int {
//        var value = 0
//        if (dataList.isNotEmpty()){
//            value = dataList.size
//        }
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderVideo, position: Int) {
        holder.youtubePlayer.getYouTubePlayerWhenReady(object : YouTubePlayerCallback {
            override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                val sampleVideoId = dataList[position]
                youTubePlayer.cueVideo(sampleVideoId, 0.toFloat())  //It loads the thumbnail and ready to play
            }
        })
    }

    class ViewHolderVideo (view: View) : RecyclerView.ViewHolder(view) {
        val youtubePlayer: YouTubePlayerView = view.youtubePlayer
    }
}