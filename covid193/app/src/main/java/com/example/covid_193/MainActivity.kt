package com.example.covid_193

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var lista: ArrayList<Boletim>? = arrayListOf()

    var listaPaises: ArrayList<BoletimPaises>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setWorld()

        CoroutineScope(IO).launch {
            lista = estados()
            listaPaises = paises()
        }

        val intent = Intent(this, estadoBr :: class.java)

        val intentPais = Intent(this, paises :: class.java)

        ListaEstados.setOnClickListener {
            intent.putExtra("lista", lista)
            this.startActivity(intent)
        }

        ListaPaises.setOnClickListener {
            intentPais.putExtra("listaPaises", listaPaises)
            this.startActivity(intentPais)
        }
    }

    suspend fun estados(): ArrayList<Boletim>? {
        return boletimhttp.loadBoletim(this)
    }

    suspend fun paises(): ArrayList<BoletimPaises>? {
        return boletimhttp.loadBoletimPaises(this)
    }

    suspend fun world() : World? {
        return boletimhttp.loadWorld()
    }

    fun setWorld() {

        var world: World? = null
        CoroutineScope(IO).launch {
            world = world()
            CoroutineScope(Main).launch {
                TotalConfirmed.text = world?.totalConfirmed.toString()
                TotalDeaths.text = world?.totalDeaths.toString()
                TotalRecovered.text = world?.totalRecovered.toString()
            }
        }
    }
}
