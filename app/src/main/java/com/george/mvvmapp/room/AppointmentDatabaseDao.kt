package com.george.mvvmapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppointmentDatabaseDao {

    //insert

    @Insert
    fun insert(app: AppointmentDB)

    //update

    @Update
    fun update(app: AppointmentDB)

    //query

    @Query("SELECT * from appointment_table WHERE _id = :key")
    fun getByID(key: Long): AppointmentDB

    @Query("SELECT * from appointment_table WHERE start_time_milli = :time")
    fun getByTime(time: Long): AppointmentDB

    @Query("SELECT * FROM appointment_table ORDER BY start_time_milli")
    fun getAllAppointments() : List<AppointmentDB>

    @Query("SELECT * FROM appointment_table ORDER BY start_time_milli")
    fun getAllAppointmentsLiveData() : LiveData<List<AppointmentDB>>

    //delete

    @Query("DELETE from appointment_table WHERE start_time_milli = :time")
    fun deleteByTime(time: Long)

    @Delete
    fun delete(app: AppointmentDB)

    @Delete
    fun deleteAllAppointments(apps: List<AppointmentDB>) : Int

}