package com.hanuszczak.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent() {
    val celsius = remember { mutableStateOf(0) }
    val newCelsius = remember { mutableStateOf("") }

    Column {
        Header(
            image = R.drawable.temperature,
            description = "temperature converter image"
        )
        EnterTemperature(
            temperature = newCelsius.value,
            changed = { newCelsius.value = it }
        )
        ConvertButton {
            newCelsius.value.toIntOrNull()?.let {
                celsius.value = it
            }
        }
        TemperatureText(
            celsius.value
        )
    }
}

@Composable
fun EnterTemperature(temperature: String, changed: (String) -> Unit) {
    TextField(
        value = temperature,
        label = {
            Text(text = "Enter temperature in Celsius")
        },
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text(text = "Convert")
    }
}

@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun TemperatureText(celsius: Int) {
    val fahrenheit = (celsius.toDouble() * 9/5) + 32
    Text(text = "$celsius Celsius is $fahrenheit Fahrenheit")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()
}