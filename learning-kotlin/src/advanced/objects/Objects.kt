package advanced.objects

import kotlin.random.Random

class Person(name: String, pronoun: String, age: Int) {
    private val age: Int
    private val name: String
    private val randomInt: Int
    private val pronoun: String

    init {
        this.age = age
        this.name = name
        this.randomInt = Random.nextInt(0, 100)
        this.pronoun = pronoun
    }

    fun whoAmI() {
        println("$name is $age with $randomInt things.")
    }
    fun getYearBorn() = 2019 - age
    fun getProunoun() = this.pronoun
}

fun main() {
    val person = Person("Galabrial Johnlohnson", "He", 42);
    person.whoAmI()
    println("${person.getProunoun()} was born in ${person.getYearBorn()}")
}