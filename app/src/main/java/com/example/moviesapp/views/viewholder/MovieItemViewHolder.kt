package com.example.moviesapp.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.delegates.GetMovieInfoDelegate
import kotlinx.android.synthetic.main.item_view_now_showing.view.*

class MovieItemViewHolder(itemView: View, private val delegate: GetMovieInfoDelegate) : BaseViewHolder<Movie>(itemView){

    init {
        itemView.setOnClickListener {
            val id = data?.id
            if(id != null){

                itemView.setOnClickListener(View.OnClickListener {
                    delegate.onTabMovieItem(id)
                })
            }
        }
    }

    override fun bindData(data: Movie) {

        //movie-name.
        itemView.lbl_movie_name.text = data.movieName

        //movie-time

        //imdb
        itemView.lbl_001.text = data.imdb.toString()

        //rotten-to.
        itemView.lbl_002.text = data.rottenTomato.toString()+"%"

        //meta.
        itemView.lbl_003.text = data.metaCentric.toString()+"%"

        //bind data.
        Glide.with(itemView)
            .load(data.poster)
            .into(itemView.iv_poster)
    }

}