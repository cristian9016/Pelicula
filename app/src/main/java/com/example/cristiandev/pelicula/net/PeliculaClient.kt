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

    @GET("/3/movie/popular")
    fun getPopularPeliculas(@Header("Authorization") token:String, @Query("api_key") key:String,@Query("language")language:String): Observable<ResponseDataPelicula>

    @GET("/3/movie/top_rated")
    fun getTopRatedPeliculas(@Header("Authorization") token:String, @Query("api_key") key:String,@Query("language")language:String): Observable<ResponseDataPelicula>

    @GET("/3/movie/upcoming")
    fun getUpcomingPeliculas(@Header("Authorization") token:String, @Query("api_key") key:String,@Query("language")language:String): Observable<ResponseDataPelicula>

}