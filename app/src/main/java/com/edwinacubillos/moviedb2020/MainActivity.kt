package com.edwinacubillos.moviedb2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.moviedb2020.model.Movies
import com.edwinacubillos.moviedb2020.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listMovies = ArrayList<ResultsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        loadList()
    }

    private fun loadList() {
        val apiKey="ff29f617b45b36aab5aa78a6fa04677f"

        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<Movies> {
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.d("Error", t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful) {
                        listMovies = response.body()?.resultsItems as ArrayList<ResultsItem>
                        val moviesAdapter = MoviesAdapter(listMovies)
                        recyclerView.adapter = moviesAdapter
                    }
                }
            })
    }
}
