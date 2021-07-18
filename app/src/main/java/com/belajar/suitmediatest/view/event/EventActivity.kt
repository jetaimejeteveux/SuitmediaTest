package com.belajar.suitmediatest.view.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.suitmediatest.databinding.ActivityEventBinding
import com.belajar.suitmediatest.view.adapter.EventAdapter

class EventActivity : AppCompatActivity() {
    private lateinit var eventBinding: ActivityEventBinding
    private lateinit var eventViewModel: EventViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventBinding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(eventBinding.root)
        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        val  event = eventViewModel.getEvent()
        val adapter = EventAdapter(event)
        eventBinding.rvEvent.layoutManager = LinearLayoutManager(this)
        eventBinding.rvEvent.adapter = adapter
        adapter.notifyDataSetChanged()


    }
}