package com.example.cristiandev.pelicula.utils

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by CristianDev on 26/11/2017.
 */
@BindingAdapter("app:imgUrl")
fun setImageUrl(img: ImageView, url:String){
    Picasso.with(img.context)
            .load(Uri.parse(url))
            .into(img)
}