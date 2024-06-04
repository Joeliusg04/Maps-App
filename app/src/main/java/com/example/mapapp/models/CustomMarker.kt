package com.example.mapapp.models

import com.google.android.gms.maps.model.LatLng

data class CustomMarker(
    val name: String,
    val description: String,
    val position : LatLng,
    val image: String,
    val owner:String,
)
