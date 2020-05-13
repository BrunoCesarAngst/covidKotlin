package com.example.covid_193

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Boletim (
    val uf: String,
    val cases: Int,
    val deaths: Int,
    val suspects: Int,
    val refuses: Int
) :Parcelable