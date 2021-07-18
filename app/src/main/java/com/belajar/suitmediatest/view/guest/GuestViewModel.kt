package com.belajar.suitmediatest.view.guest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.belajar.suitmediatest.data.remote.ModelGuest
import com.belajar.suitmediatest.data.repository.GuestRepository


class GuestViewModel : ViewModel() {
    private val repository = GuestRepository()
    fun getGuests() : LiveData<List<ModelGuest>> {
        return repository.getGuests()
    }



}