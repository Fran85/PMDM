package com.example.feedback2franb

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class SecondActivity : AppCompatActivity() {

    private val poblacionMapa = mapOf(
        "Usa" to 335893000L,
        "Suiza" to 8865270L,
        "Republica Dominicana" to 10448499L,
        "Mexico" to 126014024L,
        "Irlanda" to 5149139L,
        "Inglaterra" to 67026300L,
        "España" to 48345223L,
        "Egipto" to 105838000L,
        "Corea del sur" to 51439038L,
        "Chile" to 19960889L
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nombrePais = intent.getStringExtra("nombre_pais")
        findViewById<TextView>(R.id.pais_nombre).text = "Nombre del pais: $nombrePais"

        val poblacion = nombrePais?.let { obtenerPoblacion(it) }
        val poblacionFormateada = poblacionFormateada(poblacion ?: 0L)
        findViewById<TextView>(R.id.poblacion_pais).text = "Poblacion: $poblacionFormateada"

        val imagenBandera = findViewById<ImageView>(R.id.pais_imagen)
        val paisBandera = intent.getIntExtra("pais_imagen", R.drawable.no_disponible)
        imagenBandera.setImageResource(paisBandera)

    }

        private fun obtenerPoblacion(nombrePais: String): Long{
            return poblacionMapa[nombrePais] ?: 0L

    }

    private fun poblacionFormateada(poblacionFormat: Long): String{
        val numeroFormateado = NumberFormat.getNumberInstance()
        return numeroFormateado.format(poblacionFormat)
    }
}