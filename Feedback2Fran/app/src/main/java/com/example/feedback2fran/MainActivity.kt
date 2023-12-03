package com.example.feedback2fran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.feedback2fran.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val banderaImagen = binding.imagenPais
        val radioButtons = listOf(
            binding.radioUsa,
            binding.radioSuiza,
            binding.radioSpain,
            binding.radioMexico,
            binding.radioKorea,
            binding.radioIrlanda,
            binding.radioEngland,
            binding.radioEgipto,
            binding.radioDominicana,
            binding.radioChile
        )

        radioButtons.forEach { radioButton ->
            radioButton.setOnClickListener {
                radioButtons.forEach { rb ->
                    rb.isChecked = false
                }
                radioButton.isChecked = true

                val nombrePais = (it as RadioButton).text.toString().toLowerCase().replace(" ", "_")

                val banderaId =
                    resources.getIdentifier("${nombrePais}", "drawable", packageName)


                if (banderaId != 0) {
                    banderaImagen.setImageResource(banderaId)
                } else {
                    banderaImagen.setImageResource(R.drawable.ic_launcher_foreground)
                }
            }

        }


    }
}