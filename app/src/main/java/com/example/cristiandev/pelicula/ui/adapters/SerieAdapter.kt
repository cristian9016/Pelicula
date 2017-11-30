package com.example.cristiandev.pelicula.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.data.model.Serie
import com.example.cristiandev.pelicula.databinding.TemplatePeliculaBinding
import com.example.cristiandev.pelicula.databinding.TemplateSerieBinding
import com.example.cristiandev.pelicula.di.ActivityScope
import com.example.cristiandev.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


@ActivityScope
class SerieAdapter @Inject constructor(): RecyclerView.Adapter<SerieAdapter.SerieHolder>() {

    val clickSerie = PublishSubject.create<Serie>()

    var series: List<Serie> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieHolder
            = SerieHolder(parent.inflate(R.layout.template_serie))

    override fun onBindViewHolder(holder: SerieHolder, position: Int) {
        holder.binding.serie = series[position]
        holder.binding.clickSerie = clickSerie

    }

    override fun getItemCount(): Int = series.size

    class SerieHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplateSerieBinding = DataBindingUtil.bind(itemView)

    }


}