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
import org.intellij.lang.annotations.JdkConstants

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
    var ISR by remember { mutableStateOf(0.0) }
    var sueldoNeto by remember { mutableStateOf(0.0) }
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
                    val sueldoMensual = sueldo.toDouble()
                    var li = 0.0
                    var cf = 0.0
                    var tasa = 0.0

                    if (sueldoMensual <= 746.04) {
                        li = 0.01;
                        cf = 0.0;
                        tasa = 0.0192;
                    } else if (sueldoMensual <= 6332.05) {
                        li = 746.05
                        cf = 14.32
                        tasa = 0.0640
                    } else if (sueldoMensual <= 11128.01) {
                        li = 6332.06
                        cf = 371.83
                        tasa = 0.1088
                    } else if (sueldoMensual <= 12935.82) {
                        li = 11128.02
                        cf = 893.63
                        tasa = 0.1600
                    } else if (sueldoMensual <= 15487.71) {
                        li = 12935.83
                        cf = 1182.88
                        tasa = 0.1792
                    } else if (sueldoMensual <= 31236.49) {
                        li = 15487.72
                        cf = 1640.18
                        tasa = 0.2136
                    } else if (sueldoMensual <= 49233.00) {
                        li = 31236.50
                        cf = 5004.12
                        tasa = 0.2352
                    } else if (sueldoMensual <= 93993.90) {
                        li = 49233.01
                        cf = 9236.89
                        tasa = 0.3000
                    } else if (sueldoMensual <= 125325.20) {
                        li = 93993.91
                        cf = 22665.17
                        tasa = 0.3200
                    } else if (sueldoMensual <= 375975.61) {
                        li = 125325.21
                        cf = 32691.18
                        tasa = 0.3400
                    } else {
                        li = 375975.62
                        cf = 117912.32
                        tasa = 0.3500
                    }

                    ISR = ((sueldoMensual - li) * tasa) + cf
                    sueldoNeto = sueldoMensual - ISR

                }) {
                    Text("Calcular")
                }
            }

            Row(modifier = Modifier.padding(10.dp)) {
                Text("ISR")
            }

            Row(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    value = "$" + "%.4f".format(ISR),
                    onValueChange = { },
                    readOnly = true
                )
            }

            Row(modifier = Modifier.padding(10.dp)) {
                Text("SUELDO NETO")
            }

            Row(modifier = Modifier.padding(5.dp)) {
                OutlinedTextField(value = "$" + "%.4f".format(sueldoNeto),
                    onValueChange = { },
                    readOnly = true
                )
            }
    }
}

