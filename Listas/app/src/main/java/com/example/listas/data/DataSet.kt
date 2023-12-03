package com.example.listas.data

import com.example.listas.model.Coche

class DataSet {

    /*
    Esto va a ser para mi esta lista simulando una base de datos
        listaCoches.add(Coche("Mondeo", 10000, 90, "https://img.remediosdigitales.com/054749/ford-mondeo-2022-04/1366_2000.jpeg"))
        listaCoches.add(Coche("Focus", 20000, 175, "https://www.diariomotor.com/imagenes/2012/10/ford-focus-2022-1-617d30441e129.jpeg"))
        listaCoches.add(Coche("Megane", 15000, 210, "https://d1eip2zddc2vdv.cloudfront.net/dphotos/750x400/9876161-1588701930.jpeg"))
        listaCoches.add(Coche("A200", 28000, 200, "https://grupoconcesur.es/wp-content/uploads/2021/05/mercedes-a-200d-delantera.jpg"))
        listaCoches.add(Coche("Leon", 19000, 150, "https://noticias.coches.com/wp-content/uploads/2017/12/seat_leon-cupra-r-2017_r2.jpg"))
        listaCoches.add(Coche("Fiesta", 15000, 75, "https://www.gpas-cache.ford.com/guid/bda1766d-03a1-38d8-b4da-7a7717ca4397.png"))
     */

    //metodo que pertenezca a la clase no al objeto, de que tipo seria static-->pero en kotlin no existen
    //son companion object seria estatico lo de dentro de las llaves

    companion object{
    fun getAllModelos(): ArrayList<Coche>{
        val listaCoches = ArrayList<Coche>()
        listaCoches.add(Coche("Mondeo","Ford", 10000, 90, "https://img.remediosdigitales.com/054749/ford-mondeo-2022-04/1366_2000.jpeg"))
        listaCoches.add(Coche("Focus","Ford", 20000, 175, "https://www.diariomotor.com/imagenes/2012/10/ford-focus-2022-1-617d30441e129.jpeg"))
        listaCoches.add(Coche("Megane","Renault", 15000, 210, "https://d1eip2zddc2vdv.cloudfront.net/dphotos/750x400/9876161-1588701930.jpeg"))
        listaCoches.add(Coche("A200","Mercedes", 28000, 200, "https://grupoconcesur.es/wp-content/uploads/2021/05/mercedes-a-200d-delantera.jpg"))
        listaCoches.add(Coche("Leon","Seat", 19000, 150, "https://noticias.coches.com/wp-content/uploads/2017/12/seat_leon-cupra-r-2017_r2.jpg"))
        listaCoches.add(Coche("Fiesta","Ford", 15000, 75, "https://www.gpas-cache.ford.com/guid/bda1766d-03a1-38d8-b4da-7a7717ca4397.png"))
        listaCoches.add(Coche("Ibiza","Seat", 15000, 75, "https://www.gpas-cache.ford.com/guid/bda1766d-03a1-38d8-b4da-7a7717ca4397.png"))
        listaCoches.add(Coche("SLK","Mercedes", 15000, 75, "https://www.gpas-cache.ford.com/guid/bda1766d-03a1-38d8-b4da-7a7717ca4397.png"))


        return listaCoches
    }
    }


}