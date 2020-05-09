package com.george.mvvmapp.screens.booking_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.george.mvvmapp.room.AppointmentDatabaseDao
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    databaseDao: AppointmentDatabaseDao
) : ViewModel() {

    private val _longTime = MutableLiveData<Long>()
    val longTime: LiveData<Long>
        get() = _longTime

    init {
        Timber.i("booking fragment view model created")
        Timber.i("check to see if dependency database dao is initiated correctly: $databaseDao")
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
