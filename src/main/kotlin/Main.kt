import java.util.Random

fun main() {
    val userChoice = userChoice()
    val computerChoice = computerChoice()
    println("You chose $userChoice and the computer chose $computerChoice")
    if (userChoice != null) {
        determineWin(computerChoice, userChoice)
    }
}

fun userChoice(): Int? {
    print("Game on! Type 0 for Rock, 1 for Paper or 2 for Scissors: ")
    val userChoice = readlnOrNull()
    return userChoice?.toIntOrNull()
}

fun computerChoice(): Int {
    val random = Random()
    return random.nextInt(2)
}

fun determineWin(computerChoice: Int, userChoice: Int) {
    if (userChoice == 0 && computerChoice == 2) {
        println("You win!")
    } else if (computerChoice > userChoice) {
        println("This computer wins this round, better luck next time")
    } else {
        println("It's a tie! Play again.")
    }
}