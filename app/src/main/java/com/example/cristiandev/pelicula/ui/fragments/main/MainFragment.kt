package com.example.cristiandev.pelicula.ui.fragments.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
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
    lateinit var peliculaViewModel : PeliculaViewModel
    @Inject
    lateinit var serieViewModel : SerieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onResume() {
        super.onResume()

        val option:Int = arguments.getInt("option")
        val type:Int = arguments.getInt("type")
        if(type==R.string.type_pelicula) {
            dis add peliculaViewModel.getPeliculas(option)
                    .applySchedulers()
                    .subscribeBy(onNext = {
                        adapterPelicula.peliculas = it
                        recycler.adapter = adapterPelicula
                    }
                    )
        }else{
            dis add serieViewModel.getSeries(option)
                    .applySchedulers()
                    .subscribeBy(onNext = {
                        adapterSerie.series = it
                        recycler.adapter = adapterSerie
                    }
                    )
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
        fun instance(option:Int,type:Int): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putInt("option",option)
            args.putInt("type",type)
            fragment.arguments = args
            return fragment
        }
    }
}