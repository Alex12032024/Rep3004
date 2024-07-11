package com.conexcacao2.jogodavelhaalexandre1203

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.conexcacao2.jogodavelhaalexandre1203.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Variável de ligação para acesso às views
    private lateinit var binding: ActivityMainBinding

    // Vetor bidimensional que representará o tabuleiro de jogo
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    // Método onCreate que é chamado quando a Activity é criada
    // Entrada: savedInstanceState - o estado salvo da Activity
    // Saída: Nenhuma
    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout usando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Método para ativar bordas
        setContentView(binding.root) // Define o layout da Activity como a raiz do binding
    }

    // Função que será chamada quando um botão for clicado
    // Entrada: view - a view que foi clicada
    // Saída: Nenhuma
    fun buttonClick(view: View) {
        // Converte a view recebida para um botão
        val buttonSelecionado = view as Button
        // Define o texto do botão clicado como "X"
        buttonSelecionado.text = "X"
        // Desativa o botão para que não possa ser clicado novamente
        buttonSelecionado.isEnabled = false
        // Define uma imagem de fundo para o botão
        buttonSelecionado.setBackgroundResource(R.drawable.icon)


        // Atualiza o tabuleiro com "X" na posição correspondente ao botão clicado
        when (buttonSelecionado.id) {
            binding.buttonUm.id -> tabuleiro[0][0] = "X"
            binding.buttonDois.id -> tabuleiro[0][1] = "X"
            binding.buttonTres.id -> tabuleiro[0][2] = "X"
            binding.buttonQuatro.id -> tabuleiro[1][0] = "X"
            binding.buttonCinco.id -> tabuleiro[1][1] = "X"
            binding.buttonSeis.id -> tabuleiro[1][2] = "X"
            binding.buttonSete.id -> tabuleiro[2][0] = "X"
            binding.buttonOito.id -> tabuleiro[2][1] = "X"
            binding.buttonNove.id -> tabuleiro[2][2] = "X"
        }

        Handler(Looper.getMainLooper()).postDelayed({
            realizarMovimentoComputador()
        }, 1000) // Adiciona um delay de 1000 milissegundos (1 segundo)
    }

    private fun realizarMovimentoComputador() {
        // Gera posições aleatórias para o próximo movimento do computador
        var rX = Random.nextInt(0, 3)
        var rY = Random.nextInt(0, 3)

        // Tenta encontrar uma posição vazia no tabuleiro
        var i = 0
        while (i < 9) {
            rX = Random.nextInt(0, 3)
            rY = Random.nextInt(0, 3)
            if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                break // Sai do loop se encontrar uma posição vazia
            }
            i++
        }

        // Marca a posição encontrada com "O"
        tabuleiro[rX][rY] = "O"

        // Converte a posição bidimensional para uma posição linear
        val posicao = rX * 3 + rY

        // Atualiza o texto e estado do botão correspondente no layout
        when (posicao) {
            0 -> {
                binding.buttonUm.setBackgroundResource(R.drawable.icon2)
                binding.buttonUm.text = "O"
                binding.buttonUm.isEnabled = false
            }
            1 -> {
                binding.buttonDois.setBackgroundResource(R.drawable.icon2)
                binding.buttonDois.text = "O"
                binding.buttonDois.isEnabled = false
            }
            2 -> {
                binding.buttonTres.setBackgroundResource(R.drawable.icon2)
                binding.buttonTres.text = "O"
                binding.buttonTres.isEnabled = false
            }
            3 -> {
                binding.buttonQuatro.setBackgroundResource(R.drawable.icon2)
                binding.buttonQuatro.text = "O"
                binding.buttonQuatro.isEnabled = false
            }
            4 -> {
                binding.buttonCinco.setBackgroundResource(R.drawable.icon2)
                binding.buttonCinco.text = "O"
                binding.buttonCinco.isEnabled = false
            }
            5 -> {
                binding.buttonSeis.setBackgroundResource(R.drawable.icon2)
                binding.buttonSeis.text = "O"
                binding.buttonSeis.isEnabled = false
            }
            6 -> {
                binding.buttonSete.setBackgroundResource(R.drawable.icon2)
                binding.buttonSete.text = "O"
                binding.buttonSete.isEnabled = false
            }
            7 -> {
                binding.buttonOito.setBackgroundResource(R.drawable.icon2)
                binding.buttonOito.text = "O"
                binding.buttonOito.isEnabled = false
            }
            8 -> {
                binding.buttonNove.setBackgroundResource(R.drawable.icon2)
                binding.buttonNove.text = "O"
                binding.buttonNove.isEnabled = false
            }
        }

        verificaVencedor(tabuleiro)
    }

    private fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
        //Recebe o jogador vencedor através da função verificaVencedor. @param tabuleiro
        var vencedor: String? = null
        // Verifica linhas e colunas
        for (i in 0 until 3) {
            //Verifica se há três itens iguais na linha
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                vencedor = tabuleiro[i][0]
            }
            //Verifica se há três itens iguais na coluna
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                vencedor = tabuleiro[0][i]
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            vencedor = tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            vencedor = tabuleiro[0][2]
        }

        if (!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: $vencedor", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        //Verifica a quantidade de jogadores
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if (valor == "X" || valor == "O") {
                    empate++
                }
            }
        }
        //Se existem 9 jogadas e não há três letras iguais, houve um empate
        if (empate == 9) {
            Toast.makeText(this, "Empate", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            return "Empate"
        }
        // Nenhum vencedor
        return null
    }
}
