package com.cassiolucianodasilva.movielistchallenge.vo


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val id: Int,
    val budget: Int,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Double
)


