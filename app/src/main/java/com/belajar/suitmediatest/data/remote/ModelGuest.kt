package com.belajar.suitmediatest.data.remote

import com.google.gson.annotations.SerializedName

data class ModelGuest (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("birthdate") val birthdate : String
    )