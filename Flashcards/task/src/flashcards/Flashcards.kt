package flashcards

class Flashcards {
    data class Card(val term: String, val definition: String) {
        fun check(): Boolean {
            val nextLine = scanner.nextLine()
            return term == nextLine
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