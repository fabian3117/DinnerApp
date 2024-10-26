package com.example.dinnercontroler.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dinnercontroler.models.DataRegisters

@Dao
interface DataRegistersDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserNewDataRegister(register: DataRegisters);

    @Query("SELECT * FROM RegisterDataCash")
    suspend fun getAllRegister(): List<DataRegisters>;
}