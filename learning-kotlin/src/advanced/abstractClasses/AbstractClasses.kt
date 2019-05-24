package advanced.abstractClasses

fun main(args: Array<String>) {
    val employee = Employee("Boring", 32)
    val student = Student("Johnny", 17)

    employee.greet()
    employee.speak()
    student.greet()
    student.speak()
}

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