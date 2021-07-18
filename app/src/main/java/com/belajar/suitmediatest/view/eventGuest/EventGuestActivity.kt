package com.belajar.suitmediatest.view.eventGuest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.belajar.suitmediatest.R
import com.belajar.suitmediatest.databinding.ActivityEventGuestBinding
import com.belajar.suitmediatest.view.guest.GuestActivity
import com.belajar.suitmediatest.view.event.EventActivity

class EventGuestActivity: AppCompatActivity()  {
    private lateinit var binding: ActivityEventGuestBinding
    private lateinit var eventGuestViewModel: EventGuesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_guest)

        eventGuestViewModel = ViewModelProvider(this).get(EventGuesViewModel::class.java)
        binding.eventGuestViewModel = eventGuestViewModel
        val nameTextNew = intent.getStringExtra("name").toString()
        val eventButtonNew = intent.getStringExtra("nameEvent").toString()
        val guestButtonNew = intent.getStringExtra("nameGuest").toString()
        val birthdateGuest = intent.getStringExtra("birthdate").toString()
        //val sourceActivity = ActivityCompat.getReferrer(this)
        val dateEvent = intent.getStringExtra("date").toString()
        birthdateGuest.split("-")
        val tanggal = birthdateGuest[2]



        eventGuestViewModel.changeNameText(nameTextNew)
        eventGuestViewModel.changeValueGuestButton(guestButtonNew)
        eventGuestViewModel.changeValueEventButton(eventButtonNew)

        binding.lifecycleOwner = this

        binding.btnGuest.setOnClickListener {
            val guestIntent = Intent(this, GuestActivity::class.java)
            startActivity(guestIntent)
        }
        binding.btnEvent.setOnClickListener {
            val eventIntent = Intent(this, EventActivity::class.java)
            startActivity(eventIntent)
        }
    }
}