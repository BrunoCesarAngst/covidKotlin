package com.example.covid_193

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_paises.view.*

class AdapterPaises(val boletins: ArrayList<BoletimPaises>): RecyclerView.Adapter<AdapterPaises.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_paises, parent, false)
        val vh = VH(v)
        return vh
    }

    override fun getItemCount(): Int {
        return boletins.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var boletim = boletins[position]

        holder.country.text = boletim.country.toString()
        holder.cases.text = boletim.cases.toString()
        holder.deaths.text = boletim.deaths.toString()
        holder.confirmed.text = boletim.confirmed.toString()
        holder.recovered.text = boletim.recovered.toString()
    }

    class VH(item: View): RecyclerView.ViewHolder(item) {
        var country: TextView = item.country
        var cases: TextView = item.cases
        var deaths: TextView = item.deaths
        var confirmed: TextView = item.confirmed
        var recovered: TextView = item.recovered
    }

}