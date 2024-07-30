package com.conexcacao2.jogodavelhaalexandre1203

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class VoltarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Função responsável pelo funcionamento do botão de retorno.
        val buttonVoltar: Button = findViewById(R.id.buttonVoltar)
        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TeladeinicioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}