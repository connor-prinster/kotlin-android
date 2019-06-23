package advanced.challenges

class Book(private val title: String,
           private val author: String,
           private val pubDate: String) {
    private var borrowed: Boolean

    init {
        borrowed = false
    }

    fun getInfo() {
        println("$title, written by $author, was written in $pubDate. It is currently ${getStatus()}")
    }
    private fun getStatus(): String {
        if(borrowed)
            return "borrowed"
        else
            return "returned"
    }

    fun switchStatus() {
        this.borrowed = !borrowed
        println("\nThe book is now ${getStatus()}")
    }
}

fun main() {
    val book = Book("Eragon", "Christopher Paolini", "2002")
    book.getInfo()
    book.switchStatus()
    book.getInfo()
    book.switchStatus()
    book.getInfo()
}