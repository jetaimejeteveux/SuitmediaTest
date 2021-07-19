package com.belajar.suitmediatest.view.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            val text = checkPalindrome(name)
            val intent = Intent(this, EventGuestActivity::class.java)
                .putExtra("name", name).putExtra("activity", "home")
            startActivity(intent)
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPalindrome(textCheck: String) : String {
        val textCheck = textCheck.replace("\\s".toRegex(), "")
        val reverseText = textCheck.reversed()
        return when (textCheck) {
            reverseText -> "$textCheck is a palindrome"
            else -> "$textCheck is not a palindrome"
        }

    }
}