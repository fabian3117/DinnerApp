package com.example.dinnercontroler.components

import kotlinx.datetime.LocalDate

/**
 * Checks whether the date is before [other] date.
 * @return true if the date is before [other] date, false otherwise.
 */
fun LocalDate.isBefore(other: LocalDate): Boolean {
    return this < other
}

/**
 * Checks whether the date is after [other] date.
 * @return true if the date is after [other] date, false otherwise.
 */
fun LocalDate.isAfter(other: LocalDate): Boolean {
    return this > other
}

