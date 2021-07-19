package com.belajar.suitmediatest.view.guest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.belajar.suitmediatest.data.repository.GuestRepository

import java.lang.IllegalArgumentException

class GuestViewModelFactory(private val repository: GuestRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GuestViewModel::class.java)){
            return GuestViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}