package com.example.cristiandev.pelicula.net

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by CristianDev on 30/11/2017.
 */
interface SerieClient {
    @GET("/3/tv/popular")
    fun getPopularSeries(@Header("Authorization") token:String, @Query("api_key") key:String,@Query("language")language:String): Observable<ResponseDataSerie>

    @GET("/3/tv/top_rated")
    fun getTopRatedSeries(@Header("Authorization") token:String, @Query("api_key") key:String,@Query("language")language:String): Observable<ResponseDataSerie>

}