package com.edwinacubillos.moviedb2020.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinacubillos.moviedb2020.BR
import com.edwinacubillos.moviedb2020.R
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.edwinacubillos.moviedb2020.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesAdapter(var mainViewModel: MainViewModel) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesList: List<ResultsItem>? = null

    fun setMoviesList(movies: List<ResultsItem>) {
        this.moviesList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = moviesList?.size ?: 0

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.setMovie(mainViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.movie_list_item
    }


    class MoviesViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setMovie(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
        }
    }
}