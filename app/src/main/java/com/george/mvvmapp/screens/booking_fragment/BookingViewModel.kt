package com.george.mvvmapp.screens.booking_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class BookingViewModel : ViewModel() {

    private val _longTime = MutableLiveData<Long>()
    val longTime: LiveData<Long>
        get() = _longTime


    init {
        _longTime.value = System.currentTimeMillis()
    }

    fun onDateChanged(year: Int, month: Int, dayOfMonth: Int) {
        val instance = Calendar.getInstance()
        instance.set(year, month, dayOfMonth)
        _longTime.value = instance.timeInMillis
    }

    override fun onCleared() {
        super.onCleared()
    }
}
