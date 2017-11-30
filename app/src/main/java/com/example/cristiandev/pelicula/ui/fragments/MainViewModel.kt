package com.example.cristiandev.pelicula.ui.fragments

import android.arch.lifecycle.ViewModel
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie
import com.example.cristiandev.pelicula.net.PeliculaClient
import com.example.cristiandev.pelicula.net.SerieClient
import com.example.cristiandev.utils.applySchedulers
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by CristianDev on 22/11/2017.
 */
class MainViewModel @Inject constructor(val peliculaClient: PeliculaClient,val serieClient:SerieClient) : ViewModel() {

    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNWU5YmYyNzY1NWY2ZDk1MTk2YmJhMjRmMjMxYmQzYSIsInN1YiI6IjVhMDNhNGIwOTI1MTQxMmRlMjAwMTJhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mBP-5HfSzY-FNTia2jBtJ06w-vupDaB3IsYF1wrWTeQ"

    fun getPopularPeliculas(): Observable<List<Pelicula>> = peliculaClient.getPopularPeliculas(token, "f5e9bf27655f6d95196bba24f231bd3a","es-ES")
            .map { it.results }
            .applySchedulers()

    fun getTopRatedPeliculas(): Observable<List<Pelicula>> = peliculaClient.getTopRatedPeliculas(token, "f5e9bf27655f6d95196bba24f231bd3a","es-ES")
            .map { it.results }
            .applySchedulers()

    fun getUpcomingPeliculas(): Observable<List<Pelicula>> = peliculaClient.getUpcomingPeliculas(token, "f5e9bf27655f6d95196bba24f231bd3a","es-ES")
            .map { it.results }
            .applySchedulers()

    fun getPopularSeries(): Observable<List<Serie>> = serieClient.getPopularSeries(token, "f5e9bf27655f6d95196bba24f231bd3a","es-ES")
            .map { it.results }
            .applySchedulers()

    fun getTopRatedSeries(): Observable<List<Serie>> = serieClient.getTopRatedSeries(token, "f5e9bf27655f6d95196bba24f231bd3a","es-ES")
            .map { it.results }
            .applySchedulers()
}