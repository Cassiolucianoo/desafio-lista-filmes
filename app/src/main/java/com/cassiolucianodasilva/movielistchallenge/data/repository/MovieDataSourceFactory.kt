package com.cassiolucianodasilva.movielistchallenge.data.repository

import MovieDataSource
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.cassiolucianodasilva.movielistchallenge.data.api.TheMovieDBInterface
import com.cassiolucianodasilva.movielistchallenge.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}