package com.example.moviesapp.data.models

import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.delegates.GetMovieInfoDelegate
import com.example.moviesapp.utils.DUMMY_ACCESS_TOKEN

object MovieModelImpl : BaseModel(), ExploreModel{

    override fun getAllMovie(
        accessToken: String,
        delegate: GetMovieInfoDelegate,
        onSuccess: (List<Movie>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        if(database.areMoviesExistInDB()){

            var moviesList = database.movieDao().getAllMovies()
            onSuccess(moviesList)

        } else {

            mDagaAgent.getMovie(DUMMY_ACCESS_TOKEN,
                {
                    database.movieDao().insertMovies(it)
                    onSuccess(it)
                },
                onFailure)
        }
    }

    fun getMovieById(id: Int) : Movie{
        return database.movieDao().findMovieById(id)
    }
}