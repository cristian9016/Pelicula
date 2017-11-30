package com.example.cristiandev.pelicula.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.di.Injectable
import com.example.cristiandev.pelicula.ui.Navigation
import com.example.cristiandev.pelicula.ui.adapters.PeliculaAdapter
import com.example.cristiandev.pelicula.ui.adapters.SerieAdapter
import com.example.cristiandev.utils.LifeDisposable
import com.example.cristiandev.utils.applySchedulers
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by CristianDev on 26/11/2017.
 */
class MainFragment : Fragment(),Injectable {

    @Inject
    lateinit var adapterPelicula:PeliculaAdapter
    @Inject
    lateinit var adapterSerie:SerieAdapter

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

        val option:String = arguments.getString("option")
        when(option){
            "movie_popular" -> dis add viewModel.getPopularPeliculas()
                    .applySchedulers()
                    .subscribeBy (onNext = {
                        adapterPelicula.peliculas = it
                        recycler.adapter = adapterPelicula
                    }, onError = {it.printStackTrace()})
            "movie_top_rated" -> dis add viewModel.getTopRatedPeliculas()
                    .applySchedulers()
                    .subscribeBy (onNext = {
                        adapterPelicula.peliculas = it
                        recycler.adapter = adapterPelicula
                    }, onError = {it.printStackTrace()})
            "movie_upcoming" -> dis add viewModel.getUpcomingPeliculas()
                    .applySchedulers()
                    .subscribeBy (onNext = {
                        adapterPelicula.peliculas = it
                        recycler.adapter = adapterPelicula
                    }, onError = {it.printStackTrace()})
            "series_popular" -> dis add viewModel.getPopularSeries()
                    .applySchedulers()
                    .subscribeBy (onNext = {
                        adapterSerie.series= it
                        recycler.adapter = adapterSerie
                    }, onError = {it.printStackTrace()})
            "series_top_rated" -> dis add viewModel.getTopRatedSeries()
                    .applySchedulers()
                    .subscribeBy (onNext = {
                        adapterSerie.series = it
                        recycler.adapter = adapterSerie
                    }, onError = {it.printStackTrace()})
        }

        recycler.layoutManager = LinearLayoutManager(activity)

        dis add adapterPelicula.clickPelicula
                .applySchedulers()
                .subscribeBy (
                    onNext = {
                        nav.navigateToDetailPelicula(it)
                    }
                )
        dis add adapterSerie.clickSerie
                .applySchedulers()
                .subscribeBy (
                        onNext = {
                            nav.navigateToDetailSerie(it)
                        }
                )

    }

    companion object {
        fun instance(option:String):MainFragment{
            val fragment = MainFragment()
            val args = Bundle()
            args.putString("option",option)
            fragment.arguments = args
            return fragment
        }
    }
}