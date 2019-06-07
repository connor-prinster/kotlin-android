package conditionals

import java.util.*

fun main(args: Array<String>) {
    normalConditionals()
    challenge()
}

fun normalConditionals() {
    val age:Int = 1
    if(age < 15) {
        print("You cannot register. You are only $age")
    }
    else if (age >= 15 && age <21) {
        print("Must register as younger than an adult as you are $age")
    } else {
        print("No restrictions for you as you are $age")
    }

    val catch : Int = 9
    val result : String = when(catch) {
        1 -> {
            "mode $catch"
        }
        2 -> {
            "mode $catch"
            "what's interesting is that"
            "nothing above this will be returned"
            "only this line will be assigned to 'result"
        }
        else -> {
            "mode $catch"
        }
    }

    val range : Int = 3
    if(range in 1..10) {
        print("hello")
    }
}

fun challenge() {
    //This is the challenge function
    val random = Random().nextInt(50) + 1

    when(random) {
        in 1..10 -> print("1..10 with value $random")
        in 11..20 -> print("11..20 with value $random")
        in 21..30 -> print("21..31 with value $random")
        in 31..40 -> print("31..40 with value $random")
        else -> print("1..10 with value $random")
    }
}