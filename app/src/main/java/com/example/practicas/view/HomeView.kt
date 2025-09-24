package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R
import com.example.practicas.components.ActionButton
import com.example.practicas.components.MainButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("NFL") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray
                )
            )
        }
    ) { innerPadding ->
        // Fondo partido
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Capa de fondo
            Column(Modifier.fillMaxSize()) {
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.Red)
                ) {
                    // Fondo partido
                    Column(Modifier.fillMaxSize()) {
                        // Mitad roja
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(Color.Red),
                            contentAlignment = Alignment.Center
                        ) {
                            Column (horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Image(
                                    painter = painterResource(id = R.drawable.americana_sin_fondo),
                                    contentDescription = "AFC"
                                )
                                Space(espacio = 10)
                                MainButton(
                                    name = "Conferencia Americana",
                                    backcolor = Color.Red,
                                    color = Color.White
                                ) { navController.navigate("AFC") }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center
                        ) {
                            Column (horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Image(
                                    painter = painterResource(id = R.drawable.nacional_sin_fondo),
                                    contentDescription = "AFC"
                                )
                                Space(espacio = 10)
                                MainButton(
                                    name = "Conferencia Nacional",
                                    backcolor = Color.Blue,
                                    color = Color.White,
                                ) { navController.navigate("NFC") }
                            }
                        }
                    }
                }
            }
        }
    }
}


