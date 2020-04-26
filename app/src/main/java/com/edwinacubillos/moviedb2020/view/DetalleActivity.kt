package com.edwinacubillos.moviedb2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.edwinacubillos.moviedb2020.R
import com.edwinacubillos.moviedb2020.databinding.ActivityDetalleBinding
import com.edwinacubillos.moviedb2020.model.ResultsItem
import com.edwinacubillos.moviedb2020.viewmodel.DetalleViewModel

class DetalleActivity : AppCompatActivity() {

    private var detalleViewModel: DetalleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {

        var activityDetalleBinding: ActivityDetalleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detalle)

        detalleViewModel = ViewModelProvider(this).get(DetalleViewModel::class.java)

        activityDetalleBinding.model = detalleViewModel
        activityDetalleBinding.lifecycleOwner = this

        detalleViewModel?.setDetalleMovie(intent?.getSerializableExtra("movie") as ResultsItem)
    }
}
