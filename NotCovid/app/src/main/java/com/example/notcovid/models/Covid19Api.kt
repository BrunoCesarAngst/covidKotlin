package com.example.notcovid.models

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderAPI {

    //https://api.covid19api.com/    +summary

    @GET()
    fun getGlobal(): Call<List<Summary>>
}