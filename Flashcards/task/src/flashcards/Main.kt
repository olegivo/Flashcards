package flashcards

import java.util.*

fun main() {
    val flashcards = Flashcards()
    flashcards.readFromInput()
    flashcards.checkDefinitions()
}

val scanner = Scanner(System.`in`)