package com.george.mvvmapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AppointmentDB::class], version = 1, exportSchema = false)
abstract class AppointmentDatabase: RoomDatabase() {

    abstract val appointmentDatabaseDao: AppointmentDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: AppointmentDatabase? = null

        fun getInstance(context: Context) : AppointmentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppointmentDatabase::class.java,
                        "appointment_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }

                return instance
            }
        }
    }
}