package flashcards

import java.util.*

fun main() {
    val check = if (Flashcards.Card.readFromInput().check()) "right" else "wrong"
    println("Your answer is $check!")
}

val scanner = Scanner(System.`in`)