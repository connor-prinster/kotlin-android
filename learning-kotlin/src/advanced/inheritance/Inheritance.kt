package advanced.inheritance

fun main(args: Array<String>) {
    val student = Student("John", 25)
    val teacher = Teacher("Jonathan", 31)

    student.speak()
    teacher.speak()

    teacher.greet(student.name)
    student.greet(teacher.name)
}

open class Person(open val name: String, open val age: Int) {
    fun speak() {
        println("Hello! My name is ${this.name}")
    }

    fun greet(name: String) {
        println("Hello, $name")
    }
}

class Student(override val name: String, override val age: Int): Person(name, age) {

}

class Teacher(override val name: String, override val age: Int): Person(name, age) {

}

