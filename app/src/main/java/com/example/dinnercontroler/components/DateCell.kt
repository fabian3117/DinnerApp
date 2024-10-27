package com.example.dinnercontroler.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dinnercontroler.now

import kotlinx.datetime.LocalDate

@Composable
fun DateCell(
    modifier: Modifier = Modifier,
    date: LocalDate,
    isSelected: Boolean = false,
    onDateSelected: (LocalDate) -> Unit,
    shape: Shape = DateCellDefaults.shape,
    colors: DateCellDefaults.DateCellColors = DateCellDefaults.colors(),
    elevation: DateCellDefaults.DateCellElevation = DateCellDefaults.elevation(),
    border: DateCellDefaults.DateCellBorder? = null
) {

    val cellColor = when {
        isSelected -> colors.selectedContainerColor
        date.isBefore(LocalDate.now("America/Argentina/Buenos_Aires")) -> colors.pastContainerColor
        else -> colors.futureContainerColor
    }

    val textColor = when {
        isSelected -> colors.selectedTextColor
        date.isBefore(LocalDate.now("America/Argentina/Buenos_Aires")) -> colors.pastTextColor
        else -> colors.futureTextColor
    }

    val cellBorder = border?.let {
        when {
            isSelected -> BorderStroke(it.selectedBorderWidth, it.selectedBorderColor)
            date.isBefore(LocalDate.now("America/Argentina/Buenos_Aires")) -> BorderStroke(
                it.pastBorderWidth,
                it.pastBorderColor
            )

            else -> BorderStroke(it.futureBorderWidth, it.futureBorderColor)
        }
    }

    val cellElevation = when {
        isSelected -> elevation.selectedElevation
        date.isBefore(LocalDate.now("America/Argentina/Buenos_Aires")) -> elevation.pastElevation
        else -> elevation.futureElevation
    }

    Card(
        modifier = modifier
            .shadow(elevation = cellElevation, shape = shape)
            .clip(shape = shape)
            .clickable { onDateSelected(date) },
        border = cellBorder,
        colors = CardDefaults.cardColors(containerColor = cellColor),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = date.dayOfWeek.name.subSequence(0, 3).toString()
                    .lowercase()
                    .replaceFirstChar { it.uppercase() },
                color = textColor,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = date.dayOfMonth.toString(),
                fontWeight = FontWeight.Black,
                color = textColor,
                fontSize = 24.sp
            )
        }
    }
}