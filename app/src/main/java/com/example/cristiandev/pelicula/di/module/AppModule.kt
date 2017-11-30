package com.example.cristiandev.pelicula.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.example.cristiandev.pelicula.data.AppDatabase
import com.example.cristiandev.pelicula.data.dao.PeliculaDao
import com.example.cristiandev.pelicula.data.dao.SerieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by CristianDev on 22/11/2017.
 */

@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun providesPreferences(application: Application): SharedPreferences =
            application.getSharedPreferences("pelicula", 0)

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
                    .fallbackToDestructiveMigration()
                    .build()

    @Singleton
    @Provides
    fun providesPeliculaDao(appDatabase: AppDatabase): PeliculaDao =
            appDatabase.peliculaDao()

    @Singleton
    @Provides
    fun providesSerieDao(appDatabase: AppDatabase): SerieDao =
            appDatabase.serieDao()
}

