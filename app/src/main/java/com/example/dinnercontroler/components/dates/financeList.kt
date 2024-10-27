package com.example.dinnercontroler.components.dates

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.dinnercontroler.ui.theme.BlueStart
import com.example.dinnercontroler.ui.theme.GreenStart
import com.example.dinnercontroler.ui.theme.OrangeStart

import com.example.dinnercontroler.ui.theme.PurpleStart

data class Finance(
    val icon: ImageVector,
    val name: String,
    val background: Color
)
val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),

    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),

    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Analisis\nFinanciero",
        background = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Mis\nTransaciones",
        background = GreenStart
    ),
)