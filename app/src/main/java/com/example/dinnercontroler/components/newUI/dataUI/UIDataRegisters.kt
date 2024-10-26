package com.example.dinnercontroler.components.newUI.dataUI

import androidx.annotation.DrawableRes
import com.example.dinnercontroler.R

data class UIDataRegistersItem(
    @DrawableRes val icon: Int,
                      var title: String,
                      val value: String
)

val UIDataRegistersList = listOf(
    UIDataRegistersItem(
        title = "Gastos de dia",
        value = "$6.500",
        icon = R.drawable.ic_real_feel
    ),
    UIDataRegistersItem(
        title = "Gastos de mes",
        value = "$200.000",
        icon = R.drawable.ic_wind_qality,
    ),
    UIDataRegistersItem(
        title = "Gastos de año",
        value = "$500.000",
        icon = R.drawable.ic_so2
    )
)