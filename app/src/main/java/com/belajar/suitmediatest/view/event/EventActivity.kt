package com.belajar.suitmediatest.view.event

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.belajar.suitmediatest.R
import com.belajar.suitmediatest.databinding.ActivityEventBinding


class EventActivity : AppCompatActivity() {
    private lateinit var eventBinding: ActivityEventBinding
    val fragmentEvent = EventFragment()
    val fragmentMap = MapsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventBinding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(eventBinding.root)

        setFragment(fragmentEvent)
        setSupportActionBar(eventBinding.toolbarEvent)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun setFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.event_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_map -> {
                setFragment(fragmentMap)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}