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
fun BillsView(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar("BILLS") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF203B75)
            ), navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.navigate("AFC")
                }
            }
        )
    }
    ){
        ContentBillsView()
    }
}

@Composable
fun ContentBillsView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.estadio_bills),
            contentDescription = "Bills",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text("Buffalo Bills",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Los Buffalo Bills son un equipo con sede en Buffalo, Nueva York, " +
                    "y juegan en la división Este de la AFC. Fueron fundados en 1960 como parte de la AFL " +
                    "y se unieron a la NFL en 1970 tras la fusión. Disputan sus partidos en el Highmark Stadium " +
                    "y sus colores tradicionales son el azul, rojo y blanco. Su momento más recordado fue a inicios " +
                    "de los años 90, cuando lograron llegar a cuatro Super Bowls consecutivos (XXV-XXVIII), " +
                    "aunque perdieron en todos ellos. En los últimos años han vuelto a ser protagonistas con Josh Allen " +
                    "como quarterback estrella.",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}