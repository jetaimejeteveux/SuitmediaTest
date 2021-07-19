package com.belajar.suitmediatest.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest_data_table")
data class GuestEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "guest_id")
    var id: Int,

    @ColumnInfo(name = "guest_name")
    var name: String,

    @ColumnInfo(name = "guest_birthdate")
    var birthdate: String

)
