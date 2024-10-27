package com.example.dinnercontroler.components.newUI.dataUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dinnercontroler.R
import com.example.dinnercontroler.models.Category
import com.example.dinnercontroler.models.DataRegisterTest
import com.example.dinnercontroler.models.DataRegisterTestList
import com.example.dinnercontroler.models.DataRegisters
import com.example.dinnercontroler.ui.theme.ColorDeleteElement
import com.example.dinnercontroler.ui.theme.ColorHintIcons
import com.example.dinnercontroler.ui.theme.ColorSurface
import com.example.dinnercontroler.ui.theme.ColorTextAction
import com.example.dinnercontroler.ui.theme.ColorTextPrimary
import com.example.dinnercontroler.ui.theme.ColorTextPrimaryVariant

//@Preview(showBackground = true)
@Composable
fun UISecondSeccionHeader(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(16.dp))

    UISecction(modifier, true);
    UISecction(modifier, false);
}

@Preview(showBackground = true)
@Composable
fun UISecction(
    modifier: Modifier = Modifier,
    flagStyle: Boolean = false,
    data: List<DataRegisters> = DataRegisterTestList
) {
    val texto =
        if (flagStyle) stringResource(R.string.last_charge) else stringResource(R.string.last_entry);
    var datos =
        if (flagStyle) data.stream().filter { p -> p.category == Category.Gasto } else data.stream()
            .filter { p -> p.category != Category.Gasto };
    Box {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(5.dp),
            color = ColorSurface
        ) {
            Column {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = texto,
                        style = MaterialTheme.typography.titleLarge,
                        color = ColorTextPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    ActionText()
                }
                LastGastosElement(datos.toList());
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun LastGastosElement(data: List<DataRegisters> = DataRegisterTestList) {
    FlowColumn(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.onEach { item ->
            GastoElemento(
                data = item,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun LastElement(data: List<DataRegisters> = DataRegisterTestList, flagStyle: Boolean = true) {
    FlowColumn(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.onEach { item ->
            GastoElemento(
                data = item,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun BottomSheetSeeDetails() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Monto")
        Text(text = "500.0")
        Text(text = "Categoria")
        Text(text = "Ingreso")
        Text(text = "SubCategoria")
        Text(text = "Sueldo")
        Text(text = "Dia")
        Text(text = "2024/10/27")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Chip(onClick = { /*TODO*/ }) {
                Text(text = "Editar")
            }
            Chip(
                onClick = { /*TODO*/ },
                colors = ChipDefaults.chipColors(backgroundColor = ColorDeleteElement)
            ) {
                Text(text = "Eliminar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GastoElemento(data: DataRegisters = DataRegisterTest, modifier: Modifier = Modifier) {

    val icono =
        (if (data.category == Category.Gasto) Icons.Outlined.MonetizationOn else Icons.Default.Shop);
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                icono, contentDescription = "Category", tint = ColorHintIcons
            )
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Fecha : ${data.dateRegister.toString()}",
                    style = MaterialTheme.typography.labelSmall,
                    color = ColorTextPrimaryVariant
                )
                Text(
                    text = data.name,
                    style = MaterialTheme.typography.labelSmall,
                    color = ColorTextPrimary
                )
            }
        }
    }
}

//@Preview
@Composable
private fun ActionText(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = "Ver todo",
            style = MaterialTheme.typography.titleSmall,
            color = ColorTextAction,
            fontWeight = FontWeight.Medium
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = ColorTextAction
        )
    }
}