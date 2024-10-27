package com.example.dinnercontroler.components.newUI.dataUI

import androidx.annotation.DrawableRes
import com.example.dinnercontroler.R

data class UIDataRegistersItem(
    @DrawableRes val icon: Int,
    var title: String,
    val value: String
)

//AttachMoney
val UIDataRegistersList = listOf(
    UIDataRegistersItem(
        title = "Gastos de dia",
        value = "$6.500",
        icon = R.drawable.credit_card
    ),
    UIDataRegistersItem(
        title = "Gastos de mes",
        value = "$200.000",
        icon = R.drawable.business_center,
    ),
    UIDataRegistersItem(
        title = "Gastos de año",
        value = "$500.000",
        icon = R.drawable.currency_exchange
    )
)