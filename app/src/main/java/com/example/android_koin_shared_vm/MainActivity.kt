package com.example.android_koin_shared_vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_koin_shared_vm.ui.theme.AndroidkoinsharedvmTheme
import com.example.android_koin_shared_vm.util.Column
import com.example.android_koin_shared_vm.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidkoinsharedvmTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screenA") {
                    composable("screenA") {
                        val viewModel: MainViewModel = koinViewModel()
                        ScreenA(viewModel) {
                            navController.navigate("screenB")
                        }
                    }
                    composable("screenB") {
                        val viewModel: MainViewModel = koinViewModel()
                        ScreenB(viewModel) {
                            navController.navigate("screenA")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenA(viewModel: MainViewModel, onNavigate: () -> Unit) {
    Column {
        Text(text = "SCREEN A")
        Text(text = "MainViewModel.firstname = ${viewModel.firstName}")
        Button(onClick = {
            viewModel.updateName("ABC")
        }) {
            Text(text = "MainViewModel.firstname = ABC")
        }
        Button(onClick = onNavigate) {
            Text(text = "Go to SCREEN B")
        }
    }
}

@Composable
fun ScreenB(viewModel: MainViewModel, onNavigate: () -> Unit) {
    Column {
        Text(text = "SCREEN B")
        Text(text = "MainViewModel.firstname = ${viewModel.firstName}")
        Button(onClick = {
            viewModel.updateName("DEF")
        }) {
            Text(text = "MainViewModel.firstname = DEF")
        }
        Button(onClick = onNavigate) {
            Text(text = "Go to SCREEN A")
        }
    }
}

