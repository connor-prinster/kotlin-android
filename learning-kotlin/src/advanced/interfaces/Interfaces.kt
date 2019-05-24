package advanced.interfaces

fun main(args: Array<String>) {
    val driveableCar: Driveable = Car("red")
    driveableCar.drive()

    val build: Buildable = Car("red")
    build.build()
}

interface Driveable {
    fun drive()
}

interface Buildable {
    val timeToBuild: Int
    fun build()
}

class Car(val color: String): Driveable, Buildable {

    override val timeToBuild: Int = 10

    override fun drive() {
        println("Driving a car...")
    }

    override fun build() {
        println("Building a car")
    }
}

class Motorcycle(val color: String): Driveable {
    override fun drive() {
        println("Driving a motorcycle")
    }
}