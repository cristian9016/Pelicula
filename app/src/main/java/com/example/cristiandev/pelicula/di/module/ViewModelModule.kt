package com.example.cristiandev.pelicula.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.cristiandev.pelicula.ui.fragments.main.PeliculaViewModel
import com.example.cristiandev.pelicula.ui.fragments.main.SerieViewModel
import com.example.cristiandev.pelicula.utils.AppViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

/**
 * Created by CristianDev on 22/11/2017.
 */

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PeliculaViewModel::class)
    abstract fun bindPeliculaViewModel(viewModel: PeliculaViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SerieViewModel::class)
    abstract fun bindSerieViewModel(viewModel: SerieViewModel): ViewModel
}