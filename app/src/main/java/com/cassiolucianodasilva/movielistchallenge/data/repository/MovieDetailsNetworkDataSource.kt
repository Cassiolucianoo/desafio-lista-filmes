package com.cassiolucianodasilva.movielistchallenge.data.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cassiolucianodasilva.movielistchallenge.data.api.TheMovieDBInterface
import com.cassiolucianodasilva.movielistchallenge.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MovieDetailsNetworkDataSource (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState                   //with this get, no need to implement get function to get networkSate

    private val _downloadedMovieDetailsResponse =  MutableLiveData<MovieDetails>()
    val downloadedMovieResponse: LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int) {

        _networkState.postValue(NetworkState.LOADING)


        try {
            compositeDisposable.add(
                apiService.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedMovieDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("MovieDetailsDataSource", it.message)
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("MovieDetailsDataSource",e.message)
        }


    }
}