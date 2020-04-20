package com.edwinacubillos.moviedb2020.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {

    fun callMoviesAPI()
    fun getMovies() : MutableLiveData<List<ResultsItem>>
}