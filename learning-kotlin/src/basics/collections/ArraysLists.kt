package basics.collections

fun main(args: Array<String>) {
    val arrayList = arrayListOf("apple", "orange", "banana")
    println(arrayList)
    arrayList.remove("apple")
    println(arrayList)
    arrayList.add("lemon")
    val subList = arrayList.subList(0, 2)
    println("Sublist 0-2 is $subList")
}