package com.example.moviesapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie",
    indices = arrayOf(Index(value = ["id"], unique = true)))
data class Movie(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id_pk")
    val movieIdPk: Int,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "movie_name")
    @SerializedName("movie_name")
    val movieName: String,

    @ColumnInfo(name = "imdb")
    val imdb: Double,

    @ColumnInfo(name = "rotten_tomato")
    @SerializedName("rotten_tomato")
    val rottenTomato: Int,

    @ColumnInfo(name = "meta_centric")
    @SerializedName("meta_centric")
    val metaCentric: Int,

    @ColumnInfo(name = "genre")
    val genre: List<Genre>,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster")
    val poster: String
)