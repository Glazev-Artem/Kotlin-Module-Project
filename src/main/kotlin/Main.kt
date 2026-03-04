fun main() {
    println("Добро пожаловать в приложение 'Заметки'!")
    val menuHelper = Menu()
    val archivesMenu = ArchivesMenu(menuHelper)
    archivesMenu.show()
    println("Программа завершена. До свидания!")
}
