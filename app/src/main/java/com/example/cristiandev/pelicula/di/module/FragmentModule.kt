package com.example.cristiandev.pelicula.di.module

import com.example.cristiandev.pelicula.di.FragmentScope
import com.example.cristiandev.pelicula.ui.fragments.detail.DetailFragmentMovie
import com.example.cristiandev.pelicula.ui.fragments.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by CristianDev on 26/11/2017.
 */
@Module
abstract class FragmentModule{

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMainFragment() : MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailFragment() : DetailFragmentMovie
}