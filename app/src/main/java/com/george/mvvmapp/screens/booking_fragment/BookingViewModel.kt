package com.george.mvvmapp.screens.booking_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class BookingViewModel : ViewModel() {

    var longTime = MutableLiveData<Long>()

    init {
        longTime.value = System.currentTimeMillis()
    }

    override fun onCleared() {
        super.onCleared()


    }

    fun onDateChanged(year: Int, month: Int, dayOfMonth: Int) {
        val instance = Calendar.getInstance()
        instance.set(year, month, dayOfMonth)
        longTime.value = instance.timeInMillis
    }
}