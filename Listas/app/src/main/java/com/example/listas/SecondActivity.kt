package com.example.listas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.listas.data.DataSet
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Coche
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    //Parte de datos de mi segunda lista
    private lateinit var adaptadorLista: ArrayAdapter<Coche>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //nos creamos el array/lista que le pasamos al adapatador

        //inicializamos el adaptador de la lista
        //nos pedira 3 parametros, ctx, layaout, lista
        adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getAllModelos());
        binding.listviewModelos.adapter = adaptadorLista;

        binding.nombreUsuario.text = (intent.extras?.getSerializable("usuario")
                as Usuario).nombre

        binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //sacar lo que esta dentro del spinner
                val marcaSeleccionada = parent!!.adapter.getItem(position).toString()
                val listaFiltrada = DataSet.getAllModelos().filter { it.marca.equals(marcaSeleccionada, true)} as ArrayList<Coche>
                adaptadorLista.clear()
                adaptadorLista.addAll(listaFiltrada)



                //saca un mensaje abajo con la seleccion de la lista
                Snackbar.make(binding.root,binding.spinnerMarca.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                    .show()
               // parent?.adapter?.getItem(position).toString()-->este es es mas habitual
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.botonFiltrar.setOnClickListener {
            //onclick
            binding.spinnerMarca.selectedItem
        }
        
        //un escuchador para la lista
        binding.listviewModelos.setOnItemClickListener { parent, view, position, id ->

            //Snackbar.make(binding.root,"${resources.getString(R.string.mensaje)}"+""+listaCoches[position].precio.toString(), Snackbar.LENGTH_SHORT).show()

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("coche",DataSet.getAllModelos()[position])
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        //binding.recycerModelos-->parte grafica, donde voy a poner los datos
        // datos - se representan mediante un array adaptor- RecyclerView.adapter -->pinta cada elemento del arrayList(dinamico)
        // en cada fila de la lista
    }
}