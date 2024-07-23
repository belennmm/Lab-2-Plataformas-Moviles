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
    // el promedio
    val numbersD = listOf(4.2, 2.2, 4.2, 2.2)
    val promedio = calcularPromedio(numbersD)
    println("• El promedio es: $promedio")
    
    // filtrar impares
    val numbersImp = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val impares = numbersImp.filter { it % 2 != 0 }
    println("\n◘ Los números impares son: $impares")

    // si es palindrome
    val cadenas = listOf("solos", "holis", "level", "belen", "madam")
    println("\n\n Palíndromos:")
    cadenas.forEach { cadena ->
        val esPalindromo = isPalindrome(cadena)
        println("\"$cadena\" es un palíndromo?: $esPalindromo")
    }
    
    // saludo
    print("\n")
    val names = listOf("Alicia", "Belen", "Bran", "Adrian")
    val saludos = names.map { names -> "¡Hola, $names!" }
    saludos.forEach { saludo ->
        println(saludo)
    }
    
    //lambda
    val multiplicacion = performOperation(5, 3) { a, b -> a * b }
    println("\nMultiplicación: $multiplicacion")
    
    //map
    val persons = listOf(
        Person("Alicia", 11, "#1", "A1"),
        Person("Bernardo", 22, "#2", "B2"),
        Person("Carlos", 33, "#3", "C2"),
        Person("Norris", 44, "#4", "D2")
        
    )
    
    
    // Person a Student
    val students = persons.map { person -> personToStudent(person) }

    // info de los students
    print("\n")
    students.forEach { student ->
        println("El Estudiante ${student.name} con ID ${student.studentId} tiene ${student.age} años")
    }
}

// promedio
fun calcularPromedio(numeros: List<Double>): Double {
    val suma = numeros.reduce { acc, numero -> acc + numero }
    return suma / numeros.size
}

// la compacta de isplindrome
fun isPalindrome(cadena: String): Boolean {
    return cadena == cadena.reversed()
}

// multiplicar
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// data classes
data class Person(val name: String, val age: Int, val gender: String, val personId: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)




//
fun personToStudent(person: Person): Student {
    return Student(person.name, person.age, person.gender, generateStudentId(person))
}

//

fun generateStudentId(person: Person): String {
    return "${person.personId}"
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



