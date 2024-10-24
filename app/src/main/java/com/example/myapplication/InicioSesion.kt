package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        val boton = findViewById<Button>(R.id.buttonIngresar)
        val userInput = findViewById<EditText>(R.id.userInput)
        val userName = userInput.text.toString()

        boton.setOnClickListener {
            val userName = userInput.text.toString()
            val intent = Intent(this, DosMitades::class.java)
            intent.putExtra("USER_NAME", userName)
            startActivity(intent)
            finish()
        }
    }
}