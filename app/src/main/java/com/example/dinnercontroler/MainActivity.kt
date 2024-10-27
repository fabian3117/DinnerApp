package com.example.dinnercontroler

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.ChipColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dinnercontroler.components.newUI.FinanceHealth
import com.example.dinnercontroler.components.newUI.dataUI.UISecondSeccionHeader
import com.example.dinnercontroler.dataBases.mainDatabase
import com.example.dinnercontroler.models.Category
import com.example.dinnercontroler.models.DataRegisters
import com.example.dinnercontroler.ui.theme.DinnerControlerTheme
import io.github.chouaibmo.rowkalendar.RowKalendar


import io.github.chouaibmo.rowkalendar.components.DateCell
import io.github.chouaibmo.rowkalendar.components.DateCellDefaults
import io.github.chouaibmo.rowkalendar.extensions.now
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import java.time.LocalDateTime

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainActivity : ComponentActivity() {

    companion object{
        lateinit var database: mainDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database= Room.databaseBuilder(
            applicationContext,
            mainDatabase::class.java,
            "my_database").build();

        val newRegister=DataRegisters(name = "Prueba-s", amount = 10.0, category = Category.Ingreso, subCategory = "TES", id = 0);
        GlobalScope.launch {
            database.registerDAO().inserNewDataRegister(newRegister);

        }

GlobalScope.launch {
    val dat=database.registerDAO().getAllRegister();
    dat.forEach{elemento->
        Log.e("TAG",elemento.name);
        Log.e("TAG",elemento.subCategory);

    }
}
        enableEdgeToEdge()
        setContent {
            DinnerControlerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        FinanceHealth();
                        UISecondSeccionHeader();
                    }
                  //  MainContent();
                }
            }
        }
    }
}
@Preview
@Composable
fun MainContent(){
    var isSelected:Boolean=false;
    val argentinaZoneId = ZoneId.of("America/Argentina/Buenos_Aires")
    val localDateTimeInArgentina = LocalDateTime.now(argentinaZoneId)
    val timeZone = TimeZone.of("ART")
    val currentInstant = Clock.System.now()

    val locale = Locale("es", "AR");
    val zonaHorariaArgentina = ZoneId.of("America/Argentina/Buenos_Aires")

    val formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", locale)
    val today = LocalDate.now("ARG")
//    Log.e("TAG",LocalDate.  )

    CardAmountTotal()
}
fun LocalDate.Companion.now( Zone:String): LocalDate {
    val currentInstant = Clock.System.now()
    val timeZone = TimeZone.of("America/Argentina/Buenos_Aires")
    //val timeZone = TimeZone.currentSystemDefault()
    return currentInstant.toLocalDateTime(timeZone).date
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun TopElement(){
    Column {
        Row {
            Text(text = "Dia");
            Text(text = "Semana");
            Text(text = "Mes");
            Text(text = "Año");
        }
        Row{
            Text(text = "<")
            Text(text = "21 oct - 27 oct");

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardAmountTotal(){
    var totalDinero=1000;
    var gasto:Boolean=true;
    Card(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(10.dp),onClick = { /*TODO*/ }) {
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Tu balance");

Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(text = "$$totalDinero");
    AssistChip(onClick = { /*TODO*/ }, label = { Text(text = "Subio") })
}}}
}
@Preview
@Composable
fun GastosCard(){
    Card(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(10.dp),onClick = { /*TODO*/ }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Gastos");
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "$");
                AssistChip(onClick = { /*TODO*/ }, label = { Text(text = "Subio") })
            }}}
}
@Preview
@Composable
fun VistaElemento(){
    Row{
        Column {
            Text(text = "Gasto 1");
            Text(text = "Fecha");
        }
        Text(text = "Monto")
    }
}

@Composable
fun GreetingPreview() {
    DinnerControlerTheme {
        Greeting("Android")
    }
}