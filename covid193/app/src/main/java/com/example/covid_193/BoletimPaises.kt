package com.example.covid_193

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class BoletimPaises (
    val country: String,
    val cases: Int,
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int
) :Parcelable