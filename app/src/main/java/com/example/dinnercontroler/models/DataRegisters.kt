package com.example.dinnercontroler.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//import java.util.Date
@Entity(tableName = "RegisterDataCash")
data class DataRegisters (
@PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val amount:Double,
//    val dateRegister:Date,

    val category: Category,
    val subCategory:String,
    )