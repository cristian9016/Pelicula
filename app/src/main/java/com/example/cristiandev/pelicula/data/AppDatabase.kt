package com.example.cristiandev.pelicula.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.example.cristiandev.pelicula.data.dao.PeliculaDao
import com.example.cristiandev.pelicula.data.dao.SerieDao
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie
import java.util.*


/**
 * Created by CristianDev on 30/11/2017.
 */
object DateConverter{

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    @JvmStatic
    fun longToDate(timestap:Long) = Date(timestap)

}

@Database(entities = arrayOf(Pelicula::class, Serie::class),version = 3)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase(){

    abstract fun peliculaDao():PeliculaDao
    abstract fun serieDao():SerieDao

}