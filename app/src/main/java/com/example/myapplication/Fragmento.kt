package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Fragmento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_palabras)

        val welcomeTextViewP = findViewById<TextView>(R.id.textoPlanoP)
        val inputCadena = findViewById<EditText>(R.id.inputCadena)
        val buttonProcesar = findViewById<Button>(R.id.buttonIngresar)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        val userName = intent.getStringExtra("USER_NAME")
        welcomeTextViewP.text = "Hola $userName!\n" +
                "Te voy a ayudar a solucionar el problema de las 2 palabras.\n" +
                "1. Ingresa una cadena de caracteres que contenga solo 2 palabras separadas por un espacio.\n" +
                "2. Imprimiré una nueva cadena con las posiciones de la primera y la segunda palabra intercambiadas (La segunda palabra se imprime primero)."

        buttonProcesar.setOnClickListener {
            val cadena = inputCadena.text.toString()
            val resultado = procesarCadena(cadena)
            resultadoTextView.text = "Resultado: $resultado"
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_DosMitades -> {
                    val intent = Intent(this, DosMitades::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_DosPlabras -> {
                    val intent = Intent(this, DosPalabras::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_fragmento -> {
                    val intent = Intent(this, Fragmento::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun procesarCadena(cadena: String): String {
        val palabras = cadena.split(" ")
        return "${palabras[1]} ${palabras[0]}"
    }
}


