package advanced.objects

import kotlin.random.Random

class Person(private val name: String,
             private val pronoun: String,
             private val age: Int) {

    private val randomInt: Int

    init {
        this.randomInt = Random.nextInt(0, 100)
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