package com.example.moviesapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.vos.Movie

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList: List<Movie>)

    @Query("SELECT * FROM movie")
    abstract fun getAllMovies() : List<Movie>

    @Query("SELECT * FROM movie WHERE id=:id")
    abstract fun findMovieById(id: Int) : Movie

}