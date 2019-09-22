package com.example.moviesapp.network

import com.example.moviesapp.network.responses.GetMovieResponse
import com.example.moviesapp.utils.GET_MOVIES
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieApi {

    @FormUrlEncoded
    @POST(GET_MOVIES)
    fun getAllMovies(@Field("access_token") accessToken: String) : Call<GetMovieResponse>
}