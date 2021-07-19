package com.belajar.suitmediatest.data.repository

import android.app.Application
import android.util.Log
import android.view.Display
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.belajar.suitmediatest.data.local.GuestDAO
import com.belajar.suitmediatest.data.local.GuestDatabase
import com.belajar.suitmediatest.data.local.GuestEntity
import com.belajar.suitmediatest.data.remote.ModelGuest
import com.belajar.suitmediatest.data.remote.network.RetrofitInstance
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestRepository(private val dao: GuestDAO){
    private var liveData: MutableLiveData<List<ModelGuest>> = MutableLiveData<List<ModelGuest>>()

    fun getGuests() : LiveData<List<ModelGuest>>{
        val guestService = RetrofitInstance.getRetrofitInstance()
        guestService.getGuests().enqueue(object : Callback<List<ModelGuest>> {
            override fun onResponse(
                call: Call<List<ModelGuest>>,
                response: Response<List<ModelGuest>>
            ) {
                val data = response.body()
                Log.v("mytag", "response  ${data?.size}")
                Log.v("mytag", "data ${Gson().toJson(response.body())}")
                liveData.value = data!!
            }
            override fun onFailure(call: Call<List<ModelGuest>>, t: Throwable) {
               Log.e("mytag", "error = ${t.message}")
            }
        })
        return liveData
    }

    val guests = dao.getAllSubscribers()
    suspend fun insert(guest: GuestEntity): Long {
        return dao.insertGuest(guest)
    }

    suspend fun update(guest: GuestEntity): Int {
        return dao.updateGuest(guest)
    }

    suspend fun delete(guest: GuestEntity): Int {
        return dao.deleteGuest(guest)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }
}