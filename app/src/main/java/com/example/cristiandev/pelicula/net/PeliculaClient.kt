package com.example.cristiandev.pelicula.net

import com.example.cristiandev.pelicula.data.model.Pelicula
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by CristianDev on 22/11/2017.
 */
interface PeliculaClient{
    @GET("finca/get-fincas/")
    fun getAllFincas(@Header("Authorization") token:String): Observable<ResponseData<List<Pelicula>>>
}