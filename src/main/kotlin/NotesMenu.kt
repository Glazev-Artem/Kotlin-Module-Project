class NotesMenu(private val menuHelper: Menu, private val archive: Archive) {

    fun show() {
        menuHelper.start("Список заметок в архиве '${archive.name}':") {
            val items = mutableListOf<MenuItem>()
            
            items.add(MenuItem("Создать заметку") {
                createNote()
            })

            archive.notes.forEach { note ->
                items.add(MenuItem(note.title) {
                    showNote(note)
                })
            }

            items.add(MenuItem("Выход") {
                // Возврат в меню архивов
            })
            
            items
        }
    }

    private fun createNote() {
        val title = menuHelper.readNonEmptyString("Введите название заметки:")
        val content = menuHelper.readNonEmptyString("Введите текст заметки:")
        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun showNote(note: Note) {
        println("\n--- Заметка: ${note.title} ---")
        println(note.content)
        println("---------------------------")
        
        // Чтобы пользователь мог выйти из просмотра, показываем меню с одной опцией
        menuHelper.start("Просмотр заметки") {
            listOf(MenuItem("Выход") {})
        }
    }
}
