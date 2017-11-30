package com.example.cristiandev.pelicula.data.dao

import android.arch.persistence.room.*
import com.example.cristiandev.pelicula.data.model.Serie
import io.reactivex.Flowable

/**
 * Created by CristianDev on 30/11/2017.
 */
@Dao
interface SerieDao{
    @Insert
    fun insert(serie: Serie)

    @Update
    fun update(serie: Serie)

    @Delete
    fun delete(serie: Serie)

    @Query("SELECT * FROM serie")
    fun all(): Flowable<List<Serie>>

    @Query("DELETE FROM serie")
    fun deleteAll()
}