package advanced.enums

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