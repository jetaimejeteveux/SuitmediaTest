package com.belajar.suitmediatest.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belajar.suitmediatest.databinding.ActivityHomeBinding
import com.belajar.suitmediatest.view.eventGuest.EventGuestActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            name = binding.edtName.text.toString()
            val intent = Intent(this, EventGuestActivity::class.java)
                .putExtra("name", name)
            startActivity(intent)
        }
    }
}