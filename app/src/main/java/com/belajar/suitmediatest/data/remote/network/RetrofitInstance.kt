package com.belajar.suitmediatest.data.remote.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
        val BASE_URL = "https://www.mocky.io/"
        fun getRetrofitInstance(): GuestService {
             val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
            return retrofit.create(GuestService::class.java)
    }
}