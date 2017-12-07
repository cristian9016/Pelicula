package com.example.cristiandev.pelicula.ui.fragments.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Pelicula
import com.example.cristiandev.pelicula.databinding.FragmentDetailMovieBinding

class DetailFragmentMovie : Fragment() {

    lateinit var pelicula: Pelicula
    lateinit var binding : FragmentDetailMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_movie,container,false)
        return binding.root
    }
    override fun onResume() {
        super.onResume()

        pelicula = arguments.getParcelable("pelicula")
        binding.pelicula = pelicula
    }

    companion object {
        fun instance(pelicula:Pelicula): DetailFragmentMovie {
            val fragment = DetailFragmentMovie()
            val args = Bundle()
            args.putParcelable("pelicula",pelicula)
            fragment.arguments = args
            return fragment
        }
    }
}
