package org.jyx


fun main() {

    // vs nullable readLine()
    val input = readln() // since we are sure it is not null we can invoke split on it

    if (input.isEmpty()) return



    val converted = when(input.lowercase()) {
        "distance", "distances" -> runDistanceConverter()
        "weight", "weights" -> runMassConverter()
        else -> throw IllegalArgumentException("Unknown Converter Type $input")
    }


}

fun runMassConverter() {
    println("Enter value, source unit, and target unit (e.g., 10 kg lb):")
    val input = readln().split(" ")
    if (input.size != 3) {
        println("Invalid input. Please provide value, source unit, and target unit.")
        return
    }
    val value = input[0].toDouble()
    val fromUnit = input[1].lowercase()
    val toUnit = input[2].lowercase()

    val grams = when (fromUnit) {
        "kg", "kilogram", "kilograms" -> value * 1000
        "g", "gram", "grams" -> value
        "lb", "pound", "pounds" -> value * 453.592
        "oz", "ounce", "ounces" -> value * 28.3495
        else -> {
            println("Unknown source unit: $fromUnit")
            return
        }
    }

    val converted = when (toUnit) {
        "kg", "kilogram", "kilograms" -> grams / 1000
        "g", "gram", "grams" -> grams
        "lb", "pound", "pounds" -> grams / 453.592
        "oz", "ounce", "ounces" -> grams / 28.3495
        else -> {
            println("Unknown target unit: $toUnit")
            return
        }
    }

    println("$value $fromUnit is $converted $toUnit")
}



fun runDistanceConverter() {
    println("Enter value, source unit, and target unit (e.g., 10 miles kilometers):")
    val input = readln().split(" ")
    if (input.size != 3) {
        println("Invalid input. Please provide value, source unit, and target unit.")
        return
    }
    val value = input[0].toDouble()
    val fromUnit = input[1].lowercase()
    val toUnit = input[2].lowercase()

    val meters = when (fromUnit) {
        "yard", "yards" -> value * 0.9144
        "mile", "miles" -> value * 1609.34
        "kilometer", "kilometers" -> value * 1000
        "meter", "meters" -> value
        else -> {
            println("Unknown source unit: $fromUnit")
            return
        }
    }

    val converted = when (toUnit) {
        "yard", "yards" -> meters / 0.9144
        "mile", "miles" -> meters / 1609.34
        "kilometer", "kilometers" -> meters / 1000
        "meter", "meters" -> meters
        else -> {
            println("Unknown target unit: $toUnit")
            return
        }
    }

    println("$value $fromUnit is $converted $toUnit")
}