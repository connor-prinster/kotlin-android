package advanced.challenges

interface Lendable {
    fun borrow(type: String)
}

abstract class InventoryItem(open val title: String,
                             open val genre: String,
                             open val publicationYear: Int) : Lendable {

    abstract val borrowed: Boolean
    abstract val type: String
    override fun borrow(type: String){
        print("You are borrowing the $type: $title. This is a $genre $type released in $publicationYear.")
    }
}

class Book(override val title: String,
           override val genre: String,
           override val publicationYear: Int,
           val author: String) : InventoryItem(title, genre, publicationYear) {
    override val borrowed: Boolean = false
    override val type: String = "book"
    fun borrow() {
        super.borrow(this.type)
        println(" It is written by $author.")
    }
}

class Dvd(override val title: String,
          override val genre: String,
          override val publicationYear: Int,
          val length: Int) : InventoryItem(title, genre, publicationYear) {
    override val borrowed: Boolean = false
    override val type: String = "DVD"
    fun borrow() {
        super.borrow(this.type)
        println(" It is $length minutes long")
    }
}

fun main(args: Array<String>) {
    val book = Book("Oathbringer", "fantasy", 2017, "Brandon Sanderson")
    val dvd = Dvd("Star Wars: Empire Strikes Back", "space opera", 1979, 127)
    book.borrow()
    dvd.borrow()
}