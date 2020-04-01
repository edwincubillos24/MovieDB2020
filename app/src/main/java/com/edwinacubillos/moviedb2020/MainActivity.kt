package com.edwinacubillos.moviedb2020

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.moviedb2020.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainMVP.View {

    private var mainPresenter: MainMVP.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
    }

    override fun onResume() {
        super.onResume()
        mainPresenter?.loadList()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showErrorMsg(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMovieList(movieList: ArrayList<ResultsItem>) {
      recyclerView.adapter = MoviesAdapter(movieList)
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
