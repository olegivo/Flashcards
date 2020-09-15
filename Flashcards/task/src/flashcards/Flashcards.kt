package flashcards

class Flashcards {

    private val cards = mutableListOf<Card>()

    fun readFromInput() {
        println("Input the number of cards:")
        (1..scanner.nextLine().toInt()).forEach {
            println("The card #$it:")
            val term = inputTerm()
            println("The definition of the card #$it:")
            val definition: String = inputDefinition()
            cards.add(Card(term = term, definition = definition))
        }
    }

    fun checkDefinitions() {
        cards.forEach { card ->
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

    private fun inputDefinition(): String {
        var definition: String
        do {
            definition = scanner.nextLine()
            if (cards.any { card -> card.definition == definition }) {
                println("The definition \"$definition\" already exists. Try again:")
            } else {
                break
            }
        } while (true)
        return definition
    }

    private fun inputTerm(): String {
        var term: String
        do {
            term = scanner.nextLine()
            if (cards.any { card -> card.term == term }) {
                println("The card \"$term\" already exists. Try again:")
            } else {
                break
            }
        } while (true)
        return term
    }

    data class Card(val term: String, val definition: String)
}