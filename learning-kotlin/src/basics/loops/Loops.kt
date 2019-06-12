package basics.loops

fun main(args : Array<String>) {
//    forLoop()
    whileLoop()
}

fun forLoop() {
//    for (i in 1..10) {
//        println(i)
//    }

    val list = listOf("Java", "Kotlin", "Python")
    for((index, value) in list.withIndex()) {
        println("Element at $index is $value")
    }
}

fun whileLoop() {
    var x = 9
    while (x >= 0) {
        println(x)
        x--
    }
}