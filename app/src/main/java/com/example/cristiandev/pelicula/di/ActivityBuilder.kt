package com.example.cristiandev.pelicula.di

import com.example.cristiandev.pelicula.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by CristianDev on 22/11/2017.
 */
@Module
abstract class ActivityBuilder{
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity():MainActivity
}