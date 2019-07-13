package advanced.maps

import java.io.File

fun main() {
    mostCommonIp()
}

fun mostCommonIp() {
    val ipToCount = mutableMapOf<String, Int>()
    File("src/advanced/maps/60.ips.txt").forEachLine {
        val previous = ipToCount.getOrDefault(it, 0)
        ipToCount.put(it, previous + 1)
    }

    val (maxIp, maxCount) = ipToCount.entries.maxBy { it.value }!!

    println("Most common ip address is $maxIp with an occurance of $maxCount")
}

fun standard() {
    println("\n--- Standard Map Functions ---")
    val standardMapConstructor = mapOf(Pair("Peter", 24), Pair("Merlin", 87))
    val differentMapConstructor = mapOf(
        "Peter" to 24,
        "Merlin" to 87
    )

    println(standardMapConstructor == differentMapConstructor)
    println(standardMapConstructor.keys)
    println(standardMapConstructor.values)
    println(standardMapConstructor.entries)

    println("\n--- Advanced Map Functions ---")
    val countryToPopulation = mutableMapOf(
        "Germany" to 23_000_000,
        "USA" to 300_000_000
    )
    println("Contents of map $countryToPopulation")
    println("Contains Germany? ${countryToPopulation.containsKey("Germany")}")
    println("Contains Romania? ${countryToPopulation.containsKey("Romania")}")
    println("Contains value: 300,000,000 (USA)? ${countryToPopulation.containsValue(300_000_000)}")
    countryToPopulation.putIfAbsent("Australia", 320_000_000)
    println("After inputting 'Australia': $countryToPopulation")
    println("Has Germany?: ${countryToPopulation.get("Germany")}")
    println("Has Britain (no default)?: ${countryToPopulation.get("England")}")
    println("Has Finland (w/ default)?: ${countryToPopulation.getOrDefault("Finland", "No")}")
}