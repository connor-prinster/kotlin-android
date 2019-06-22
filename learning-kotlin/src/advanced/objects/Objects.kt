package advanced.objects

import kotlin.random.Random

class Person {
    private val age: Int = 42
    private val name: String = "Bob"
    private val randomFact: Int = Random.nextInt(0, 100)

    fun whoAmI() {
        println("$name is $age with $randomFact things.")
    }
}

fun main() {
    val person = Person()
    person.whoAmI()
}