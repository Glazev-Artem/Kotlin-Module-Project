class ArchivesMenu(private val menuHelper: Menu) {
    private val archives = mutableListOf<Archive>()

    fun show() {
        menuHelper.start("Список архивов:") {
            val items = mutableListOf<MenuItem>()
            
            items.add(MenuItem("Создать архив") {
                val name = menuHelper.readNonEmptyString("Введите название архива:")
                archives.add(Archive(name))
                println("Архив '$name' создан.")
            })

            archives.forEach { archive ->
                items.add(MenuItem(archive.name) {
                    NotesMenu(menuHelper, archive).show()
                })
            }

            items.add(MenuItem("Выход") {
                // Выход из программы (если это главный экран)
            })
            
            items
        }
    }
}
