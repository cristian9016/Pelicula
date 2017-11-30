package com.example.cristiandev.pelicula.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by CristianDev on 22/11/2017.
 */
@Entity
@Parcelize
class Pelicula (@PrimaryKey var id_pelicula:Long?,
                var id:Long,
                var title:String,
                var overview:String,
                var poster_path:String,
                var release_date:String,
                var vote_average:Float):Parcelable{
    @Ignore
    constructor(id: Long,title: String,overview: String,poster_path: String,release_date: String,vote_average: Float):
            this(null,id,title,overview,poster_path,release_date,vote_average)
}