package com.example.dinnercontroler.dataBases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dinnercontroler.interfaces.DataRegistersDAO

@Database(entities = [Database::class], version = 1)
abstract class mainDatabase : RoomDatabase() {
    abstract fun registerDAO(): DataRegistersDAO
}