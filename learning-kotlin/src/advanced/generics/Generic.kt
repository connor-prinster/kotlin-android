package advanced.generics

class Stack<E>(vararg val items: E) {

    val elements = items.toMutableList()

    fun push(item: E) {
        elements.add(item)
    }

    fun pop(): E? {
        if(!isEmpty()) {
            return elements.removeAt(elements.size - 1)
        }
        return null
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }
}

fun <T> stackOf(vararg elements: T): Stack<T> {
    return Stack(*elements)
}

fun main() {
    val stackInt = stackOf(1, 2, 3, 4)
    val stackString = stackOf("Hello", "World")
    while(!stackInt.isEmpty()) {
        println(stackInt.pop())
    }
    while(!stackString.isEmpty()) {
        println(stackString.pop())
    }
}

