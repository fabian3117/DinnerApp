package com.example.dinnercontroler.components.newUI.dataUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dinnercontroler.R
import com.example.dinnercontroler.ui.theme.ColorSurface
import com.example.dinnercontroler.ui.theme.ColorTextAction
import com.example.dinnercontroler.ui.theme.ColorTextPrimary
import com.example.dinnercontroler.ui.theme.ColorTextPrimaryVariant

@Preview(showBackground = true)
@Composable
fun UISecondSeccionHeader(
    modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(16.dp))

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        shape = RoundedCornerShape(5.dp),
        color = ColorSurface) {
Column {


        Row(
            modifier = modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Ultimos gastos",
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            ActionText()
        }
    LastGastosElement();
}}

}
@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun LastGastosElement(){
    var dal= listOf("A","B","C","D")
    FlowColumn(
        modifier = Modifier
            .padding(10.dp).fillMaxWidth().fillMaxHeight(0.5f),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        dal.onEach { item->
            GastoElemento(
                data = item,
                modifier = Modifier.fillMaxWidth()
            )
        } }
}
@Preview(showBackground = true)
@Composable
fun GastoElemento(data: String = "F", modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,

        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Fecha",
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimaryVariant
            )
            Text(
                text = data,
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimary
            )
        }
    }
}

@Preview
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