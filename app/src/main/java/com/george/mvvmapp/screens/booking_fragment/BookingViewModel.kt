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
import kotlin.math.floor

class BookingViewModel @Inject constructor(
    databaseDao: AppointmentDatabaseDao
) : ViewModel() {

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val appointments: LiveData<List<AppointmentDB>> = databaseDao.getAllAppointmentsLiveData()


    // these are always being set together, find a way to make 1 variable holding both pieces of information?
    private val _today = MutableLiveData<AppointmentDB>() //convert to domain appointment in the future with repository pattern
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
            else -> View.INVISIBLE
        }
    }

    init {
        Timber.i("booking fragment view model created")
        Timber.i("check to see if dependency database dao is initiated correctly: $databaseDao")
        val instance = Calendar.getInstance()
        instance.set(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH), instance.get(Calendar.DAY_OF_MONTH), 9, 0, 0)
        val floatVal = instance.timeInMillis * 0.001
        val longVal = (floor(floatVal) * 1000).toLong()
        _longTime.value = longVal
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
        instance.set(year, month, dayOfMonth, 9, 0, 0)
        val floatVal = instance.timeInMillis * 0.001
        val longVal = (floor(floatVal) * 1000).toLong()
        _longTime.value = longVal
        Timber.i("time in millis of this instance is: ${instance.timeInMillis}")
        _today.value!!.startTimeMilli = _longTime.value!!
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
