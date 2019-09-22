package com.example.moviesapp.network.dataagents

import com.example.moviesapp.data.vos.Movie

interface MovieDataAgent {

    fun getMovie(
        accessToken: String,
        onSuccess: (List<Movie>) -> Unit,
        onFailure: (String) -> Unit
    )
}