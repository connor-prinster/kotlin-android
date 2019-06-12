package breakContinue

fun main(args: Array<String>) {
//    breakMethod()
//    continueMethod()
//    namedLoop()
    codingChallenge()
}

fun breakMethod() {
    for(c in "Python") {
        if(c == 'o') {
            break
        }
        print(c)
    }
}

fun continueMethod() {
    for(c in "Pythioqn") {
        if(c == 'i' || c == 'q') {
            continue
        }
        print(c)
    }
}

fun namedLoop() {
    outer@ for (i in 1..10) {
        for (j in 1..10) {
            if(i - j == 5) {
                // can also use "continue@outer"
                break@outer
            }
            println("$i - $j")
        }
    }
}

fun codingChallenge() {
    var x = 0L
    for (i in 100..100000L) {
        x += i
    }
    print(x)
}