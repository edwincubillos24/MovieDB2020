package com.edwinacubillos.moviedb2020.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.edwinacubillos.moviedb2020.model.server.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository : IMainRepository {

    private var movies = MutableLiveData<List<ResultsItem>>()

    override fun getMovies() : MutableLiveData<List<ResultsItem>> {
        return movies
    }

    override fun callMoviesAPI() {
        val apiKey = "ff29f617b45b36aab5aa78a6fa04677f"
        var moviesList : ArrayList<ResultsItem>?= ArrayList()

        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<Movies> {
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.e("Error", t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful) {
                        moviesList = response.body()?.resultsItems as ArrayList<ResultsItem>
                    }
                    movies.value = moviesList
                }
            })
    }
}