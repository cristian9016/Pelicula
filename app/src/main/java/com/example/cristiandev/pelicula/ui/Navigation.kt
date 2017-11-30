package com.example.cristiandev.pelicula.ui

import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie
import com.example.cristiandev.pelicula.di.ActivityScope
import com.example.cristiandev.pelicula.ui.fragments.DetailFragmentMovie
import com.example.cristiandev.pelicula.ui.fragments.DetailFragmentSerie
import javax.inject.Inject

/**
 * Created by CristianDev on 27/11/2017.
 */
@ActivityScope
class Navigation @Inject constructor(val activity:MainActivity){

    fun navigateToDetailPelicula(pelicula: Pelicula){
        activity.putFragment(R.id.container, DetailFragmentMovie.instance(pelicula))
    }
    fun navigateToDetailSerie(serie: Serie){
        activity.putFragment(R.id.container, DetailFragmentSerie.instance(serie))
    }
}