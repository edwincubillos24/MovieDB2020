package com.edwinacubillos.moviedb2020

import android.util.Log
import com.edwinacubillos.moviedb2020.model.Movies
import com.edwinacubillos.moviedb2020.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel(var mainPresenter: MainMVP.Presenter) : MainMVP.Model {

    override fun loadList() {
        val apiKey = "ff29f617b45b36aab5aa78a6fa04677f"

        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<Movies> {
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    mainPresenter.showErrorMsg(t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful) {
                        mainPresenter.envioLista(response.body()?.resultsItems as ArrayList<ResultsItem>)
                    }
                }
            })
    }
}