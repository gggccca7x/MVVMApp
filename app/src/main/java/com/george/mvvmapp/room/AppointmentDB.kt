package com.george.mvvmapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.george.mvvmapp.domain.DomainAppointment

@Entity(tableName = "appointment_table")
data class AppointmentDB(
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,

    @ColumnInfo(name = "start_time_milli")
    var startTimeMilli: Long = System.currentTimeMillis()
)

fun List<AppointmentDB>.asDomainModel(): List<DomainAppointment> {
    return map {
        DomainAppointment(
            _id = it._id,
            startTimeMilli = it.startTimeMilli
        )
    }
}