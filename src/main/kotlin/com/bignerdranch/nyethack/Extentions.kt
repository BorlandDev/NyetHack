package com.bignerdranch.nyethack

fun String.addEnthusiasm(enthusiasmLevel: Int = 1) = this + "!".repeat(enthusiasmLevel)

val String.numVowels
    get() = count { it.lowercase() in "aeiou" }

fun <T> T.print(): T {
    println(this)
    return this
}

infix fun Coordinate.move(direction: Direction) = direction.updateCoordinate(this)

fun Room?.orEmptyRoom(name: String = "the middle of nowhere"): Room = this ?: Room(name)