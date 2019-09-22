package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.data.models.BaseModel
import com.example.moviesapp.data.models.MovieModelImpl

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
    }
}