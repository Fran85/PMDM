package com.example.feedback2franb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val paises = listOf(
        "Usa",
        "Suiza",
        "Republica Dominicana",
        "Mexico",
        "Irlanda",
        "Inglaterra",
        "España",
        "Egipto",
        "Corea del sur",
        "Chile"
    )

    private val mapaDeImagenes = mapOf(
        "Usa" to R.drawable.usa,
        "Suiza" to R.drawable.suiza,
        "Republica Dominicana" to R.drawable.republica_dominicana,
        "Mexico" to R.drawable.mexico,
        "Irlanda" to R.drawable.irlanda,
        "Inglaterra" to R.drawable.inglaterra,
        "España" to R.drawable.espana,
        "Egipto" to R.drawable.egipto,
        "Corea del sur" to R.drawable.corea_del_sur,
        "Chile" to R.drawable.chile
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.lista_paises)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        listView.adapter = adapter

        val seleccionPaisTextView = findViewById<TextView>(R.id.seleccion_pais)

        listView.setOnItemLongClickListener { parent, view, position, id ->
            val paisSeleccionado = paises[position]
            seleccionPaisTextView.text = "Pais seleccionado: $paisSeleccionado"
            true // Indica que se ha manejado el evento de pulsación larga
        }

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val paisSeleccionado = paises[position]
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("nombre_pais", paisSeleccionado)
            intent.putExtra("pais_imagen", mapaDeImagenes[paisSeleccionado])
            startActivity(intent)
        }


    }
}