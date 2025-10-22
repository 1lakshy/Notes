package com.example.crudjetpackcompose.Navigation

sealed class NotesNavigationItems(val route:String) {
    object SplashScreen : NotesNavigationItems(route = "splash")
    object HomeScreen : NotesNavigationItems(route = "home")
    object InsertNotesScreen : NotesNavigationItems(route = "insert")


}