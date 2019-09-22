package com.example.moviesapp.data.models

import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.delegates.GetMovieInfoDelegate

interface ExploreModel {
    fun getAllMovie(
        accessToken: String,
        delegate: GetMovieInfoDelegate,
        onSuccess: (List<Movie>) -> Unit,
        onFailure: (String) -> Unit
    )
}