package collections

fun main(args: Array<String>) {
    val arrayList = arrayListOf("apple", "orange", "banana")
    println(arrayList)
    arrayList.remove("apple")
    println(arrayList)
    arrayList.add("lemon")
    println(arrayList)

}