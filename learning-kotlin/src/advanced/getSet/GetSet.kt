package advanced.getSet

enum class Animals(val animal: String) {
    LION("Lion"),
    DOG("Dog"),
    CAT("Cat")

}

class Animal {
    var species: Animals = Animals.DOG
        get() = field
        set(value) {
            if(value != Animals.CAT) {
                field = value
            }
        }
}

fun main(args: Array<String>) {
    val animal = Animal()
    animal.species = Animals.LION // will actually change as it is not 'cat'
    animal.species = Animals.CAT // will NOT change
    println(animal.species) // will print 'lion'
}