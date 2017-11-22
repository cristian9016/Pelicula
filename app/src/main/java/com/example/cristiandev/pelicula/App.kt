package com.example.cristiandev.pelicula

import android.app.Activity
import android.app.Application
import com.example.cristiandev.pelicula.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class App : Application(), HasActivityInjector{

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>
            = injector



    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}