package com.example.moviesapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviesapp.data.vos.Movie
import com.example.moviesapp.persistence.daos.MovieDao
import com.example.moviesapp.persistence.typeconverters.GenreListTypeConverter
import com.example.moviesapp.utils.MOVIE_DB

@Database(entities = arrayOf(Movie::class), version = 3, exportSchema = false)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object{

        private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase{

            if(instance == null){

                instance = Room.databaseBuilder(context, MovieDatabase::class.java, MOVIE_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            var db = instance!!

            return db
        }
    }

    fun areMoviesExistInDB(): Boolean{
        return movieDao().getAllMovies().isNotEmpty()
    }
}