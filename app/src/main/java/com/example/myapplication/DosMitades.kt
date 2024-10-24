package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class DosMitades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_mitades)

        val userName = intent.getStringExtra("USER_NAME")
        val welcomeTextView = findViewById<TextView>(R.id.textoPlano)
        val inputCadena = findViewById<EditText>(R.id.inputCadena)
        val buttonProcesar = findViewById<Button>(R.id.buttonIngresar)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

            welcomeTextView.text = "Hola $userName!\n" +
                "Te voy a ayudar a solucionar el problema de las dos mitades.\n" +
                "1. Ingresa una cadena de caracteres.\n" +
                "2. Te ayudaré a cortar la cadena en dos partes iguales " +
                "(si la longitud de la cadena es impar, colocaré el carácter central en la primera cadena), " +
                "de modo que la primera cadena contenga un carácter más que la segunda.\n" +
                "3. Luego imprimiré la nueva cadena en una sola fila con la primera y segunda mitad intercambiadas."

        buttonProcesar.setOnClickListener {
            val cadena = inputCadena.text.toString()
            val resultado = procesarCadena(cadena)
            resultadoTextView.text = "$resultado"
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
        val longitud = cadena.length
        val mitad = longitud / 2
        val primeraMitad = cadena.substring(0, mitad + (longitud % 2))
        val segundaMitad = cadena.substring(mitad + (longitud % 2))
        return segundaMitad + primeraMitad
    }
}
