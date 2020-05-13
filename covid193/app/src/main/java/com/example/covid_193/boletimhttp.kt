package com.example.covid_193

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

object boletimhttp {

    fun loadBoletim(ctx: Context): ArrayList<Boletim>? {

        val url = "https://covid19-brazil-api.now.sh/api/report/v1/"

        val client = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val jsonString = response.body?.string()

        val obj = JSONObject(jsonString)
        val json = obj.getJSONArray("data")
        println(json)

        return readBoletins(json)

    }

    fun readBoletins(json: JSONArray): ArrayList<Boletim> {
        val boletins: ArrayList<Boletim> = arrayListOf()

        try {
            for (i in 0..json.length() -1){
                val js = json.getJSONObject(i)
                val boletim = Boletim(
                    js.getString("uf"),
                    js.getInt("cases"),
                    js.getInt("deaths"),
                    js.getInt("suspects"),
                    js.getInt("refuses")
                )
                boletins.add(boletim)
            }
        } catch (e: IOException){
            Log.e("ERR", "Não deu para ler o JSON")
        }
        return boletins
    }

    fun loadBoletimPaises(ctx: Context): ArrayList<BoletimPaises>? {

        val url = "https://covid19-brazil-api.now.sh/api/report/v1/countries"

        val client = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val jsonString = response.body?.string()

        val obj = JSONObject(jsonString)
        val json = obj.getJSONArray("data")
        println(json)

        return readBoletinsPaises(json)

    }
    fun readBoletinsPaises(json: JSONArray): ArrayList<BoletimPaises> {
        val boletins: ArrayList<BoletimPaises> = arrayListOf()

        try {
            for (i in 0..json.length() -1){
                val js = json.getJSONObject(i)
                val boletim = BoletimPaises(
                    js.getString("country"),
                    js.getInt("cases"),
                    js.getInt("confirmed"),
                    js.getInt("deaths"),
                    js.getInt("recovered")
                )
                boletins.add(boletim)
            }
        } catch (e: IOException){
            Log.e("ERR", "Não deu para ler o JSON")
        }
        return boletins
    }

    fun loadWorld(): World? {
        val url = "https://api.covid19api.com/world/total"

        val client = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val jsonString = response.body?.string()

        val obj = JSONObject(jsonString)
//        val json = obj.getJSONArray("data")
        println(obj)

        return readWorld(obj)
    }

    fun readWorld(json: JSONObject): World? {

        var world : World? = null

        try {
                world = World(
                    json.getInt("TotalConfirmed"),
                    json.getInt("TotalDeaths"),
                    json.getInt("TotalRecovered")
                )
        } catch (e: IOException){
            Log.e("ERR", "Não deu para ler o JSON")
        }
        return world
    }
}