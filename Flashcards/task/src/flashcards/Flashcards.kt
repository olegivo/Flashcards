package flashcards

class Flashcards private constructor(private val cards: List<Card>) {

    fun checkDefinitions() {
        cards.forEach {
            val message = if (it.checkDefinition()) {
                "Correct!"
            } else {
                "Wrong. The right answer is \"${it.definition}\"."
            }
            println(message)
        }
    }

    companion object {
        fun create(): Flashcards {
            println("Input the number of cards:")
            val cards = (1..scanner.nextLine().toInt()).map {
                println("The card #$it:")
                val term = scanner.nextLine()
                println("The definition of the card #$it:")
                val definition = scanner.nextLine()
                Card(term = term, definition = definition)
            }
            return Flashcards(cards)
        }
    }

    data class Card(val term: String, val definition: String) {
        fun check(): Boolean {
            val nextLine = scanner.nextLine()
            return term == nextLine
        }

        fun checkDefinition(): Boolean {
            println("Print the definition of \"$term\":")
            val nextLine = scanner.nextLine()
            return definition == nextLine
        }

        companion object {
            fun readFromInput(): Card {
                val definition = scanner.nextLine()
                val term = scanner.nextLine()
                return Card(
                        term = term,
                        definition = definition
                )
            }
        }
    }
}