package com.cassiolucianodasilva.movielistchallenge.data.api

import com.cassiolucianodasilva.movielistchallenge.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/718444?api_key=cfb0880361a3d7c268d740566f62cc08&language=pt-BR
   // https://api.themoviedb.org/3/
    //https://api.themoviedb.org/3/movie/now_playing?api_key=cfb0880361a3d7c268d740566f62cc08&language=pt-BR

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}
