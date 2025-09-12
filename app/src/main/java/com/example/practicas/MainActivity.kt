package com.example.practicas

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculadora()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Calculadora() {
    //Variables para guardar los numeros de la operacion
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    //variables para mostrar la operación y el resultado
    var operador by remember{ mutableStateOf<Int?>(null) }
    var operacion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        //TEXTO QUE MUESTRA EL RESULTADO
        Text(
            text = if (resultado.isNotEmpty()) resultado else num2.ifEmpty { num1 },
            fontSize = 50.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            textAlign = TextAlign.End
        )
        //TEXTO QUE MUESTRA LA OPERACION
        Text(
            text = operacion,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            textAlign = TextAlign.End
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { num1 = ""
                    num2 = ""
                    operador = null
                    resultado = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "AC", fontSize = 45.sp, color = Color.Black)
            }
            OutlinedButton(
                onClick = { operador = 4
                    num1 = num2
                    num2 = ""
                    operacion += "/"},
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "/", fontSize = 45.sp)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { num2 += "1"
                            operacion +=1 },
                modifier = Modifier.weight(1f)
            ) { Text("1", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "2"
                            operacion +=2 },
                modifier = Modifier.weight(1f)
            ) { Text("2", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "3"
                            operacion += 3 },
                modifier = Modifier.weight(1f)
            ) { Text("3", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operador = 3
                    num1 = num2
                    num2 = ""
                    operacion += "x"},
                modifier = Modifier.weight(1f)
            ) { Text("X", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { num2 += "4"
                            operacion +=4 },
                modifier = Modifier.weight(1f)
            ) { Text("4", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "5"
                            operacion +=5 },
                modifier = Modifier.weight(1f)
            ) { Text("5", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "6"
                            operacion +=6 },
                modifier = Modifier.weight(1f)
            ) { Text("6", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operador = 2
                    num1 = num2
                    num2 = ""
                    operacion += "-"},
                modifier = Modifier.weight(1f)
            ) { Text("-", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { num2 += "7"
                            operacion +=7 },
                modifier = Modifier.weight(1f)
            ) { Text("7", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "8"
                            operacion +=8 },
                modifier = Modifier.weight(1f)
            ) { Text("8", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { num2 += "9"
                            operacion +=9 },
                modifier = Modifier.weight(1f)
            ) { Text("9", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operador = 1
                    num1 = num2
                    num2 = ""
                    operacion += "+"},
                modifier = Modifier.weight(1f)
            ) { Text("+", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Punto decimal
            OutlinedButton(
                onClick = {
                    if (!num2.contains(".")) {   // evita múltiples puntos
                        num2 = if (num2.isEmpty())
                        "0." else num2 + "."
                        operacion += "."
                    }
                },
                modifier = Modifier.weight(1f)
            ) { Text(".", fontSize = 45.sp, color = Color.Black) }

            // 0
            OutlinedButton(
                onClick = { num2 += "0" },
                modifier = Modifier.weight(1f)
            ) { Text("0", fontSize = 45.sp, color = Color.Black) }

            // =
            Button(
                onClick = {
                    val n1 = num1.toDoubleOrNull() ?: 0.0
                    val n2 = num2.toDoubleOrNull() ?: 0.0
                    val respuesta = when (operador) {
                        1 -> n1 + n2
                        2 -> n1 - n2
                        3 -> n1 * n2
                        4 -> if (n2 != 0.0) n1 / n2 else Double.NaN //Not A Number
                        else -> n2
                    }

                    //limitarlo a 4 decimales
                    val decimales = DecimalFormat("#.####")
                    resultado = decimales.format(respuesta)
                    operacion = ""
                    num1 = ""
                    num2 = ""
                    operador = null
                },
                modifier = Modifier.weight(2f)
            ) { Text("=", fontSize = 45.sp, color = Color.Black) }
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){

    }
}
}