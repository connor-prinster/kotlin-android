package basics.loops

import kotlin.random.Random

fun main(args: Array<String>) {
    val arr = fillArr()
    println("Original array: $arr")
    val revArr = revArr(arr)
    println("Reversed array: $revArr")
}

fun fillArr(): ArrayList<Int> {
    var arr = arrayListOf<Int>()
    for (i in 1..10) {
        arr.add(Random.nextInt(1, 100))
    }
    return arr
}

fun revArr(arr: List<Int>): List<Int> {
    var rev = arrayListOf<Int>()
    for(i in arr.size - 1 downTo 0) {
        rev.add(arr.get(i))
    }
    return rev;
}