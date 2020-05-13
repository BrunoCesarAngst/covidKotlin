package com.example.covid_193

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_estado_br.*

class estadoBr : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estado_br)


        val lista = intent.getParcelableArrayListExtra<Boletim>("lista")

        RecyclerEstados.adapter = Adapter(lista)

        RecyclerEstados.layoutManager = LinearLayoutManager(this)
    }
}
