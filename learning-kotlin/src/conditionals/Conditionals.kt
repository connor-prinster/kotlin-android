package conditionals

fun main(args: Array<String>) {
//    val age:Int = 1
//    if(age < 15) {
//        print("You cannot register. You are only $age")
//    }
//    else if (age >= 15 && age <21) {
//        print("Must register as younger than an adult as you are $age")
//    } else {
//        print("No restrictions for you as you are $age")
//    }

    val catch : Int = 9
    when(catch) {
        1 -> {
            println("hello")
        }
        2 -> {
            println("hello with value $catch")
        }
        else -> {
            print("there is nothing here")
        }
    }
}