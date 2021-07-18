package com.belajar.suitmediatest.data.remote.network

import com.belajar.suitmediatest.data.remote.ModelGuest
import retrofit2.Call
import retrofit2.http.GET

interface GuestService {
    @GET("/v2/596dec7f0f000023032b8017")
    fun getGuests(): Call<List<ModelGuest>>
}