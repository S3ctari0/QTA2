package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.buttonPanel)

        boton.setOnClickListener {
            val intent = Intent(this, InicioSesion::class.java)
            startActivity(intent)
            finish()
        }
    }
}