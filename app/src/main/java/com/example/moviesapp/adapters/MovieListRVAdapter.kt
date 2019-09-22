package com.example.moviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesapp.R
import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.delegates.GetMovieInfoDelegate
import com.example.moviesapp.views.viewholder.MovieItemViewHolder

class MovieListRVAdapter(private val delegate: GetMovieInfoDelegate) : BaseAdapter<MovieItemViewHolder, Movie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_now_showing, parent, false)
        return MovieItemViewHolder(view, delegate)
    }

}