package com.example.moviesapp.network.responses

import com.example.moviesapp.data.vos.Movie

data class GetMovieResponse(
    val code: Int,
    val message: String,
    val data: List<Movie>
)