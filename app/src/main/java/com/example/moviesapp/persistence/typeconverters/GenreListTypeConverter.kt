package com.example.moviesapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.moviesapp.data.vos.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreListTypeConverter {

    @TypeConverter
    fun toString(list: List<Genre>): String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<Genre>{
        val typeToken = object : TypeToken<List<Genre>>() {
        }.type
        return Gson().fromJson(json, typeToken)
    }
}