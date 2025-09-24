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
fun RavensView(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar("RAVENS") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF4D38E8)
            ), navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.navigate("AFC")                }
            }
        )
    }
    ){
        ContentRavensView()
    }
}

@Composable
fun ContentRavensView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.estadio_ravens),
            contentDescription = "Ravens",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text("Baltimore Ravens",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Los Ravens nacieron en 1996 cuando la franquicia de los " +
                    "Browns se trasladó a Baltimore, aunque mantuvieron un nombre " +
                    "e identidad completamente nuevos. Juegan en el M&T Bank Stadium" +
                    " con los colores púrpura, negro y dorado metálico. Desde sus inicios " +
                    "se caracterizaron por defensas dominantes, con figuras como Ray Lewis " +
                    "y Ed Reed. Ganaron dos Super Bowls: el XXXV en 2001 y el XLVII en 2013, " +
                    "este último con Joe Flacco como MVP y venciendo a los 49ers en la llamada " +
                    "Harbaugh Bowl (porque los entrenadores eran hermanos). Actualmente tienen a " +
                    "Lamar Jackson, uno de los quarterbacks más dinámicos de la liga.",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}