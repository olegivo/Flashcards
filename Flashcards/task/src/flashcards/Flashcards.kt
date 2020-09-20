package flashcards

import java.io.File
import java.util.*

class Flashcards {

    private val cards = mutableListOf<Card>()

    fun add() {
        println("The card:")
        val term = scanner.nextLine()
        if (hasTerm(term)) {
            println("The card \"$term\" already exists.")
            return
        }
        println("The definition of the card:")
        val definition: String = scanner.nextLine()
        if (hasDefinition(definition)) {
            println("The definition \"$definition\" already exists.")
            return
        }
        cards.add(Card(term = term, definition = definition))
        println("The pair (\"$term\":\"$definition\") has been added.")
    }

    fun remove() {
        println("The card:")
        val term = scanner.nextLine()
        cards.firstOrNull { it.term == term }
                ?.let {
                    cards.remove(it)
                    println("The card has been removed.")
                }
                ?: run {
                    println("Can't remove \"$term\": there is no such card.")
                }
    }

    fun ask() {
        println("How many times to ask?")
        repeat(scanner.nextLine().toInt()) {
            val card = cards.random()
            println("Print the definition of \"${card.term}\":")
            val nextLine = scanner.nextLine()
            if (card.definition == nextLine) {
                println("Correct!")
            } else {
                print("Wrong. The right answer is \"${card.definition}\"")
                println(cards.firstOrNull { it.definition == nextLine }
                        ?.let { ", but your definition is correct for \"${it.term}\"." }
                        ?: "."
                )
            }
        }
    }

    fun export() {
        println("File name::")
        val filename = scanner.nextLine()
        val file = File(filename)
        file.writeText(buildString {
            appendLine(cards.size)
            cards.forEach {
                appendLine(it.term)
                appendLine(it.definition)
            }
        })
//        file.copyTo(File("${Date().time}_exported_$filename"))
        println("${cards.size} cards have been saved.")
    }

    fun import() {
        println("File name::")
        val filename = scanner.nextLine()
        val file = File(filename)
        if (!file.exists()) {
            println("File not found.")
            return
        }
//        file.copyTo(File("${Date().time}_imported_$filename"))
        val lines = file.readLines()
        var pos = 1
        val n = lines.first().toInt()
        repeat(n) {
            val card = Card(lines[pos++], lines[pos++])
            val existIndex = cards.indexOfFirst { it.term == card.term }
            if (existIndex >= 0) {
                cards[existIndex] = card
            } else {
                cards.add(card)
            }
        }
        println("$n cards have been loaded.")
    }

    private fun hasDefinition(definition: String) = cards.any { card -> card.definition == definition }
    private fun hasTerm(term: String) = cards.any { card -> card.term == term }

    data class Card(val term: String, val definition: String)
}