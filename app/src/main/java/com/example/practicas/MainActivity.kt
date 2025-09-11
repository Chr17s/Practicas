package com.example.practicas

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
    //variables para mostrar la operación y el resultado
    var operacion by remember{ mutableStateOf("") }
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
            text = resultado, fontSize = 50.sp,
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
                onClick = { operacion = ""; resultado = "0" },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "AC", fontSize = 45.sp, color = Color.Black)
            }
            OutlinedButton(
                onClick = { operacion = "/" },
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
                onClick = { operacion += "1" },
                modifier = Modifier.weight(1f)
            ) { Text("1", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "2" },
                modifier = Modifier.weight(1f)
            ) { Text("2", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "3" },
                modifier = Modifier.weight(1f)
            ) { Text("3", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "x" },
                modifier = Modifier.weight(1f)
            ) { Text("X", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { operacion += "4" },
                modifier = Modifier.weight(1f)
            ) { Text("4", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "5" },
                modifier = Modifier.weight(1f)
            ) { Text("5", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "6" },
                modifier = Modifier.weight(1f)
            ) { Text("6", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "-" },
                modifier = Modifier.weight(1f)
            ) { Text("-", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { operacion += "7" },
                modifier = Modifier.weight(1f)
            ) { Text("7", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "8" },
                modifier = Modifier.weight(1f)
            ) { Text("8", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "9" },
                modifier = Modifier.weight(1f)
            ) { Text("9", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "+" },
                modifier = Modifier.weight(1f)
            ) { Text("+", fontSize = 45.sp, color = Color.Black) }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { operacion += "." },
                modifier = Modifier.weight(1f)
            ) { Text(".", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(
                onClick = { operacion += "0" },
                modifier = Modifier.weight(1f)
            ) { Text("0", fontSize = 45.sp, color = Color.Black) }
            OutlinedButton(onClick = { resultado = "Resultado" }, modifier = Modifier.weight(2f)) {
                Text("=", fontSize = 45.sp, color = Color.Black)
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){

    }
}