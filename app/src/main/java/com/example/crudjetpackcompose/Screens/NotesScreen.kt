package com.example.crudjetpackcompose.Screens

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crudjetpackcompose.Models.Notes
import com.example.crudjetpackcompose.ui.theme.colorBlack
import com.example.crudjetpackcompose.ui.theme.colorGrey
import com.example.crudjetpackcompose.ui.theme.colorLightGrey
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.example.crudjetpackcompose.Navigation.NotesNavigation
import com.example.crudjetpackcompose.Navigation.NotesNavigationItems
import com.example.crudjetpackcompose.ui.theme.colorRed
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


@Composable
@Preview
fun NotesScreen(navHostController: NavHostController) {

    val db = FirebaseFirestore.getInstance()
    val notesDBRef = db.collection("notes")
    val notesList = remember {
        mutableStateListOf<Notes>()
    }

    val loading = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        notesDBRef.addSnapshotListener { value, error ->
            if (error==null){
                val data = value?.toObjects(Notes::class.java)
                notesList.clear()
                notesList.addAll(data!!)
                loading.value = true
            }else{
                loading.value = false
            }
        }
    }
//    val notesList = listOf(
//        Notes("Shopping List", "Buy milk, eggs, and bread"),
//        Notes("Workout Plan", "Morning run at 6 AM and gym at 7 PM"),
//        Notes("Project Ideas", "Build a weather app using Jetpack Compose"),
//        Notes("Meeting Notes", "Discuss UI updates with the design team"),
//        Notes("Learning Goals", "Finish Kotlin coroutines tutorial"),
//        Notes("Weekend Plans", "Movie night and hiking with friends")
//    )

    Scaffold(floatingActionButton = {
        FloatingActionButton(contentColor = Color.White, containerColor = colorRed,onClick = {
            navHostController.navigate(NotesNavigationItems.InsertNotesScreen.route+"/defaultId")
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    },
            modifier = Modifier
            .fillMaxSize() // ✅ Let the content go behind system bars (status bar, nav bar)
        .background(colorBlack),
//        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ){
        innerPadding->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(colorBlack)){

            Column (modifier = Modifier.padding(15.dp)){
                Text(text="Create Tasks Notes", style = TextStyle(fontSize = 32.sp,
                    color= Color.White, fontWeight = FontWeight.Black
                ))


                if(loading.value){
                    LazyColumn {
                        items(notesList ) {notes->
                            ListItems(notes,notesDBRef,navHostController)
                        }
                    }

                }else{

                    Box(modifier = Modifier.fillMaxSize()){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

            }
        }
    }
}



@Composable
fun ListItems(
    notes: Notes, notesDBRef: CollectionReference,navHostController: NavHostController
){
    val context = LocalContext.current

    var expanded by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 10.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(15.dp)))
        .background(color = colorGrey)
    ){

        DropdownMenu(modifier = Modifier.background(Color.White),
            properties = PopupProperties(clippingEnabled = true),
            offset = DpOffset(x=(-40).dp ,y=0.dp),
            expanded = expanded ,
            onDismissRequest={expanded=false}) {
            DropdownMenuItem(text = {Text(text="Update", style = TextStyle(colorGrey))}, onClick = {
            navHostController.navigate(NotesNavigationItems.InsertNotesScreen.route+"/${notes.id}")
                expanded=false

            })
            DropdownMenuItem(text ={Text(text="Delete", style = TextStyle(colorGrey))} , onClick = {

                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setMessage("Are you sure?")
                alertDialog.setPositiveButton("yes"){
                    dialog,which->
                    notesDBRef.document(notes.id).delete()
                    dialog?.dismiss()
                    expanded = false
                }

                alertDialog.setNegativeButton("no"){
                    dialog,which->
                    dialog?.dismiss()
                    expanded = false
                }
                alertDialog.show()
            })
        }

        Icon(imageVector = Icons.Default.MoreVert,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .clickable {
                    expanded = true
                }
        )

        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = notes.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = notes.description,
                style = TextStyle(
                    color = colorLightGrey,
                    fontSize = 15.sp
                )
            )
        }

}}