package com.belajar.suitmediatest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GuestEntity::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {
    abstract val guestDAO: GuestDAO

    companion object {
        @Volatile
        private var INSTANCE: GuestDatabase? = null
        fun getInstance(context: Context): GuestDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GuestDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}
