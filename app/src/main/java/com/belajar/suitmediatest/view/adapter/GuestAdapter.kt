package com.belajar.suitmediatest.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.belajar.suitmediatest.data.remote.ModelGuest
import com.belajar.suitmediatest.databinding.ItemGuestBinding
import com.belajar.suitmediatest.view.eventGuest.EventGuestActivity

class GuestAdapter(private val context: Context)
    : RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {
    private val guest = ArrayList<ModelGuest>()
    private lateinit var text : String

    fun setData(guestList : List<ModelGuest>){
        guest.clear()
        guest.addAll(guestList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val binding = ItemGuestBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(binding)
    }

    override fun getItemCount() = guest.size

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        with(holder){
            with(guest[position]) {
                binding.tvGuestName.text = name

                binding.tvGuestBirthdate.text = birthdate


                holder.itemView.setOnClickListener {
                    val guestIntent = Intent(it.context, EventGuestActivity::class.java).putExtra("nameGuest", name).putExtra("activity", "guest")
                    it.context.startActivity(guestIntent)
                    val tanggalString = birthdate.split("-")
                    val tanggalAngka : Int = tanggalString[2].toInt()
                    text = when {
                        (tanggalAngka % 3 == 0) && (tanggalAngka % 2 == 0) -> "iOS"
                        tanggalAngka % 2 == 0 -> "Blackberry"
                        tanggalAngka % 3 == 0 -> "Android"
                        else -> "Phone"
                    }
                    Toast.makeText(it.context, text, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    inner class GuestViewHolder(val binding: ItemGuestBinding)
        : RecyclerView.ViewHolder(binding.root)
}