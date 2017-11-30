package com.example.cristiandev.pelicula.net

import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie

/**
 * Created by CristianDev on 22/11/2017.
 */
data class ResponseDataPelicula (val results:List<Pelicula>)
data class ResponseDataSerie (val results:List<Serie>)

