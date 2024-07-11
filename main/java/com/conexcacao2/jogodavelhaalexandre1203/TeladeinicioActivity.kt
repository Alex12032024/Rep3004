package com.conexcacao2.jogodavelhaalexandre1203

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class TeladeinicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teladeinicio)

        //Função responsável pelo funcionamento da tela de início.
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        // Dependendo do botão clicado pelo usuário, ele é redirecionado para o modo singleplayer ou multiplayer pelo Intent.
        button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        button2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}