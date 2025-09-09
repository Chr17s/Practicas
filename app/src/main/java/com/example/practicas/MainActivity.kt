package com.example.practicas

import android.R
import android.graphics.Paint
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Botones()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Botones() {
    val context = LocalContext.current
    /*var Nombre by remember { mutableStateOf("") }*/
    var ValorA by remember { mutableStateOf("") }
    var ValorB by remember { mutableStateOf("") }
    var Resultado by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        /*Row(modifier= Modifier.padding(10.dp)) {
            Text("Nombre",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            )
        }*/
        /*Row(modifier = Modifier.padding(10.dp)) {
            TextField(
                value = Nombre, onValueChange = { nuevoTexto -> Nombre = nuevoTexto} )
        }*/
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedTextField(
                value = ValorA,
                label = {Text("Primer Valor")},
                onValueChange = {ValorA = it}
            )
        }
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedTextField(
                value = ValorB,
                label = {Text("Segundo Valor")},
                onValueChange = {ValorB = it}
            )
        }
        Row (modifier = Modifier.padding(20.dp))
        {
            OutlinedButton(onClick = {
                val a = ValorA.toInt()
                val b = ValorB.toInt()
                val c = a+b
                Resultado = c.toString()
            }){
                Text(text = "Enviar")
            }
            OutlinedButton(onClick = {
                ValorB = ""
                ValorA = ""
                Resultado = ""
            }){
                Text(text = "Borrar")
            }
        }
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedTextField(
                value = Resultado,
                label = {Text("Resultado")},
                onValueChange = {Resultado = it}
            )
        }
    }
}