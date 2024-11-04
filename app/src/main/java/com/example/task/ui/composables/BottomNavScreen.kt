package com.example.task.ui.composables

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.data.model.BottomNavData
import com.example.task.ui.theme.Purple80
import com.example.task.ui.theme.primary_color

@Composable
fun BottomScreen(){

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNav() {


    var Tab = 0
    var selectTab by remember { mutableStateOf(Tab) }


    val items = listOf(
        BottomNavData("Home",0, "home", Icons.Default.Home),
        BottomNavData("Connecter", 1,"search", Icons.Default.),
        BottomNavData("Questions", 2,"favorites", Icons.Default.),
        BottomNavData("Tools", 3,"profile", Icons.Default.Pers),
        BottomNavData("Profile", 4,"settings", Icons.Default.p)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    
                    NavigationBarItem(selected = selectTab==item.Tab, onClick = { selectTab=item.Tab }, icon = {
                        if (selectTab==item.Tab){
                            Icon(imageVector = item.icon, contentDescription = item.label, tint = primary_color)
                        } else{
                            Icon(imageVector = item.icon, contentDescription = item.label,tint=Purple80)
                        }

                       }, label = {item.label})

                }
            }
        }
    ) {
        when (selectTab) {
            0 -> {
                Home()
            }

            1 -> {
               Connecter()
            }

            2 -> {
                Questions()
            }

            3 -> {
                Tools()
            }

            4 -> {
                Profile()
            }
        }



    }





}