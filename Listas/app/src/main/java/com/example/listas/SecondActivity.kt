package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapter.AdapterModelos
import com.example.listas.data.DataSet
import com.example.listas.databases.DBHelper
import com.example.listas.databases.SchemaDB
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Coche
import com.example.listas.model.Usuario


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    //Parte de datos de mi segunda lista
    private lateinit var adaptadorLista: ArrayAdapter<Coche>
    private lateinit var adapterModelos: AdapterModelos
    private lateinit var openHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openHelper = DBHelper(applicationContext, SchemaDB.DB_NOMBRE, 1 )


        //inicializamos el adaptador de la lista
        //nos pedira 3 parametros, ctx, layaout, lista
       // adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getAllModelos());
        //binding.listviewModelos.adapter = adaptadorLista;


        //si cambio openHelper.getCoches() por ataSet.getAllModelos() me muestra los coches que hemos añadido en la base de datos
        adapterModelos = AdapterModelos(openHelper.getCoches(), applicationContext)
        binding.recyclerModelos.adapter = adapterModelos
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,
            false)

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
               // adaptadorLista.clear()
                //adaptadorLista.addAll(listaFiltrada)



                //saca un mensaje abajo con la seleccion de la lista
             /*   Snackbar.make(binding.root,binding.spinnerMarca.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                    .show()*/
               // parent?.adapter?.getItem(position).toString()-->este es es mas habitual
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.botonFiltrar.setOnClickListener {
            //onclick
            //binding.spinnerMarca.selectedItem
           /* Snackbar.make(binding.root, binding.spinnerMarca.selectedItem.toString(), Snackbar.LENGTH_SHORT.)
                .show()*/

            val coche = Coche("Ateca", "Seat", 25000, 220,"")
            openHelper.agregarCoche(coche)
            adapterModelos.addCoche(coche)

            //agregar coches de la base de datos al adaptador
        }

        //un escuchador para la lista
       /* binding.listviewModelos.setOnItemClickListener { parent, view, position, id ->

            //Snackbar.make(binding.root,"${resources.getString(R.string.mensaje)}"+""+listaCoches[position].precio.toString(), Snackbar.LENGTH_SHORT).show()

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("coche",DataSet.getAllModelos()[position])
            startActivity(intent)
        }*/


    }

    override fun onStart() {
        super.onStart()
        //binding.recycerModelos-->parte grafica, donde voy a poner los datos
        // datos - se representan mediante un array adaptor- RecyclerView.adapter -->pinta cada elemento del arrayList(dinamico)
        // en cada fila de la lista
    }
}
//nos creamos el array/lista que le pasamos al adapatador

//inicializamos el adaptador de la lista
//nos pedira 3 parametros, ctx, layaout, lista
//adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getAllModelos());
//binding.listviewModelos.adapter = adaptadorLista;