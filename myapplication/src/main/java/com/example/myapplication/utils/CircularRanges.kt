package com.example.myapplication.utils

import androidx.compose.ui.graphics.Color

data class CircularRanges(val initialAngle: Float, val finalAngle: Float) {
}

data class CircularRangesUI(val circularRanges: CircularRanges, val colorIndicater: Color) {

};
val CircularRangesRight = CircularRanges(initialAngle = 135f, finalAngle = 240f);
val CircularRangesLeft = CircularRanges(initialAngle = -45f, finalAngle = 80f);
val CircularRangesBills = CircularRangesUI(CircularRangesRight, Color.Red);
val CircularRangesIncome = CircularRangesUI(CircularRangesLeft, Color.Gray);