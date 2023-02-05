package com.bignerdranch.nyethack

lateinit var player: Player

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    changeNarratorMood()

    Game.play()
}

private fun promptHeroName(): String {
    narrate(
        "A hero enters the town of Kronstadt. What is their name?",
        ::makeYellow
    )

    val input = readlnOrNull()
    require(!input.isNullOrEmpty()) {
        "The hero must have a name"
    }
    return input
}

private fun makeYellow(message: String): String = "\u001b[33;1m$message\u001b[0m"
