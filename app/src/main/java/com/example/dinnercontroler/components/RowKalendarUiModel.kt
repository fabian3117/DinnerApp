package com.example.dinnercontroler.components

import com.example.dinnercontroler.now
import kotlinx.datetime.LocalDate

internal data class RowKalendarUiModel(
    val isLoading: Boolean = false,
    val dates: List<LocalDate> = listOf(),
    val selectedDate: LocalDate = LocalDate.now("America/Argentina/Buenos_Aires"),
)