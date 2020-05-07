package com.george.mvvmapp.screens.booking_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.george.mvvmapp.R
import com.george.mvvmapp.databinding.FragmentBookingBinding

class BookingFragment : Fragment() {

    private lateinit var viewModel: BookingViewModel
    private lateinit var binding: FragmentBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        viewModel = ViewModelProviders.of(this).get(BookingViewModel::class.java)


        return binding.root
    }

}
