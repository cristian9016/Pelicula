package com.example.cristiandev.pelicula.utils

import com.example.cristiandev.pelicula.data.model.Pelicula

object Data {

    var peliculas: MutableList<Pelicula> = mutableListOf(
            Pelicula(1, "Wonder Woman", "Diana, una princesa guerrera perteneciente al pueblo de las amazonas, fue criada en una isla protegida y entrenada para ser una luchadora invencible. Después de que un piloto estadounidense, Steve Trevor, se estrellase en dicha isla, es salvado por la princesa, a quien le relata sobre el desarrollo de una guerra mundial que está sucediendo. Entonces, Diana sale de su hogar para tratar de detener la guerra.",
                    "http://static.dnaindia.com/sites/default/files/2017/03/11/555566-wonder-woman-poster.jpg","12/11/2017",
                    2.3f
            ),
            Pelicula(2, "Thor: Ragnarok", "Thor: Ragnarok es una película de superhéroes estadounidense basada en el personaje de Marvel Comics Thor, producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMyNDkzMzI1OF5BMl5BanBnXkFtZTgwODcxODg5MjI@._V1_UY1200_CR90,0,630,1200_AL_.jpg","12/11/2017",
            4.4f)
    )

}
