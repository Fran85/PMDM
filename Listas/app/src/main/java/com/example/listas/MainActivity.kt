package com.example.listas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listas.databinding.ActivityMainBinding
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.botonLogin.setOnClickListener {

            //metodo onclick captura lo escrito y lo compara onclick --> pasa de pantalla si se cumple el if
            if (  binding.editUsuario.text.toString().equals("Admin",ignoreCase = true)
                && binding.editPass.text.toString().equals("admin")){

                //pasar de pantalla
                val intent = Intent(applicationContext, SecondActivity::class.java)
                //
                intent.putExtra("usuario",Usuario(binding.editUsuario.text.toString(), binding.editPass.text.toString()))
                startActivity(intent)
            }else{
                //aqui iria un notificacion de aviso snackbar o toast
                Snackbar.make(binding.root,"Error en los datos",Snackbar.LENGTH_SHORT).show()
            }


        }


    }
}