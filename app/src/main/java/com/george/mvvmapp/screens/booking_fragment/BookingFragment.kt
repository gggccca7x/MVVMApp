package com.george.mvvmapp.screens.booking_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.george.mvvmapp.R
import com.george.mvvmapp.databinding.FragmentBookingBinding
import com.george.mvvmapp.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class BookingFragment : DaggerFragment() {

    private lateinit var viewModel: BookingViewModel

    var providerFactory: ViewModelProviderFactory? = null
        @Inject set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding : FragmentBookingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false)

        viewModel = ViewModelProviders.of(this, providerFactory).get(BookingViewModel::class.java)

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            viewModel.onDateChanged(year, month, dayOfMonth)
        }
        viewModel.longTime.observe(viewLifecycleOwner, Observer {
            Timber.i("time is: $it")
            binding.calendarView.setDate(it, false, false)
        })

        return binding.root
    }

}
