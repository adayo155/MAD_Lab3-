package com.example.mad_lab3_

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mad_lab3_.ui.theme.MAD_Lab3Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAD_Lab3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lab3Task2()
                }
            }
        }
    }
}

@Composable
fun Lab3Task2(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "login"){
        composable("login"){
            LoginScreen(navController = navController) }
        composable("signup"){
            SignUpScreen(navController = navController) }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                context: Context = LocalContext.current,
                navController : NavHostController
){
    
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        
        TextField(value = "Email", onValueChange ={}, modifier=Modifier.padding(bottom=10.dp) )
        TextField(value = "Password", onValueChange ={}, modifier=Modifier.padding(bottom=20.dp) )
        
        Button(onClick = { }) {
            
            Text(text = "LOGIN")
        }
        TextButton(onClick  = {
            navController.navigate("signup")
        }) {
            Text(text = "Sign up")

        }
        
    }
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier,
                 context: Context = LocalContext.current,
                 navController : NavHostController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
        {
        TextField(value = "first name", onValueChange ={},  modifier=Modifier.padding(bottom=10.dp ))
            TextField(value = "last name", onValueChange ={},  modifier=Modifier.padding(bottom=10.dp ))
            TextField(value = "user name", onValueChange ={},  modifier=Modifier.padding(bottom=10.dp ))
            TextField(value = "password", onValueChange ={},  modifier=Modifier.padding(bottom=10.dp ))

            Button(onClick = {navController.navigate("login")}) {
                Text(text = "signUp")
            }
            TextButton(onClick = { navController.navigate("login") }) {
                Text(text = " Back to Login")

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
    MAD_Lab3Theme {
        Greeting("Android")
    }
}