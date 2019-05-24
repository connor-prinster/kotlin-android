package basics.basicsChallenge

/*
* create an array list of your favorite book titles. Loop
* over this list and, if the title contains the letter 'e,'
* print each character of the name on a new line.
*/

fun main() {
    var arrayList = arrayListOf("Eragon", "Way of Kings", "Oathbringer", "Warbreaker", "Elantris", "I'm Not a Serial Killer")
    println("If the book is printed, it has an 'e' in the title\n")

    for (book in arrayList) {
        if(book.contains('e')) {
            println(book)
        }
    }
}