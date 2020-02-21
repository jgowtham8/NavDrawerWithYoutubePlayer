package com.example.mytest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytest.R
import com.example.mytest.adapters.VideoRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_video_list.*

class VideoListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var videoData: ArrayList<String> = arrayListOf()

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshVideoList?.isRefreshing = true
        loadVideosInRecyclerView()

        swipeRefreshVideoList?.setOnRefreshListener { loadVideosInRecyclerView() }
    }

    private fun loadVideosInRecyclerView() {
        videoData.clear()

        videoData.add("wb49-oV0F78")//mission
        videoData.add("7GqClqvlObY")//spectre
        videoData.add("Kopyc23VfSw")//fast
        videoData.add("HZ7PAyCDwEg")//hobbs
        videoData.add("7TavVZMewpY")//lion
        videoData.add("wb49-oV0F78")//mission
        videoData.add("7GqClqvlObY")//spectre
        videoData.add("Kopyc23VfSw")//fast
        videoData.add("HZ7PAyCDwEg")//hobbs
        videoData.add("7TavVZMewpY")//lion

        recyclerViewVideoList?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerViewVideoList?.adapter = VideoRecyclerViewAdapter(videoData, requireContext())

        swipeRefreshVideoList?.isRefreshing = false
    }

}
