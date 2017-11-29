package com.example.cristiandev.pelicula.ui.fragments

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.net.PeliculaClient
import com.example.cristiandev.pelicula.net.ResponseData
import com.example.cristiandev.utils.applySchedulers
import com.example.cristiandev.utils.validateResponse
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableRange
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by CristianDev on 22/11/2017.
 */
class MainViewModel @Inject constructor(val peliculaClient: PeliculaClient) : ViewModel() {

    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNWU5YmYyNzY1NWY2ZDk1MTk2YmJhMjRmMjMxYmQzYSIsInN1YiI6IjVhMDNhNGIwOTI1MTQxMmRlMjAwMTJhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mBP-5HfSzY-FNTia2jBtJ06w-vupDaB3IsYF1wrWTeQ"

    fun getAllPeliculas(): Observable<List<Pelicula>> = peliculaClient.getAllPeliculas(token, "f5e9bf27655f6d95196bba24f231bd3a")
            .map { it.results }
            .applySchedulers()
}