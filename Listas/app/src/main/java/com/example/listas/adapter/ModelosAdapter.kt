package com.example.listas.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ModelosAdapter : RecyclerView.Adapter<ModelosAdapter.Myholder>() {

    class Myholder(var view: View): ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        //asociar la parte grafica (XML hecho por nosotros del aspecto de la fila)
        //con el patron, este metodo solo se hace una vez
        return TODO("Provide the return value")
    }

    override fun getItemCount(): Int {
        //Indica cuantos items/elementos tiene la lista (getItemCount)
        return TODO("Provide the return value")
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
    //este metodo asocia al patron(xml) los datos de la lista en una posicion(Myholder)
    }
}