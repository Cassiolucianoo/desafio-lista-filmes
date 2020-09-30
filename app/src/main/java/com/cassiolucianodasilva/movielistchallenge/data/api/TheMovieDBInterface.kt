package com.cassiolucianodasilva.movielistchallenge.data.api

import com.cassiolucianodasilva.movielistchallenge.vo.MovieDetails
import com.cassiolucianodasilva.movielistchallenge.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/718444?api_key=cfb0880361a3d7c268d740566f62cc08&language=pt-BR
   // https://api.themoviedb.org/3/
    //https://api.themoviedb.org/3/movie/now_playing?api_key=cfb0880361a3d7c268d740566f62cc08&language=pt-BR


    @GET("movie/now_playing")
    fun getPopularMovie(@Query("Page") page: Int):Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}
