package com.example.cristiandev.pelicula.net

import com.example.cristiandev.pelicula.data.model.Pelicula
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by CristianDev on 22/11/2017.
 */
interface PeliculaClient{
    @GET("/4/list/1")
    fun getAllPeliculas(@Header("Authorization") token:String, @Query("api_key") key:String): Observable<ResponseData>

}