package com.example.baitaptuan4_th02

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.baitaptuan4_th02.viewModel.TaskIDViewModel
import com.example.baitaptuan4_th02.viewModel.TaskViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navItems = listOf(
        "home" to Icons.Default.Home,
        "calendar" to Icons.Default.DateRange,
        "email" to Icons.Default.Email,
        "settings" to Icons.Default.Settings
    )

    var selectedItem by remember { mutableStateOf("home") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController, navItems, selectedItem) { selectedItem = it }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
//                    selectedItem = "add"
//                    navController.navigate("add")
                },
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier.offset(y = 50.dp).size(70.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add", Modifier.size(40.dp))
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        NavigationHost(navController, Modifier.padding(innerPadding))
    }
}

@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "task", modifier = modifier) {
        composable("task") {
            val viewModel: TaskViewModel = viewModel()
            PostScreen(viewModel, navController)
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull() ?: 0
            Detail(taskId = taskId, viewModel = TaskIDViewModel(taskId), navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Pair<String, ImageVector>>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar {
        items.forEach { (route, icon) ->
            NavigationBarItem(
                selected = selectedItem == route,
                onClick = {
//                    onItemSelected(route)
//                    navController.navigate(route)
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = route,
                        tint = if (selectedItem == route) Color(0xFF2196F3) else Color.Gray
                    )
                }
            )
        }
    }
}