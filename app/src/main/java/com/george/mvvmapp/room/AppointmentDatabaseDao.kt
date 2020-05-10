package com.george.mvvmapp.room

import androidx.room.*

@Dao
interface AppointmentDatabaseDao {

    @Insert
    fun insert(app: AppointmentDB)

    @Update
    fun update(app: AppointmentDB)

    @Query("SELECT * from appointment_table WHERE _id = :key")
    fun get(key: Long): AppointmentDB

    @Query("SELECT * FROM appointment_table ORDER BY start_time_milli")
    fun getAllAppointments() : List<AppointmentDB>
//    fun getAllAppointments() : LiveData<List<Appointment>> //test cannot read live data for some reason

    @Delete
    fun delete(app: AppointmentDB)

    @Delete
    fun deleteAllAppointments(apps: List<AppointmentDB>) : Int

}