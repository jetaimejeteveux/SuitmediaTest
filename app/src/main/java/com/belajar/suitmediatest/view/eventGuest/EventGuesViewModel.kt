package com.belajar.suitmediatest.view.eventGuest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.belajar.suitmediatest.utils.Event

class EventGuesViewModel : ViewModel() {
    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage
    val eventButtonText = MutableLiveData<String>()
    val guestButtonText = MutableLiveData<String>()
    val nameText = MutableLiveData<String>()
    init {
        eventButtonText.value = "pilih event"
        guestButtonText.value = "pilih guest"
    }

    fun changeValueEventButton(eventText : String){
        eventButtonText.value = eventText
    }
    fun changeValueGuestButton(guestText : String){
        guestButtonText.value = guestText
    }
    fun changeNameText(nameTextNew : String){
        nameText.value = nameTextNew
    }
}