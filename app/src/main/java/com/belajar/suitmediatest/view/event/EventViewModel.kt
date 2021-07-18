package com.belajar.suitmediatest.view.event

import androidx.lifecycle.ViewModel
import com.belajar.suitmediatest.data.dummy.ModelEvent
import com.belajar.suitmediatest.data.repository.EventRepository

class EventViewModel : ViewModel() {
    private val repository = EventRepository()
    fun getEvent(): ArrayList<ModelEvent> {
        return repository.getDummyData()
    }
}