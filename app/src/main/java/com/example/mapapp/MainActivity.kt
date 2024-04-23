package com.example.mapapp

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.mapapp.ui.theme.MapAppTheme
import kotlinx.coroutines.delay
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController as rememberNavController

class MainActivity : ComponentActivity() {
    @Composable
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigationController = rememberNavController()

        setContent {
            MapAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Splash.route
                    ) {
                        composable(Routes.Splash.route) { SplashScreen(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                    }
                }
            }
        }
    }
}



}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapAppTheme {
        Greeting("Android")
    }
}

@SuppressLint("ResourceType")
@Composable
fun Splash(alphaAnim: Float) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.raw.launch),
            contentDescription = "logo", alpha = alphaAnim
        )
        Text(text = "Welcome!", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Routes.Pantalla2.route)
    }
    Splash(alphaAnim.value)
}

