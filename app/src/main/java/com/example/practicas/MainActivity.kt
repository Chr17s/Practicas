package com.example.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
               Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                   Botones()
               }
            }
        }
    }
}

@Composable
fun Botones() {
    var sueldo by remember { mutableStateOf("") }
    var sueldoNeto by remember { mutableStateOf("") }
    var ISR by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 30.dp, 10.dp, 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Row(modifier = Modifier.padding(30.dp)){
                Image(
                    painter = painterResource(id = R.drawable.sat),
                    contentDescription = null
                )
            }
            Row(modifier = Modifier.padding(30.dp)) {
                Text("INGRESO MENSUAL")
            }

            Row(modifier = Modifier.padding(10.dp)) {
                TextField(
                    value = sueldo,
                    keyboardOptions =
                        KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { it ->
                        sueldo = it
                    }
                )
            }
            Row(modifier = Modifier.padding(30.dp)) {
                Button(onClick = {

                }) {
                    Text("Enviar")
                }
            }

            Row(modifier = Modifier.padding(10.dp)) {
                Text("ISR")
            }

            Row(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    value = ISR,
                    label = { Text("ISR") },
                    onValueChange = { ISR = it }
                )
            }

            Row(modifier = Modifier.padding(10.dp)) {
                Text("SUELDO NETO")
            }

            Row(modifier = Modifier.padding(5.dp)) {
                OutlinedTextField(
                    value = sueldoNeto,
                    label = { Text("Sueldo Neto") },
                    onValueChange = { sueldoNeto = it }
                )
            }
    }
}

