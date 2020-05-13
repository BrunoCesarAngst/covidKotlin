package com.example.covid_193

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Adapter(val boletins: ArrayList<Boletim>): RecyclerView.Adapter<Adapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val vh = VH(v)
        return vh
    }

    override fun getItemCount(): Int {
        return boletins.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var boletim = boletins[position]

        holder.uf.text = boletim.uf.toString()
        holder.cases.text = boletim.cases.toString()
        holder.deaths.text = boletim.deaths.toString()
        holder.suspects.text = boletim.suspects.toString()
        holder.refuses.text = boletim.refuses.toString()
    }

    class VH(item: View): RecyclerView.ViewHolder(item) {
        var uf: TextView = item.uf
        var cases: TextView = item.cases
        var deaths: TextView = item.deaths
        var suspects: TextView = item.suspects
        var refuses: TextView = item.refuses
    }

}