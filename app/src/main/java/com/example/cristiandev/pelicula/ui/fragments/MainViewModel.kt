package com.example.cristiandev.pelicula.ui.fragments

import android.arch.lifecycle.ViewModel
import android.util.Log
import android.widget.Toast
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
class MainViewModel @Inject constructor(val peliculaClient: PeliculaClient,
                                        val serieClient:SerieClient,
                                        val peliculaDao: PeliculaDao,
                                        val serieDao: SerieDao) : ViewModel() {

    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNWU5YmYyNzY1NWY2ZDk1MTk2YmJhMjRmMjMxYmQzYSIsInN1YiI6IjVhMDNhNGIwOTI1MTQxMmRlMjAwMTJhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mBP-5HfSzY-FNTia2jBtJ06w-vupDaB3IsYF1wrWTeQ"
    val app_key:String = "f5e9bf27655f6d95196bba24f231bd3a"

    fun getPopularPeliculas(): Observable<List<Pelicula>>{
        if(isOnlineNet()){
            Log.i("ONLINE","ONLINE")
            return peliculaClient.getPopularPeliculas(token, app_key,"es-ES")
                    .map {
                        peliculaDao.deleteAll()
                        for(pelicula in it.results) peliculaDao.insert(pelicula)
                        it.results }
                    .applySchedulers()
        }else{
            Log.i("OFFLINE","OFFLINE")
            return peliculaDao.all().toObservable().applySchedulers()
        }
    }

    fun getTopRatedPeliculas(): Observable<List<Pelicula>> {
        if(isOnlineNet()){
            Log.i("ONLINE","ONLINE")
            return peliculaClient.getTopRatedPeliculas(token, app_key,"es-ES")
                    .map {
                        peliculaDao.deleteAll()
                        for(pelicula in it.results) peliculaDao.insert(pelicula)
                        it.results }
                    .applySchedulers()
        }else{
            Log.i("OFFLINE","OFFLINE")
            return peliculaDao.all().toObservable().applySchedulers()
        }
    }

    fun getUpcomingPeliculas(): Observable<List<Pelicula>> {
        if(isOnlineNet()){
            Log.i("ONLINE","ONLINE")
            return peliculaClient.getUpcomingPeliculas(token, app_key,"es-ES")
                    .map {
                        peliculaDao.deleteAll()
                        for(pelicula in it.results) peliculaDao.insert(pelicula)
                        it.results }
                    .applySchedulers()
        }else{
            Log.i("OFFLINE","OFFLINE")
            return peliculaDao.all().toObservable().applySchedulers()
        }
    }

    fun getPopularSeries(): Observable<List<Serie>> {
        if(isOnlineNet()){
            Log.i("ONLINE","ONLINE")
            return serieClient.getPopularSeries(token, app_key,"es-ES")
                    .map {
                        serieDao.deleteAll()
                        for(serie in it.results) serieDao.insert(serie)
                        it.results }
                    .applySchedulers()
        }else{
            Log.i("OFFLINE","OFFLINE")
            return serieDao.all().toObservable().applySchedulers()
        }
    }

    fun getTopRatedSeries(): Observable<List<Serie>>{
        if(isOnlineNet()){
            Log.i("ONLINE","ONLINE")
            return serieClient.getTopRatedSeries(token, app_key,"es-ES")
                    .map {
                        serieDao.deleteAll()
                        for(serie in it.results) serieDao.insert(serie)
                        it.results }
                    .applySchedulers()
        }else{
            Log.i("OFFLINE","OFFLINE")
            return serieDao.all().toObservable().applySchedulers()
        }
    }
}