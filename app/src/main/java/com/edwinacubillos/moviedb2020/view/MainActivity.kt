package com.edwinacubillos.moviedb2020.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.edwinacubillos.moviedb2020.R
import com.edwinacubillos.moviedb2020.databinding.ActivityMainBinding
import com.edwinacubillos.moviedb2020.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {

        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.model = mainViewModel
        activityMainBinding.lifecycleOwner = this
        setUpListUpdate()
    }

    fun setUpListUpdate() {
        mainViewModel?.callMovies()

        mainViewModel?.getMovies()?.observe(this, Observer {movie ->
            Log.d("Movie", movie[0].title)
            mainViewModel?.setMoviesInMoviesAdapter(movie)
        })

        setupListClick()
    }

    fun setupListClick(){
        mainViewModel?.getMovieSelected()?.observe(this, Observer{movie->
           val intent = Intent (this, DetalleActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        })
    }
}
