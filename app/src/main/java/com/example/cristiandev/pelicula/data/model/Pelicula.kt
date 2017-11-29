package com.example.cristiandev.pelicula.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Ignore
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by CristianDev on 22/11/2017.
 */
@Parcelize
class Pelicula (var id:Long?,
                var title:String,
                var overview:String,
                var poster_path:String,
                var release_date:String,
                var vote_average:Float):Parcelable