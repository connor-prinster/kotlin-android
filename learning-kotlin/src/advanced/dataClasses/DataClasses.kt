package advanced.dataClasses

class Book(val title: String, val author: String, val publicationYear: Int, var price: Double) {
    override fun toString(): String {
        return "Book(title=$title, author=$author, publicationYear=$publicationYear, price=$price)"
    }
}

data class DataBook(val title: String, val author: String, val publicationYear: Int, var price: Double) {

}

fun main(args: Array<String>) {
    val book1 = Book("Super Book", "John Doe", 2017, 99.99)
    val book2 = Book("Super Book", "John Doe", 2017, 99.99)
    val dataBook1 = DataBook("Super Book", "John Doe", 2017, 99.99)
    val dataBook2 = DataBook("Super Book", "John Doe", 2017, 99.99)
    val dataBook3 = dataBook1.copy(title = "Super Book 3")

    println(book1)
    println(dataBook1)
    print(dataBook3)

    println(book1.equals(book2))
    println(dataBook1.equals(dataBook2))

    val (title, author, year, price) = dataBook1
    println("$title, $author, $year, $price")

    val set = hashSetOf(dataBook1, dataBook2, dataBook3)
    println(set)
}

