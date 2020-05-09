package com.george.mvvmapp.di.booking

import android.app.Application
import com.george.mvvmapp.room.AppointmentDatabase
import com.george.mvvmapp.room.AppointmentDatabaseDao
import dagger.Module
import dagger.Provides

//where to add dependencies for the booking fragment
@Module
class BookingModule {

    companion object {

        // need to find out where to get the application from
        @Provides
        fun provideDatabaseDao(application: Application) : AppointmentDatabaseDao {
            return AppointmentDatabase.getInstance(application).appointmentDatabaseDao
        }
    }
}