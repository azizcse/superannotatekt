package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.concurrent.thread

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking {
    // Create a MutableSharedFlow that emits Int values
    val sharedFlow = MutableSharedFlow<Int>()

    // Collector 1
    launch {
        sharedFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    // Collector 2
    launch {
        sharedFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    // Emit some values from another coroutine
    launch {
        repeat(3) {
            delay(500)
            println("Emitting: $it")
            sharedFlow.emit(it)
        }
    }

    delay(3000) // Give enough time for everything to run
}
fun convertToRoundedString(value: String): String {
    return try {
        val doubleValue = value.toDouble() // Convert the string to a Double
        val roundedValue = kotlin.math.ceil(doubleValue) // Round the value to the nearest whole number
        "%.2f".format(roundedValue) // Format the rounded value to 2 decimal places
    } catch (e: NumberFormatException) {
        "Invalid input" // Handle cases where the input is not a valid number
    }
}