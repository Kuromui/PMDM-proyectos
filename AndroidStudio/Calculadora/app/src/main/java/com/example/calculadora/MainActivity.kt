package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener { //implementar interfaz View
    //1º activar binding en gradle (module:app)
    private lateinit var binding: ActivityMainBinding
    private var resultado:Int = 0
    private var num1:String = ""
    private var num2:String = ""
    private var operador:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //layoutInflater permite que el ActivityMainBinding este guardado en la variable binding
        //asociación parte lógica y gráfica
        setContentView(binding.root)
        num1 = savedInstanceState?.getString("key_num1", num1) ?: ""
        binding.pantalla.text = num1
        //operador = savedInstanceState?.getString("key_operador", operador) ?: ""
        //num2 = savedInstanceState?.getString("key_num2", num2) ?: ""


        binding.btnCero.setOnClickListener(this)
        binding.btnUno.setOnClickListener(this)
        binding.btnDos.setOnClickListener(this)
        binding.btnTres.setOnClickListener(this)
        binding.btnCuatro.setOnClickListener(this)
        binding.btnCinco.setOnClickListener(this)
        binding.btnSeis.setOnClickListener(this)
        binding.btnSiete.setOnClickListener(this)
        binding.btnOcho.setOnClickListener(this)
        binding.btnNueve.setOnClickListener(this)
        binding.btnRestart.setOnClickListener(this)
        binding.btnResult.setOnClickListener(this)
        binding.btnSumar.setOnClickListener(this)
        binding.btnRestar.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnDividir.setOnClickListener(this)
        binding.btnPotencia?.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
            when (v?.id) {
                binding.btnRestart.id -> restart()
                //Hago un getText del layout y lo paso a String. De ahí lo paso a la fun concatenar y le asocio un nombre en los parametros.
                binding.btnCero.id ->numConcat(binding.btnCero.text.toString())
                binding.btnUno.id ->numConcat(binding.btnUno.text.toString())
                binding.btnDos.id ->numConcat(binding.btnDos.text.toString())
                binding.btnTres.id ->numConcat(binding.btnTres.text.toString())
                binding.btnCuatro.id ->numConcat(binding.btnCuatro.text.toString())
                binding.btnCinco.id ->numConcat(binding.btnCinco.text.toString())
                binding.btnSeis.id ->numConcat(binding.btnSeis.text.toString())
                binding.btnSiete.id ->numConcat(binding.btnSiete.text.toString())
                binding.btnOcho.id ->numConcat(binding.btnOcho.text.toString())
                binding.btnNueve.id ->numConcat(binding.btnNueve.text.toString())

                //Elección de operación
                binding.btnSumar.id->preOpera(binding.btnSumar.text.toString())
                binding.btnRestar.id->preOpera(binding.btnRestar.text.toString())
                binding.btnMultiplicar.id->preOpera(binding.btnMultiplicar.text.toString())
                binding.btnDividir.id->preOpera(binding.btnDividir.text.toString())
                binding.btnPotencia?.id ?: 0 ->preOpera(binding.btnPotencia?.text.toString())
                //Resultado
                binding.btnResult.id->resultado()

            }

    }
    //Concatenación de números
    private fun numConcat(numero:String){
    //Necesito comprobar si he pulsado el operador para poder crear las variables y que después de pulsarlo limpie la pantalla y no se junte con la siguiente variable.
        if (operador.isEmpty()){
            num1 +=numero //Se asigna el valor del text del botón y se añade
            binding.pantalla.text = num1
    }
    else{
        num2 +=numero
        binding.pantalla.text = num2
    }
    }

    //Limpiar pantalla cuando se le da a "C"
    private fun restart(){
        num1 = ""
        num2 = ""
        resultado=0
        operador = ""
        binding.pantalla.text = "0"
    }
    //Elegimos operador y limpiamos pantalla
    private fun preOpera(simbolo:String){
        //preguntamos si ya tiene un valor la num1. Si lo tiene, se limpia tras darle al simbolo
            operador = simbolo
            binding.pantalla.text = "0"
    }

    private fun resultado() {
        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            //Paso num1 y num2 a Int para poder operar con ellos
            val operando1 = num1.toInt()
            val operando2 = num2.toInt()

            //Le paso el operador como parametro
            resultado = when (operador) {
                "+" -> {
                    operando1 + operando2
                }
                "-" -> {
                    operando1 - operando2
                }
                "*" -> {
                    operando1 * operando2
                }
                "/" -> {
                    operando1 / operando2
                }
                "^" -> {
                    Math.pow(operando1.toDouble(), operando2.toDouble()).toInt()
                }
                else -> {0}//resultado=0
            }
            binding.pantalla.text = resultado.toString()
            //Para hacer una operación diferente, tenemos que darle a la "C" y hacer la operación.

            //Si guardo resultado en num1, se guarda la primera operación en la variable num1 y puedo hacer una nueva seguida (1 + 1 = 2 + 3 = 5)
            num1=resultado.toString()
            num2=""
            operador=""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //guardo datos al cambio de pantalla
        outState.putString("key_num1", num1)
        outState.putString("key_num2", num2)
        outState.putString("key_operador", operador)
    }

}