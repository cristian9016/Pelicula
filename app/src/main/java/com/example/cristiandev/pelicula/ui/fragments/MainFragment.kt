package com.example.cristiandev.pelicula.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.di.Injectable
import com.example.cristiandev.pelicula.ui.Navigation
import com.example.cristiandev.pelicula.ui.adapters.PeliculaAdapter
import com.example.cristiandev.pelicula.utils.Data
import com.example.cristiandev.utils.LifeDisposable
import com.example.cristiandev.utils.applySchedulers
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by CristianDev on 26/11/2017.
 */
class MainFragment : Fragment(),Injectable {

    @Inject
    lateinit var adapter:PeliculaAdapter
    val dis : LifeDisposable = LifeDisposable(this)
    @Inject
    lateinit var nav:Navigation
    @Inject
    lateinit var viewModel : MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onResume() {
        super.onResume()

        dis add viewModel.getAllPeliculas()
                .applySchedulers()
                .subscribeBy (onNext = {
                    adapter.peliculas = it
                }, onError = {it.printStackTrace()})



        //adapter.peliculas = Data.peliculas
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)

        dis add adapter.clickPelicula
                .applySchedulers()
                .subscribeBy (
                    onNext = {
                        goToDetailActivity(it)
                    }
                )

    }

    fun goToDetailActivity(pelicula:Pelicula){
        nav.navigateToDetail(pelicula)
    }

    companion object {
        fun instance():MainFragment = MainFragment()
    }
}