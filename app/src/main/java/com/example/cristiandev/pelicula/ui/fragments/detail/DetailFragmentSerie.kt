package com.example.cristiandev.pelicula.ui.fragments.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.data.model.Serie
import com.example.cristiandev.pelicula.databinding.FragmentDetailSerieBinding

class DetailFragmentSerie : Fragment() {

    lateinit var serie: Serie
    lateinit var binding : FragmentDetailSerieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_serie,container,false)
        return binding.root
    }
    override fun onResume() {
        super.onResume()

        serie = arguments.getParcelable("serie")
        binding.serie = serie
    }

    companion object {
        fun instance(serie:Serie): DetailFragmentSerie {
            val fragment = DetailFragmentSerie()
            val args = Bundle()
            args.putParcelable("serie",serie)
            fragment.arguments = args
            return fragment
        }
    }
}
