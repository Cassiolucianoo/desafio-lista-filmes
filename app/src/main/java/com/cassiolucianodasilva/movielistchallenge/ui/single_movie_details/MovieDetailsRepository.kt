package com.cassiolucianodasilva.movielistchallenge.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.cassiolucianodasilva.movielistchallenge.data.api.TheMovieDBInterface
import com.cassiolucianodasilva.movielistchallenge.data.repository.MovieDetailsNetworkDataSource
import com.cassiolucianodasilva.movielistchallenge.data.repository.NetworkState
import com.cassiolucianodasilva.movielistchallenge.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}