package com.belajar.suitmediatest.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.belajar.suitmediatest.data.dummy.ModelEvent
import com.belajar.suitmediatest.databinding.ItemEventBinding
import com.belajar.suitmediatest.view.eventGuest.EventGuestActivity
import com.bumptech.glide.Glide

class EventAdapter(private val eventList: List<ModelEvent>)
    : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun getItemCount() = eventList.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        with(holder){
            with(eventList[position]) {
                binding.tvEventName.text = name

                binding.tvEventDate.text = date
                Glide.with(holder.itemView.context)
                    .load(img)
                    .into(binding.ivEvent)

                holder.itemView.setOnClickListener {
                    val eventIntent = Intent(it.context, EventGuestActivity::class.java).putExtra("nameEvent", name).putExtra("activity", "event")
                   it.context.startActivity(eventIntent)
                    val bulanString = date.split("-")
                    val bulanInt : Int = bulanString[1].toInt()
                    val text = checkPrime(bulanInt)
                    Toast.makeText(it.context, text, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    inner class EventViewHolder(val binding: ItemEventBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun checkPrime(date : Int): String{
                var bool = false
                val text: String
                for (i in 2..date / 2) {
                    // condition for nonprime number
                    if (date % i == 0) {
                        bool = true
                        break
                    }
                }
                if (!bool)
                    text = "$date is a prime number"
                else
                    text = "$date is not a prime number"
                return text
            }
        }


}