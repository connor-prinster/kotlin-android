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

class House(val height: Double, val color: String, val price: Int, val width: Double = 5.0) {
    fun printInfo() {
        println("House [height: $height, width: $width color: $color, price: $price")
    }
}

fun main() {
    val house = House(5.0, "blue", 500000)
    val redHouse = House(color = "red", height = 6.0, price = 250000)
    val yellowHouse = House(color = "yellow", height = 6.0, width = 6.0, price = 300000)
    house.printInfo()
    redHouse.printInfo()
    yellowHouse.printInfo()
}

fun bookStuff() {
    val book = Book("Eragon", "Christopher Paolini", "2002")
    book.getInfo()
    book.switchStatus()
    book.getInfo()
    book.switchStatus()
    book.getInfo()
}