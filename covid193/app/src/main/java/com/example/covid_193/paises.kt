package com.example.covid_193

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_paises.*

class paises : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paises)

        val listaPaises = intent.getParcelableArrayListExtra<BoletimPaises>("listaPaises")

        RecyclerPaises.adapter = AdapterPaises(listaPaises)

        RecyclerPaises.layoutManager = LinearLayoutManager(this)
    }
}
