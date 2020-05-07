package com.george.mvvmapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppointmentDatabaseDao {

    @Insert
    fun insert(app: Appointment)

    @Update
    fun update(app: Appointment)

    @Query("SELECT * from appointment_table WHERE _id = :key")
    fun get(key: Long): Appointment

    @Query("SELECT * FROM appointment_table ORDER BY start_time_milli")
    fun getAllAppointments() : LiveData<List<Appointment>>

    @Delete
    fun delete(app: Appointment)

    @Delete
    fun deleteAllAppointments(apps: List<Appointment>) : Int

}