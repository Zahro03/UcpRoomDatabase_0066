package com.example.ucp2pam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier =  Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route) {
        composable(
            route = DestinasiHome.route
        ){
            HomeBrgView(
                onDetailClick = { id ->
                    navController.navigate("${DestinasiDetail.route}/$id")
                    println(
                        "PengelolaHalaman: id = $id"
                    )
                },
                onAddBrg = {
                    navController.navigate(DestinasiUpdate.route)
                },
                modifier = modifier
            )
        }

        composable(
            DestinasiUpdate.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.ID) {
                    type = NavType.StringType
                }
            )
        ) {
            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
        }
    }
}