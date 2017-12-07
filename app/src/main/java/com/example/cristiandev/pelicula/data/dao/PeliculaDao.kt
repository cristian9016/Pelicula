package com.example.cristiandev.pelicula.data.dao

import android.arch.persistence.room.*
import com.example.cristiandev.pelicula.data.model.Pelicula
import io.reactivex.Flowable

/**
 * Created by CristianDev on 30/11/2017.
 */
@Dao
interface PeliculaDao{
    @Insert
    fun insert(pelicula: Pelicula)

    @Update
    fun update(pelicula: Pelicula)

    @Delete
    fun delete(pelicula: Pelicula)

    @Query("SELECT * FROM pelicula WHERE genero = :genero")
    fun all(genero:Int): Flowable<List<Pelicula>>

    @Query("DELETE FROM pelicula")
    fun deleteAll()
}
