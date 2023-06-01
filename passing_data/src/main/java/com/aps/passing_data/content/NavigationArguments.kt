package com.aps.passing_data.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationArgSample(){

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "screen1" ){
        composable("screen1"){
            Screen1 {
                navController.navigate("screen2/${it}")
            }
        }

        composable("screen2/{my_param}", arguments = listOf(
            navArgument("my_param"){
                type = NavType.StringType
            }
        )){
            val param = it.arguments?.getString("my_param") ?: ""
            Screen2(param = param)
        }
    }
}

@Composable
fun Screen1(onNavigateToScreen2: (String)->Unit){
    Box(modifier = Modifier.fillMaxSize()){
        Button(onClick = {onNavigateToScreen2("Hello World")}) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun Screen2(param:String){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = param)
    }
}