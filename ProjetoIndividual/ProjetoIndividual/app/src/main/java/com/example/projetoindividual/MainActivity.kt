package com.example.projetoindividual

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun clicarProximo(componente:View){
        var nomeUsuario:String = et_nome.text.toString()

        if(nomeUsuario == ""){
            Toast.makeText(this, "Insira um nome, por favor", Toast.LENGTH_SHORT).show()
            txt_error_primeiro.visibility = VISIBLE

        }
        else if (txt_segundo_info.visibility == GONE) {
            txt_segundo_info.visibility = VISIBLE
            et_nome_2.visibility = VISIBLE
            txt_error_primeiro.visibility = GONE
            btn_prox.translationY = 570F


        }
        else{
            txt_terceiro_info.visibility = VISIBLE
            et_nome_3.visibility = VISIBLE
            btn_prox.visibility = GONE
            btn_calc.visibility = VISIBLE
            btn_calc.translationY = 770F
        }
    }

    fun calcularRenda(componente: View){
        var nomeUsuario:String = et_nome.text.toString()
        var quantidadePessoas:String = et_nome_2.text.toString()
        var salarioFamilia:String = et_nome_3.text.toString()
        var condicao:Boolean = false


            if (quantidadePessoas.equals("") || quantidadePessoas <= "0") {
                txt_error_segundo.visibility = VISIBLE
                txt_resposta.visibility = GONE

            }
            if (salarioFamilia.equals("") || salarioFamilia <= "0") {
                txt_error_terceiro.visibility = VISIBLE
                txt_resposta.visibility = GONE
            } else {
                txt_error_terceiro.visibility = GONE
                txt_error_segundo.visibility = GONE
                condicao = true
            }

            if(condicao == true){
                var resultado = 0.00

                resultado = (et_nome_3.text.toString().toDouble() / et_nome_2.text.toString().toInt())
                if(resultado < 1558.5){
                    txt_resposta.setTextColor(Color.RED)
                } else if (resultado < 3117.0){
                    txt_resposta.setTextColor(Color.rgb(255,165,0))
                } else{
                    txt_resposta.setTextColor(Color.GREEN)
                }
                txt_resposta.text = "Olá, $nomeUsuario, sua casa possui uma renda familiar de R$${String.format("%.2f", resultado)}. "+
                        "Ou seja, sua família está ${
                        if (resultado < 1558.5){
                            "abaixo de 1 salario mínimo e meio"
                        }else if(resultado < 3117.0){
                            "um pouco menos de 3 salários mínimo"
                        }else{
                            "acima de 3 salários mínimo (RICASSO)"
                        }
                        }"
            }



    }

    fun resetCampos(componente: View){
        et_nome.text.clear()
        et_nome_2.text.clear()
        et_nome_3.text.clear()

        txt_resposta.text = ""
    }
}