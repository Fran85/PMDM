package com.example.listas.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listas.DetailActivity
import com.example.listas.R
import com.example.listas.data.DataSet
import com.example.listas.model.Coche

class AdapterModelos(var lista: ArrayList<Coche>, var contexto: Context) : RecyclerView.Adapter<AdapterModelos.ModeloHolder>() {

    //representa el contenido del layaout(patron) que hemos creado
    class ModeloHolder(vista : View): RecyclerView.ViewHolder(vista){
        //tenemos que extraer cada elemento del patron, la imagen y el texto
        var imagenImageView: ImageView
        var textoTextView: TextView

        //inicializar en el bloque que se ejecuta siempre, el init

        init {
            imagenImageView = vista.findViewById(R.id.imagen_fila)
            textoTextView = vista.findViewById(R.id.nombre_fila)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeloHolder {
        //como se crea el patron, pide un modeloholder, nos creamos una variable para convertir
        //el xml a vista, lo pasamos a inflater y se le pide el contexto en la clase, creamos contexto
        //en la definicion de la clase-->siempre no atachar(false), que no se pueda modificar, en falso si podriamos modificarlo
        val vista : View = LayoutInflater.from(contexto).inflate(R.layout.item_modelo, parent, false)
        return ModeloHolder(vista)
    }

    override fun getItemCount(): Int {
        //trae el numero de elementos que tendra que adaptar, que pintar, mostrar
        return lista.size
    }

    fun addCoche(coche: Coche): Unit{
        lista.add(coche)
        notifyItemInserted(lista.size-1)
    }

    override fun onBindViewHolder(holder: ModeloHolder, position: Int) {
        //obtiene como parametro un objeto de tipo holder, representa cada elemento de la lista en su posicion
        //(utilizando el patron)
        val item = lista[position]
        holder.textoTextView.text = item.nombre
        Glide.with(contexto).load(item.imagen).into(holder.imagenImageView)
        holder.imagenImageView.setOnClickListener {
            val intent = Intent(contexto, DetailActivity::class.java)
            intent.putExtra("coche", DataSet.getAllModelos()[position])
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }

    }


}