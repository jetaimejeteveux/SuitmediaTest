package com.belajar.suitmediatest.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GuestDAO {
    @Insert
    suspend fun insertGuest(guest: GuestEntity) : Long

    @Update
    suspend fun updateGuest(guest: GuestEntity) : Int

    @Delete
    suspend fun deleteGuest(guest: GuestEntity) : Int

    @Query("DELETE FROM guest_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM guest_data_table")
    fun getAllSubscribers(): Flow<List<GuestEntity>>
}