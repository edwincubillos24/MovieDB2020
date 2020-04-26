package com.edwinacubillos.moviedb2020.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable : BaseObservable() {

    private var mainRepository: IMainRepository = MainRepository()


    fun callMovies(){
        mainRepository.callMoviesAPI()
    }

    fun getMovies() : MutableLiveData<List<ResultsItem>>{
        return mainRepository.getMovies()
    }
}

