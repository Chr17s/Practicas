package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
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
fun NFCView(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar("Conferencia Nacional") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.DarkGray
            ), navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.navigate("Home")                }
            }
        )
    }
    ){innerPadding ->
        Box(Modifier.padding(innerPadding).padding(top = 10.dp)) {
            NFCDetailView(navController)
        }
    }
}

@Composable
fun NFCDetailView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Eagles
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF024C53))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Division Este",
                        fontSize = 25.sp,
                        color = Color.White)
                    Spacer(Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logoeaglessf),
                        contentDescription = "Philadelphia Eagles",
                        modifier = Modifier.size(96.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    MainButton(
                        name = "Philadelphia Eagles",
                        backcolor = Color(0xFF024C53),
                        color = Color.White
                    ) {
                        navController.navigate("SplashEagles")
                    }
                }
            }

            // Vikings
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF502F84))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Division Norte",
                        fontSize = 23.sp,
                        color = Color.White)
                    Spacer(Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logovikingssf),
                        contentDescription = "Minnesota Vikings",
                        modifier = Modifier.size(96.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    MainButton(
                        name = "Minnesota Vikings",
                        backcolor = Color(0xFF502F84),
                        color = Color.White
                    ) {
                        navController.navigate("SplashVikings")
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Saints
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFD3BD8C))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Division Sur",
                        fontSize = 25.sp,
                        color = Color.White)
                    Spacer(Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logosaintssf),
                        contentDescription = "New Orleans Saints",
                        modifier = Modifier.size(130.dp)
                    )
                    Spacer(Modifier.height(9.dp))
                    MainButton(
                        name = "New Orleans Saints",
                        backcolor = Color(0xFFD3BD8C),
                        color = Color.White
                    ) {
                        navController.navigate("SplashSaints")
                    }
                }
            }

            // Rams
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF003593))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Division Oeste",
                        fontSize = 23.sp,
                        color = Color.White)
                    Spacer(Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ramslogosf),
                        contentDescription = "Los Angeles Rams",
                        modifier = Modifier.size(96.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    MainButton(
                        name = "Los Angeles Rams",
                        backcolor = Color(0xFF003593),
                        color = Color.White
                    ) {
                        navController.navigate("SplashRams")
                    }
                }
            }
        }
    }
}
