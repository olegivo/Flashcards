package flashcards

import java.util.*

fun main() {
    val flashcards = Flashcards()
    loop@ while (scanner.hasNextLine()) {
        println("Input the action (add, remove, import, export, ask, exit):")
        val command = scanner.nextLine()
        when (command) {
            "add" -> flashcards.add()
            "remove" -> flashcards.remove()
            "ask" -> flashcards.ask()
            "export" -> flashcards.export()
            "import" -> flashcards.import()
            "exit" -> {
                println("Bye bye!")
                break@loop
            }
        }
    }
}

val scanner = Scanner(System.`in`)