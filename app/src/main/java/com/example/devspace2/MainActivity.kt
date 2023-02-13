package com.example.devspace2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)


        btnCalcular.setOnClickListener {

        val alturaStr = edtAltura.text.toString()
        val pesoStr = edtPeso.text.toString()

        if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {


            val altura: Float = alturaStr.toFloat()
            val alturaFinal: Float = altura * altura
            val peso: Float = pesoStr.toFloat()
            val result: Float = peso / alturaFinal


//Essa intent vai me levar dessa tela para a ResultActivity

            val intent = Intent(this, ResultActivity::class.java)
                .apply {

                    putExtra("EXTRA_RESULT", result)

                }

            //Aqui eu inicializo minha intent
            startActivity(intent)
        } else {
            Toast.makeText(this, "Preencher todos campos", Toast.LENGTH_LONG).show()
        }
        }

    }
}