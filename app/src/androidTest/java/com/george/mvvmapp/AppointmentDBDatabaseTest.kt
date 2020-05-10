package com.george.mvvmapp

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.george.mvvmapp.room.AppointmentDB
import com.george.mvvmapp.room.AppointmentDatabase
import com.george.mvvmapp.room.AppointmentDatabaseDao
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppointmentDBDatabaseTest {

    private lateinit var appDao: AppointmentDatabaseDao
    private lateinit var db: AppointmentDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppointmentDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        appDao = db.appointmentDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetAppointment() {
        CoroutineScope(Dispatchers.Main).launch {
            val app = AppointmentDB()
            val app2 = AppointmentDB()
            appDao.insert(app)
            appDao.insert(app2)
            val apps = appDao.getAllAppointments()
            assertEquals(2, apps.size)
        }
    }
}