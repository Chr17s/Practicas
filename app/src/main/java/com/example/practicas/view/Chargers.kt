package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.R
import com.example.practicas.components.MainButton
import com.example.practicas.components.MainIconButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChargersView(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar("CHARGERS") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFFFFBA09)
            ), navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.navigate("AFC")                }
            }
        )
    }
    ){
        ContentChargersView()
    }
}

@Composable
fun ContentChargersView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.estadio_chargers),
            contentDescription = "Chargers",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text("Los Angeles Chargers",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Los Chargers comenzaron en 1960 en Los Ángeles, " +
                    "pero pronto se mudaron a San Diego, donde jugaron por varias décadas antes de regresar" +
                    " a L.A. en 2017. Actualmente comparten el moderno SoFi Stadium con los Rams. Sus colores " +
                    "característicos son el azul cielo y dorado, lo que los hace fácilmente reconocibles. " +
                    "Aunque han tenido grandes jugadores como Dan Fouts, LaDainian Tomlinson y ahora Justin Herbert, " +
                    "el equipo nunca ha ganado un Super Bowl; su logro más grande fue el título de la AFL en 1963 y " +
                    "llegar al Super Bowl XXIX en 1995, donde fueron derrotados.",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}