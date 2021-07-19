package com.belajar.suitmediatest.view.guest

import android.app.Application
import androidx.lifecycle.*
import com.belajar.suitmediatest.data.local.GuestEntity
import com.belajar.suitmediatest.data.remote.ModelGuest
import com.belajar.suitmediatest.data.repository.GuestRepository
import kotlinx.coroutines.launch


class GuestViewModel(private val repository: GuestRepository) : ViewModel() {

    fun getGuests() : LiveData<List<ModelGuest>> {
        return repository.getGuests()
    }
    fun insert(guest: GuestEntity) = viewModelScope.launch{
        repository.insert(guest)
    }
    fun update(guest: GuestEntity) = viewModelScope.launch {
        repository.insert(guest)
    }
    fun delete(guest: GuestEntity) = viewModelScope.launch {
        repository.insert(guest)
    }




}