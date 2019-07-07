# Notes:

## Basic Variables:

*val* cannot be changed
*var* can be changed

To make sure something is casted a certain way:
```kotlin
var name:<desired class> = <value>

//ex:
var integer:Int = 1234
var doubleVal:Double = 1234
// print(doubleVal) = 1234.0
...and so forth...
```

## No Nulls!

Well, there are no strictly null types.

For example
```kotlin
//These will all throw errors
var nonNull:Int = null
var nonNull:Double = null
var nonNull:Float = null

//These will not
var nonNull:Int? = null
var nonNull:Double? = null
var nonNull:Float? = null
```

This does not allow errors like this to occur:
```java
String str = null;
System.out.println(str.length); //This will throw an error
```

```kotlin
//if we declare the variable as a Nullable
var str:String? = "Kotlin is fun"
//this will not even be allowed to compile. It'll throw a
// compilation error as opposed to a runtime error which
// is pretty amazing imho
print(str.length)

//This can cause problems, however, because you will sometimes
// need to call a Nullable.length. In this, you can make a
// safe call, which would be
str?.length
// which does not allow for any NullPointerExceptions. It will
// instead just return a value of *null* instead of losing its
// mind
// This causes a problem, however, if you are attempting to
// store str.length into an int, as it will not allow it.
// To circumvent this, you must have a Nullable Int receive
// the str.length
var nullableString:String? = "kotlin is kind of great"
var length:Int = nullableString.length //will throw an error
var length:Int? = nullableString.length //will not
```
You can tell Kotlin that you are SURE that a variable will not
be null (so you don't have to catch it will a Nullable type
```kotlin
var str:String? = null //obviously a Nullable String
 //will post an error. It only compiled because we
 // guaranteed the compiler we knew what we were doing
 // and we obviously didn't
print(str!!.length)
```

## Conditionals:
When statements are essentially just switch statements

Interesting aspect of *when statements*:
```kotlin
val result = when(mode) {
    // this will have result -> "this is lazy work"
    1 -> "this is lazy work"
    
    // this will have the result -> "the mode is still kind of lazy"
    // as it will only return the final section
    2 -> {
        "the mode is 2"
        "the mode is still kind of lazy"
    }
}
```

Cleaner version of Java's `if(val > 10 && val < 20)` is cleaner in Kotlin as `if(val in 10..20')`

Another nice thing you can use is the keyword inversely. You can use `!in` instead.

## Collections: Arrays and Lists

* Arrays are if you know the exact amount of items in a collection
    * `val array = arrayOf(<items>)`
* Lists are if you do **NOT** know the number of items
    * `val list = listOf(<items>)`
* ArrayList:
    * has a *.size
    * has a *.contains(<query>)
    * *.isEmpty()
    using `*.remove(<element>)` will return a Boolean
    
## Loops:
* for basics.loops
    * For a standard loop
    ```kotlin
    for(i in 1..10) {
    // whatever else
    }
    ```
    * to keep track of index and value at an index
    ```kotlin
    val list = listOf("Java", "Kotlin", "Python")
    for((index, value) in list.withIndex()) {
          println("Element at $index is $value")
    }
    ```

* while loop
    ```kotlin
    val x = 9
    while (x >= 0) {
      println(x)
      x--
    }
    ```
    
## Break and Continue Operators
* `break`:
is used when we want to break out of a loop. Doesn't just skip a single iteration, kills whole loop
```kotlin
for(c in "Python") {
    if(c == 'o') {
        break
    }
    print(c)
}
```

* continue:
skips a single iteration
```kotlin
for(c in "Pythion") {
    if(c == 'i') {
        continue
    }
    print(c)
}
```

* named basics.loops:
you can name loops for clarity!
```kotlin
outer@ for (i in 1..10) {
    for (j in 1..10) {
        if(i - j == 5) {
            // can also use continue@outer
            break@outer
        }
        println("$i - $j")
    }
}
```

## Object

Below is an example of a class declaration
```kotlin
class Person {
    private val age: Int = 42
    private val name: String = "Bob"
    private val randomFact: Int = Random.nextInt(0, 100)
    fun whoAmI() {
        println("$name is $age with $randomFact things.")
    }
    fun getYearBorn() = 2019 - age
}

fun main() {
    val person = Person()
    println(person.getYearBorn())
}
```

You can also add a bit of sugary syntax by assigning a variable outside of the `init` block
```kotlin
class Book(private val title: String, private val author: String, private val pubDate: String) { 
    fun printInfo() {
        println("$title, written by $author, was written in $pubDate.")
        }
}
```

You can also mix up the order of parameters if you name them. Like so
```kotlin
class House(val height: Double, val color: String, val price: Int, val width: Double = 5.0) {
    fun printInfo() {
        println("House [height: $height, width: $width color: $color, price: $price")
    }
}

