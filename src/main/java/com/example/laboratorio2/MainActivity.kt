package com.example.laboratorio2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio2.ui.theme.Laboratorio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val numeros = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val promedio = calcularPromedio(numeros)
        Log.d("MainActivity", "El promedio es: $promedio")

        setContent {
            Laboratorio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


fun main() {
    val numeros = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val promedio = calcularPromedio(numeros)
    println("El promedio es: $promedio")
}

fun calcularPromedio(numeros: List<Double>): Double {
    val suma = numeros.reduce { acc, numero -> acc + numero }
    return suma / numeros.size
}

fun isPalindrome(cadena: String): Boolean {
    return cadena == cadena.reversed()
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
    Laboratorio2Theme {
        Greeting("Android")
    }
}



