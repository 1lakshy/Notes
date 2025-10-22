//package com.example.crudjetpackcompose
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.core.view.WindowCompat
//import androidx.navigation.compose.rememberNavController
//import com.example.crudjetpackcompose.Navigation.NotesNavigation
//import com.example.crudjetpackcompose.Screens.NotesScreen
//import com.example.crudjetpackcompose.Screens.SplashScreen
//import com.example.crudjetpackcompose.ui.theme.CrudJetPackComposeTheme
//import com.example.crudjetpackcompose.ui.theme.colorGrey
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        WindowCompat.setDecorFitsSystemWindows(window,false)
//        window.statusBarColor = android.graphics.Color.BLACK
//        window.navigationBarColor = android.graphics.Color.BLACK
//        setContent {
//            YourTheme{
//                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black){
//                    val navHostController = rememberNavController()
//                    NotesNavigation(navHostController)
//                }
//            }
//
//        }
//    }
//}

package com.example.crudjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.crudjetpackcompose.Navigation.NotesNavigation
import com.example.crudjetpackcompose.ui.theme.CrudJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Optional: keep black bars for status/navigation
        window.statusBarColor = android.graphics.Color.BLACK
        window.navigationBarColor = android.graphics.Color.BLACK

        setContent {
            CrudJetPackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navHostController = rememberNavController()
                    NotesNavigation(navHostController)
                }
            }
        }
    }
}

