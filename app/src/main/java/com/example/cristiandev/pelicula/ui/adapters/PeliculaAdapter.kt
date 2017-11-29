package com.example.cristiandev.pelicula.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.databinding.TemplatePeliculaBinding
import com.example.cristiandev.pelicula.di.ActivityScope
import com.example.cristiandev.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


@ActivityScope
class PeliculaAdapter @Inject constructor(): RecyclerView.Adapter<PeliculaAdapter.PeliculaHolder>() {

    val clickPelicula = PublishSubject.create<Pelicula>()

    var peliculas: List<Pelicula> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder
            = PeliculaHolder(parent.inflate(R.layout.template_pelicula))

    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        holder.binding.pelicula = peliculas[position]
        holder.binding.clickPelicula = clickPelicula

    }

    override fun getItemCount(): Int = peliculas.size

    class PeliculaHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplatePeliculaBinding = DataBindingUtil.bind(itemView)

    }


}