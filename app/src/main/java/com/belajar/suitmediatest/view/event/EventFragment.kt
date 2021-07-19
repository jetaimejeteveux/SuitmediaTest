package com.belajar.suitmediatest.view.event

import android.os.Bundle
import android.util.EventLog
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.suitmediatest.R
import com.belajar.suitmediatest.databinding.FragmentEventBinding
import com.belajar.suitmediatest.view.adapter.EventAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventBinding
    private lateinit var eventViewModel: EventViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventBinding.bind(view)

        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        val  event = eventViewModel.getEvent()
        val adapter = EventAdapter(event)
        binding.rvEvent.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvEvent.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}