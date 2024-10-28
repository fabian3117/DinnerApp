/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ProgressIndicatorDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.protolayout.material.CircularProgressIndicator
import com.example.myapplication.R
import com.example.myapplication.presentation.theme.DinnerControlerTheme
import com.example.myapplication.utils.CircularRanges
import com.example.myapplication.utils.CircularRangesBills
import com.example.myapplication.utils.CircularRangesIncome
import com.example.myapplication.utils.CircularRangesRight
import com.example.myapplication.utils.CircularRangesUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearApp("Android")
        }
    }
}

@Composable
fun WearApp(greetingName: String) {
   // WearAppMain()
    CircularIndicators(circularRangeUI = CircularRangesBills);
    CircularIndicators(circularRangeUI = CircularRangesIncome);
    /*
    DinnerControlerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText()
            Greeting(greetingName = greetingName)
        }
    }

     */
}
//@Preview
@Composable
fun CircularIndicators(circularRangeUI: CircularRangesUI= CircularRangesBills){
    Box(modifier = Modifier.fillMaxSize()){
        val progressValue = 1f
        val angleInitialGasto=135f;
        val angleFinalGasto=240f;
        val angleAnimation = rememberInfiniteTransition()
        val angle by angleAnimation.animateFloat(
            initialValue = circularRangeUI.circularRanges.initialAngle,
            targetValue = circularRangeUI.circularRanges.finalAngle,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000),
                repeatMode = RepeatMode.Restart
            )
        );
        CircularProgressIndicator(
modifier = Modifier
    .fillMaxSize()
    .align(Alignment.Center),
            startAngle = circularRangeUI.circularRanges.initialAngle,
            endAngle=angle,
            strokeWidth = 5.dp,
            progress = progressValue,
            trackColor = Color.Red,
            indicatorColor = circularRangeUI.colorIndicater
        );
    }
}
@Preview()
@Composable
fun WearAppMain(){
    DinnerControlerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText();
            Spacer(modifier = Modifier.size(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary,
                text ="Balance"
            );
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                    text ="$500.000"
                )


                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Chip(label = { Text(text = "Gastos")}, onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.width(16.dp))
                    Chip(label = { Text(text = "Ingresos")}, onClick = { /*TODO*/ })
                }
        }
        }
    }

}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}