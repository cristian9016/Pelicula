package com.example.cristiandev.pelicula.di.component

import android.app.Application
import com.example.cristiandev.pelicula.App
import com.example.cristiandev.pelicula.di.ActivityBuilder
import com.example.cristiandev.pelicula.di.module.AppModule
import com.example.cristiandev.pelicula.di.module.NetModule
import com.example.cristiandev.pelicula.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by CristianDev on 22/11/2017.
 */
@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
        ActivityBuilder::class,
        AppModule::class,
        NetModule::class,
        ViewModelModule::class
))
        interface AppComponent{
    fun inject(app:App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun applicacion(application: Application):Builder
        fun build():AppComponent
    }

}