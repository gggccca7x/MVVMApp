package com.george.mvvmapp.screens.booking_fragment

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.george.mvvmapp.domain.DomainAppointment
import com.george.mvvmapp.room.AppointmentDB
import com.george.mvvmapp.room.AppointmentDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    databaseDao: AppointmentDatabaseDao
) : ViewModel() {

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _today = MutableLiveData<AppointmentDB>() //convert to domain appointment in the future with repository pattern
    private val appointments: LiveData<List<AppointmentDB>> = databaseDao.getAllAppointmentsLiveData()


    private val _longTime = MutableLiveData<Long>()
    val longTime: LiveData<Long>
        get() = _longTime

    private val _isTodayBooked = MutableLiveData<Boolean>()
    val isTodayBooked: LiveData<Boolean>
        get() = _isTodayBooked
    val bookButtonVisible = Transformations.map(_isTodayBooked){
        when {
            it -> View.INVISIBLE
            else -> View.VISIBLE
        }
    }
    val deleteButtonVisible = Transformations.map(_isTodayBooked){
        when {
            it -> View.VISIBLE
            else -> {
                View.INVISIBLE
            }
        }
    }

    init {
        Timber.i("booking fragment view model created")
        Timber.i("check to see if dependency database dao is initiated correctly: $databaseDao")
        _longTime.value = System.currentTimeMillis()
        _today.value = AppointmentDB(1, _longTime.value!!)

        _isTodayBooked.value = checkCurrentDateIsBooked(_today.value!!.startTimeMilli)
        Timber.i("check is booked: ${_isTodayBooked.value}")
    }

    private fun checkCurrentDateIsBooked(today: Long) : Boolean {
        appointments.value?.forEach {
            if(it.startTimeMilli == today) {
                return true
            }
        }
        return false
    }

    fun onDateChanged(year: Int, month: Int, dayOfMonth: Int) {
        val instance = Calendar.getInstance()
        instance.set(year, month, dayOfMonth)
        _longTime.value = instance.timeInMillis
        _today.value = AppointmentDB(1, _longTime.value!!)
        //check if this date is already in the database
        _isTodayBooked.value = checkCurrentDateIsBooked(_today.value!!.startTimeMilli)
        Timber.i("check is booked: ${_isTodayBooked.value}")
    }

    fun bookButtonClicked() {

    }

    fun deleteButtonClicked() {

    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
