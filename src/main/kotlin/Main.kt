package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(convertToRoundedString("88.50"))


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