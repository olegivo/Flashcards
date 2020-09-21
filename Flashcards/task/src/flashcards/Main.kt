package flashcards

fun main() {
    val flashcards = Flashcards()
    loop@ while (scanner.hasNextLine()) {
        println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
        val command = scanner.nextLine()
        when (command) {
            "add" -> flashcards.add()
            "remove" -> flashcards.remove()
            "ask" -> flashcards.ask()
            "export" -> flashcards.export()
            "import" -> flashcards.import()
            "log" -> flashcards.log()
            "hardest card" -> flashcards.hardestCard()
            "reset stats" -> flashcards.resetStats()
            "exit" -> {
                println("Bye bye!")
                break@loop
            }
        }
    }
}
