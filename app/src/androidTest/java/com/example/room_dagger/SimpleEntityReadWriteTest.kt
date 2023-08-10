package com.example.room_dagger

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.room_dagger.data.sensor.local.AppDatabase
import com.example.room_dagger.data.sensor.model.Sensor
import com.example.room_dagger.data.sensor.local.SensorDao
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var userDao: SensorDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        userDao = db.sensorDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val sensorData: Sensor = Sensor(1,"","",100,"","")
        val sensorData1: Sensor = Sensor(2,"","",500,"","")
        val sensorData2: Sensor = Sensor(3,"","",100,"","")
        userDao.insert(sensorData)
        userDao.insert(sensorData1)
        userDao.insert(sensorData2)

        val allNotes = userDao.getAll()


        println(allNotes)

        assertEquals(allNotes[0].value,100)
    }
}