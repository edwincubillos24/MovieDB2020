package com.edwinacubillos.moviedb2020

import com.edwinacubillos.moviedb2020.model.ResultsItem

class MainPresenter(var mainView: MainMVP.View) : MainMVP.Presenter {

    private var mainModel : MainMVP.Model = MainModel(this)

    override fun loadList() {
        mainView.showProgressBar()
        mainModel.loadList()
    }

    override fun showErrorMsg(message: String?) {
        mainView.showErrorMsg(message)
        mainView.hideProgressBar()
    }

    override fun envioLista(movieList: ArrayList<ResultsItem>) {
        mainView.showMovieList(movieList)
        mainView.hideProgressBar()
    }
}
