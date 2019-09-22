package com.example.moviesapp.network.dataagents

import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.network.MovieApi
import com.example.moviesapp.network.responses.GetMovieResponse
import com.example.moviesapp.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : MovieDataAgent{

    fun getObjInstance() : RetrofitDataAgent{
        return RetrofitDataAgent
    }

    private val movieApi: MovieApi

    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    override fun getMovie(
        accessToken: String,
        onSuccess: (List<Movie>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        val call = movieApi.getAllMovies(accessToken)

        call.enqueue(object : Callback<GetMovieResponse>{

            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {

                val moviesResponse = response.body()

                if(moviesResponse != null){

                    if (moviesResponse.data != null){

                        onSuccess(moviesResponse.data)

                    } else {

                        onFailure(response.message())

                    }

                } else {

                    onFailure(response.message())
                }
            }

        })
    }

}