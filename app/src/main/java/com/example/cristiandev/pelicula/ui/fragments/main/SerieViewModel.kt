package com.example.cristiandev.pelicula.ui.fragments.main

import android.arch.lifecycle.ViewModel
import android.util.Log
import android.widget.Toast
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.dao.PeliculaDao
import com.example.cristiandev.pelicula.data.dao.SerieDao
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie
import com.example.cristiandev.pelicula.net.PeliculaClient
import com.example.cristiandev.pelicula.net.ResponseDataPelicula
import com.example.cristiandev.pelicula.net.SerieClient
import com.example.cristiandev.utils.applySchedulers
import com.example.cristiandev.utils.isOnlineNet
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by CristianDev on 22/11/2017.
 */
class SerieViewModel @Inject constructor(val serieClient:SerieClient,
                                         val serieDao: SerieDao) : ViewModel() {

    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNWU5YmYyNzY1NWY2ZDk1MTk2YmJhMjRmMjMxYmQzYSIsInN1YiI6IjVhMDNhNGIwOTI1MTQxMmRlMjAwMTJhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mBP-5HfSzY-FNTia2jBtJ06w-vupDaB3IsYF1wrWTeQ"
    val app_key:String = "f5e9bf27655f6d95196bba24f231bd3a"
    fun getSeries(option:Int):Observable<List<Serie>> {
        if (isOnlineNet()) {
            return when (option) {
                R.string.serie_popular -> serieClient.getPopularSeries(token, app_key, "es-ES")
                else -> serieClient.getTopRatedSeries(token, app_key, "es-ES")
            }
                    .map {
                        for (serie in it.results) {
                            serie.genero = option
                            serieDao.insert(serie)
                        }
                        it.results
                    }
                    .applySchedulers()
        } else {
            return serieDao.all(option).toObservable()
        }
    }
}