package flashcards

fun main(args: Array<String>) {
    val import = "-import"
    val export = "-export"
    val commands = arrayOf(import, export)
    val paramByCommand = args.mapIndexed { index, s -> index to s }
            .filter { commands.contains(it.second) }
            .associate { it.second to args[it.first + 1] }

    val flashcards = Flashcards()
    paramByCommand[import]?.let { flashcards.import(it) }
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
                paramByCommand[export]?.let { flashcards.export(it) }
                break@loop
            }
        }
    }
}
