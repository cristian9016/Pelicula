package com.example.cristiandev.pelicula.net

/**
 * Created by CristianDev on 22/11/2017.
 */
class ResponseData<T> (val success:Boolean, val results:T, val err:String)