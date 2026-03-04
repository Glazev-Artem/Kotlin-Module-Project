import java.util.Scanner

class MenuItem(val title: String, val action: () -> Unit)

class Menu {
    private val scanner = Scanner(System.`in`)

    fun start(title: String, itemProvider: () -> List<MenuItem>) {
        while (true) {
            val items = itemProvider()
            println("\n$title")
            items.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }

            val input = scanner.nextLine()
            val index = input.toIntOrNull()

            if (index == null) {
                println("Ошибка: введите цифру.")
                continue
            }

            if (index !in items.indices) {
                println("Ошибка: такой цифры нет в меню.")
                continue
            }

            // Выполняем действие
            items[index].action()
            
            // Если выбран последний пункт (Выход), выходим из цикла
            if (index == items.size - 1) {
                break
            }
        }
    }

    fun readNonEmptyString(prompt: String): String {
        while (true) {
            println(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) {
                return input
            } else {
                println("Ошибка: поле не может быть пустым.")
            }
        }
    }
}
