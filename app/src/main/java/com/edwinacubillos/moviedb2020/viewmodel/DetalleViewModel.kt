package com.edwinacubillos.moviedb2020.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.squareup.picasso.Picasso

class DetalleViewModel : ViewModel() {

    private var movie: MutableLiveData<ResultsItem> = MutableLiveData()

    fun setDetalleMovie(movie: ResultsItem) {
        this.movie.value = movie
    }

   fun getMovie() = movie

    companion object {
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + imageUrl).into(imageView)
        }
    }
}