package com.daniloosorio.practica1_conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_convertir.setOnClickListener {
            val moneda1 = sp_moneda1.selectedItem.toString()
            val moneda2 = sp_moneda2.selectedItem.toString()
            var datoIn = ed_entrada.text.toString()
            var numero = 0F
            if (vacios(datoIn)) {
                numero= datoIn.toFloat()
                if (moneda1 == "Dolar") {
                    when(moneda2){
                        "Dolar"-> tv_salida.text = datoIn
                        "Euro"-> tv_salida.text = (numero * 0.89).toString()
                        "Yen"-> tv_salida.text = (numero * 106.87).toString()
                        "Peso Colombiano"->tv_salida.text = (numero * 3746.50).toString()
                    }
                } else if (moneda1 == "Euro") {
                    when(moneda2){
                        "Dolar"-> tv_salida.text = (numero * 1.12).toString()
                        "Euro"-> tv_salida.text = datoIn
                        "Yen"-> tv_salida.text = (numero * 120.26).toString()
                        "Peso Colombiano"->tv_salida.text = (numero * 4215.30).toString()
                    }
                } else if (moneda1 == "Yen") {
                    when(moneda2){
                        "Dolar"-> tv_salida.text = (numero * 0.0094).toString()
                        "Euro"-> tv_salida.text = (numero * 0.0083).toString()
                        "Yen"-> tv_salida.text = datoIn
                        "Peso Colombiano"->tv_salida.text = (numero * 35.06).toString()
                    }
                } else {
                    when(moneda2){
                        "Dolar"-> tv_salida.text = (numero * 0.00027).toString()
                        "Euro"-> tv_salida.text = (numero * 0.00024).toString()
                        "Yen"-> tv_salida.text = (numero * 0.029).toString()
                        "Peso Colombiano"->tv_salida.text = datoIn
                    }
                }
            }

        }

    }
///////////////////////funcion para detectar vacios y el punto solo//////////////////////////
    fun vacios(datoIn: String): Boolean {
        if (datoIn.isNullOrEmpty() || datoIn == ".") {
            Toast.makeText(this, "Ingrese el valor a convertir", Toast.LENGTH_SHORT).show()
        } else return true
        return false
    }
}

/*  creditos: https://www.youtube.com/watch?v=gLLE16x58t0 */
