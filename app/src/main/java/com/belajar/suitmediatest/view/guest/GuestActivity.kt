package com.belajar.suitmediatest.view.guest

import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.belajar.suitmediatest.data.local.GuestDatabase
import com.belajar.suitmediatest.data.repository.GuestRepository
import com.belajar.suitmediatest.databinding.ActivityGuestBinding
import com.belajar.suitmediatest.view.adapter.GuestAdapter

class GuestActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGuestBinding
    private lateinit var guestViewModel: GuestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = GuestAdapter(this)
        binding.rvGuest.setHasFixedSize(true)
        binding.rvGuest.layoutManager = GridLayoutManager(applicationContext, 2)
        val dao = GuestDatabase.getInstance(application).guestDAO
        val repository = GuestRepository(dao)
        val factory = GuestViewModelFactory(repository)
        guestViewModel = ViewModelProvider(this, factory).get(GuestViewModel::class.java)
        binding.rvGuest.adapter = adapter
        adapter.notifyDataSetChanged()
        guestViewModel.getGuests().observe(this, Observer {
            adapter.setData(it)
        })
    }
}


