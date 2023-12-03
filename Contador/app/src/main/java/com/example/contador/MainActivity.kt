package com.example.contador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {



    private lateinit var binding: ActivityMainBinding

    private var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        contador = savedInstanceState?.getInt("contador") ?:0

//las variables se tienen que inicializar aunque sea en nullo, si no rompe la app
        //revisar tema de binding y viewBinding

        binding.textoContador.text = contador.toString();

        binding.botonIncremento.setOnClickListener (this)
        binding.botonDecremento.setOnClickListener (this)
        binding.botonPasar?.setOnClickListener (this)
        binding.botonPasar2?.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        //diferenciar quien ha pulsado, si incremento o decremento
        //la interrogacion al final de algo indica que puede ser nulo
        when(v?.id){
            binding.botonIncremento.id->{
                contador++
            }
            binding.botonDecremento.id->{
                contador--
            }
            binding.botonPasar?.id->{
       //constante--> val
                val intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                intent.putExtra("contador",contador)
                startActivity(intent)
            }
            binding.botonPasar2?.id->{
                //constante--> val
                val intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            }

        }
        binding.textoContador.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //lo guarda por un par clave - valor
        outState.putInt("contador",contador)
    }


    //se sobreescriben los metodos de arranque, parada, pausa...
    //son los principales, no se controlan pero se pueden sobrescribir
    override fun onStart() {
        super.onStart()
        Log.v("ciclo", "Ejecuanto onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo", "Ejecuanto onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo", "Ejecuanto onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo", "Ejecuanto onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo", "Ejecuanto onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo", "Ejecuanto onDestroy")
    }
}