fun main() {
    val house = House(5.0, "blue", 500000)
    val redHouse = House(color = "red", height = 6.0, price = 250000)
    val yellowHouse = House(color = "yellow", height = 6.0, width = 6.0, price = 300000)
    house.printInfo()
    redHouse.printInfo()
    yellowHouse.printInfo()
}
```

## Open/Abstract class

Open and Abstract classes are very similar. Open classes **CAN** be overriden, abstract **MUST**.
An example of the abstract and open values are below.

```kotlin
abstract class Person(open val name: String, open val age: Int) {

    fun greet() {
        println("Hello, my name is $name and I am $age")
    }

    abstract fun speak()

    fun getYearOfBirth() = 2019 - age
}

class Employee(override val name: String, override val age: Int): Person(name, age) {
    override fun speak() {
        println("I am an employee")
    }
}

class Student(override val name: String, override val age: Int): Person(name, age) {
    override fun speak() {
        println("I am a student")
    }
}
```

## Interfaces

You can have values as well as methods inside of interfaces. You cannot, however,
assign a value to it. For example:
```kotlin
interface Buildable {
    val timeToBuild: Int // do not instantiate in Interface
}

class Car(val color: String): Buildable {

    override val timeToBuild: Int = 10
    
}
```

## Multiple Inheritance

It is possible to inherit from multiple places with the same named function. For example,
the `learn()` class is shown below found in both the `interface Learnable` and the 
`abstract class Course`:
```kotlin
abstract class Course(val topic: String, val price: Double) {
    open fun learn() {
        println("hello")
    }
}

interface Learnable {
    fun learn() {
        println("Learning")
    }
}

open class KotlinCourse() : Course("Kotlin", 999.99), Learnable {
    final override fun learn() {
        super<Course>.learn()
        super<Learnable>.learn()
        println("I'm one of the first people to learn Kotlin!")
    }
}
```

## Data Class
A `data class` is very useful if the class will do nothing other than hold data. One thing is that it
 makes the `print()` method look nicer as it makes its own `*.toString()` method. For example: 

```kotlin
class Book(val title: String, val author: String, val publicationYear: Int, var price: Double) {}

data class DataBook(val title: String, val author: String, val publicationYear: Int, var price: Double) {}

fun main(args: Array<String>) {
    val book = Book("Super Book", "John Doe", 2017, 99.99)
    val dataBook = DataBook("Super Book", "John Doe", 2017, 99.99)

    println(book)
    // will print the class name and their parent classes
    println(dataBook)
    // will print "DataBook(title=Super Book,...,price=99.99(
}
```
in order for the `Book` class to print the same way as `DataBook`, it will require this method
```kotlin
override fun toString(): String {
    return "Book(title=$title, author=$author, publicationYear=$publicationYear, price=$price)"
}
```

another great thing a `data class` can do is have two objects with identical attributes satisfy
a `.equals()` method. The attributes are compared to one another as opposed to
checking if the object is actually the same object.
For example:

```kotlin
val book1 = Book("Super Book", "John Doe", 2017, 99.99)
val book2 = Book("Super Book", "John Doe", 2017, 99.99)
val dataBook1 = DataBook("Super Book", "John Doe", 2017, 99.99)
val dataBook2 = DataBook("Super Book", "John Doe", 2017, 99.99)
    
// prints "false"
println(book1.equals(book2))
// prints "true"
println(dataBook1.equals(dataBook2))
```

This is also true when we make a hashmap of the three objects. The three objects will create a hashmap of only two objects
```kotlin
    val dataBook1 = DataBook("Super Book", "John Doe", 2017, 99.99)
    val dataBook2 = DataBook("Super Book", "John Doe", 2017, 99.99)
    val dataBook3 = dataBook1.copy(title = "Super Book 3")
    
    val set = hashSetOf(dataBook1, dataBook2, dataBook3)
    // set is only two large
    println(set)
```

Data classes also have a `.copy()` method that can change only chosen values from the original object
```kotlin
val dataBook3 = dataBook1.copy(title = "Super Book 3")
```

Also, `data class` can function similarly to grabbing objects from React `props`
```kotlin
val (title, author, year, price) = dataBook1
```

## Object

The keyword `object` allows you to create an object that can only be instantiated one. This
particular example below is about having an application-wide cache. 
```kotlin
object Cache {
    val name = "Cache"

    fun retrieveData(): Int {
        return 0
    }
}
```

## Enums
This is a very basic version of an enum. This is just a very good reference
```kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    YELLOW(0xFFFF00);
}

fun main(args: Array<String>) {
    // "RED" (name of enum)
    val redName = Color.RED
    // 16711680 (binary version of hex)
    val redHex = Color.RED.rgb

    // prints a string of values relating to the enum
    println("Name of enum object: $redName\nBinary value of enum object: $redHex")
}
```

## Hex and Binary
Hex values are represented by something similar to `0b11111111`
Binary values are represented by something similar to `0xFF`

From this, `println(0b11111111 == 0xFF)` will result in `true`

## Getters and Setters
Good examples of a getter and setter for classes
```kotlin
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
```