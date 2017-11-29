package com.example.cristiandev.pelicula.ui

import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.di.ActivityScope
import com.example.cristiandev.pelicula.ui.detail.DetailActivity
import javax.inject.Inject

/**
 * Created by CristianDev on 27/11/2017.
 */
@ActivityScope
class Navigation @Inject constructor(val activity:MainActivity){

    fun navigateToDetail(pelicula: Pelicula){
        activity.putFragment(R.id.container,DetailActivity.instance(pelicula))
    }
}