package com.edwinacubillos.moviedb2020.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.moviedb2020.R
import com.edwinacubillos.moviedb2020.databinding.ActivityMainBinding
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.edwinacubillos.moviedb2020.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)
    }

    fun setupBinding (savedInstanceState: Bundle?) {

        var activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.model = mainViewModel

        setUpListUpdate()
    }

    fun setUpListUpdate(){

        mainViewModel?.callMovies()

        mainViewModel?.getMovies()?.observe(this , Observer {
            Log.d("Movie", it[0].title)
            mainViewModel?.setMoviesInMoviesAdapter(it)
        }
        )

    }
}
