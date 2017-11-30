package com.example.cristiandev.pelicula.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by CristianDev on 30/11/2017.
 */
@Parcelize
class Serie (var id:Long?,
                var name:String,
                var overview:String,
                var poster_path:String,
                var first_air_date:String,
                var vote_average:Float): Parcelable