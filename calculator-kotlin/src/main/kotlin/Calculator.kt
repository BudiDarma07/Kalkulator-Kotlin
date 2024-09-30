import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Welcome to the Kotlin Calculator!")

    print("Enter first number: ")
    val num1 = scanner.nextDouble()

    print("Enter operator (+, -, *, /): ")
    val operator = scanner.next()

    print("Enter second number: ")
    val num2 = scanner.nextDouble()

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> {
            if (num2 != 0.0) {
                num1 / num2
            } else {
                println("Error: Division by zero is not allowed.")
                return
            }
        }
        else -> {
            println("Error: Invalid operator.")
            return
        }
    }

    println("Result: $num1 $operator $num2 = $result")
}
