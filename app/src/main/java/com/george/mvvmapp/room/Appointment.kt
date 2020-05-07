package com.george.mvvmapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointment_table")
data class Appointment(
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,

    @ColumnInfo(name = "start_time_milli")
    val startTimeMilli: Long
)