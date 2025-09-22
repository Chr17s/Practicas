package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicas.view.AFCView
import com.example.practicas.view.BillsView
import com.example.practicas.view.ChargersView
import com.example.practicas.view.EaglesView
import com.example.practicas.view.HomeView
import com.example.practicas.view.NFCView
import com.example.practicas.view.RamsView
import com.example.practicas.view.RavensView
import com.example.practicas.view.SaintsView
import com.example.practicas.view.TexansView
import com.example.practicas.view.VikingsView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home")
    {
        composable ("Home"){
            HomeView(navController)
        }
        composable ("AFC"){
            AFCView(navController)
        }
        composable ("NFC"){
            NFCView(navController)
        }
        composable ("NFC"){
            NFCView(navController)
        }
        composable ("Bills"){
            BillsView(navController)
        }
        composable ("Chargers"){
            ChargersView(navController)
        }
        composable ("Eagles"){
            EaglesView(navController)
        }
        composable ("Rams"){
            RamsView(navController)
        }
        composable ("Ravens"){
           RavensView(navController)
        }
        composable ("Saints"){
            SaintsView(navController)
        }
        composable ("Texans"){
            TexansView(navController)
        }
        composable ("Vikings"){
            VikingsView(navController)
        }
    }
}