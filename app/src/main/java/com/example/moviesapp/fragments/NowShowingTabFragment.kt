package com.example.moviesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.adapters.MovieListRVAdapter
import com.example.moviesapp.data.models.MovieModelImpl
import com.example.moviesapp.delegates.GetMovieInfoDelegate
import com.example.moviesapp.utils.DUMMY_ACCESS_TOKEN

class NowShowingTabFragment(private  var delegate: GetMovieInfoDelegate) : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.now_showing_tab_fragment, container, false)

        val rvExplore: RecyclerView = view.findViewById(R.id.rv_explore)

        rvExplore.setHasFixedSize(true)
        rvExplore.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)

        val movieListRVAdapter = MovieListRVAdapter(delegate)

        MovieModelImpl.getAllMovie(DUMMY_ACCESS_TOKEN,

            delegate,

            {
                movieListRVAdapter.setNewData(it.toMutableList())
                rvExplore.adapter = movieListRVAdapter
            },
            {
                Toast.makeText(activity, "On Failed!", Toast.LENGTH_SHORT).show()
            })

        return view
    }

}