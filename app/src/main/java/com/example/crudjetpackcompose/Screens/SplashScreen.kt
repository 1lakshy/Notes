package com.example.crudjetpackcompose.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.crudjetpackcompose.ui.theme.colorBlack
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.crudjetpackcompose.Navigation.NotesNavigationItems
import com.example.crudjetpackcompose.R
import kotlinx.coroutines.delay


@Composable
@Preview

fun SplashScreen(navHostController: NavHostController){
    Scaffold { innerPadding->
        Box(modifier= Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(colorBlack)){
            Image(painterResource(id= R.drawable.logo), contentDescription = "logo",
                modifier = Modifier.size(150.dp).align(Alignment.Center)
             )
        }

    }


    LaunchedEffect(Unit) {
        delay(2500)
        navHostController.navigate(NotesNavigationItems.HomeScreen.route){
            popUpTo(NotesNavigationItems.SplashScreen.route){
             inclusive=true
            }
        }
    }
}


