package com.edwinacubillos.moviedb2020.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edwinacubillos.moviedb2020.model.MainObservable
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.edwinacubillos.moviedb2020.view.MoviesAdapter
import com.squareup.picasso.Picasso

class MainViewModel : ViewModel() {

    private var mainObservable: MainObservable = MainObservable()
    private var moviesAdapter: MoviesAdapter ?= null

    fun callMovies(){
        mainObservable.callMovies()
    }

    fun getMovies() : MutableLiveData<List<ResultsItem>>{
        return mainObservable.getMovies()
    }

    fun setMoviesInMoviesAdapter(movies: List<ResultsItem>){
        moviesAdapter?.setMoviesList(movies)
        moviesAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerMoviesAdapter() : MoviesAdapter? {
        moviesAdapter = MoviesAdapter(this)
        return moviesAdapter
    }

    fun getMoviesAt(position: Int): ResultsItem?{
        var movie: List<ResultsItem>? = mainObservable.getMovies().value
        return movie?.get(position)
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String){
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+imageUrl).into(imageView)
        }
    }
}