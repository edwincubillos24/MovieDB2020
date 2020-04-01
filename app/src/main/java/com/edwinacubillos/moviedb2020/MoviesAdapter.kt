package com.edwinacubillos.moviedb2020

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesAdapter(moviesList: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesList = ArrayList<ResultsItem>()

    init {
        this.moviesList = moviesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.setMovie(movie)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var movie: ResultsItem? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setMovie(movie: ResultsItem) {
            this.movie = movie
            val URL_IMAGES = "https://image.tmdb.org/t/p/w500"
            itemView.tv_title.text = movie.title
            itemView.tv_voteAverage.text = movie.voteAverage.toString()
            itemView.tv_releaseDate.text = movie.releaseDate
            Glide.with(itemView.context).load(URL_IMAGES + movie.posterPath).into(itemView.iv_picture)
        }

        override fun onClick(v: View) {
      /*      val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("movie", movie)
            intent.putExtra("envia","list")
            itemView.context.startActivity(intent)*/
        }
    }
}