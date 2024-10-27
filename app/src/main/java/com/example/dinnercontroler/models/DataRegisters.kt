package com.example.dinnercontroler.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//import java.util.Date
@Entity(tableName = "RegisterDataCash")
data class DataRegisters(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val amount: Double = 0.0,
    val dateRegister: String = "2024/10/27-16:27",
    val category: Category = Category.Gasto,
    val subCategory: String = "",
)

var DataRegisterTest = DataRegisters(
    id = 0,
    name = "Galletitas",
    amount = 500.0,
    category = Category.Gasto,
    subCategory = "Supermercado"
);
var DataRegisterTestList = listOf(
    DataRegisters(
        name = "Galletitas",
        amount = 500.0,
        category = Category.Gasto,
        subCategory = "Supermercado",
        id = 0
    ),
    DataRegisters(
        name = "Galletitas",
        amount = 500.0,
        category = Category.Gasto,
        subCategory = "Supermercado",
        id = 0
    ),
    DataRegisters(
        name = "Sueldo",
        amount = 500.0,
        category = Category.Ingreso,
        subCategory = "Sueldo",
        id = 0
    ),
)