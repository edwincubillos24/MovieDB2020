package com.edwinacubillos.moviedb2020

import com.edwinacubillos.moviedb2020.model.ResultsItem

interface MainMVP {

    interface View{
        fun showProgressBar()
        fun showErrorMsg(message: String?)
        fun showMovieList(movieList: ArrayList<ResultsItem>)
        fun hideProgressBar()
    }

    interface Presenter{
        fun loadList()
        fun showErrorMsg(message: String?)
        fun envioLista(movieList: ArrayList<ResultsItem>)
    }

    interface Model{
        fun loadList()
    }
}