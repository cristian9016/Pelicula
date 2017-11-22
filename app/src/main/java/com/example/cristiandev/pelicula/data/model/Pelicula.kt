package com.example.cristiandev.pelicula.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by CristianDev on 22/11/2017.
 */

class Pelicula (     var id:Int?,
                     var title:String,
                     var description:String,
                     var image:String,
                     var releaseDate:String,
                     var voteAverage:String)
{
    @Ignore
    constructor(title:String,description:String,image:String,releaseDate: String,voteAverage: String):this(
            null,title,description,image,releaseDate,voteAverage
    )
}