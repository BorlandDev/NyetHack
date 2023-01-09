fun main() {
    narrate(
        "A hero enters the town of Kronstadt. What is their name?",
        ::makeYellow
    )

    val heroName = readlnOrNull()
    require(!heroName.isNullOrEmpty()) {
        "The hero must have a name"
    }

    changeNarratorMood()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
}

private fun createTitle(name: String): String = when {
    name.all { it.isDigit() } -> "The Identifiable"
    name.none { it.isLetter() } -> "The Witness Protection Member"
    name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
    else -> "The Renowbed Hero"
}

private fun makeYellow(message: String): String = "\u001b[33;1m$message\u001b[0m"

