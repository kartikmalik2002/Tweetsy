package com.example.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.api.TweetsyApi
import com.example.tweetsy.screens.CategoryScreen
import com.example.tweetsy.screens.DetailScreen
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            TweetsyTheme {
                Scaffold (
                        topBar = {
                            TopAppBar(title = { Text(text = "Tweetsy") })
                        }
                    
                    ){

                    Box(
                        modifier = Modifier.padding(it),
                    ){
                        App()
                    }
                }

            }
        }
    }
}

@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {

        composable(route = "category"){
            CategoryScreen{
                navController.navigate(route = "detail/${it}")
            }
        }

        composable(route = "detail/{category}" , arguments = listOf(
            navArgument("category"){
                type = NavType.StringType
            }
        )){
            DetailScreen()
        }
    }

}

