package com.example.moviesapp.data.models

import android.content.Context
import com.example.moviesapp.network.dataagents.RetrofitDataAgent
import com.example.moviesapp.persistence.MovieDatabase

abstract class BaseModel{

    var mDagaAgent: RetrofitDataAgent

    lateinit var database: MovieDatabase

    constructor(){
        mDagaAgent = RetrofitDataAgent.getObjInstance()
    }

    fun initDatabase(context: Context){
        database = MovieDatabase.getInstance(context)
    }
}