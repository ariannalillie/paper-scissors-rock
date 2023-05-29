import java.util.Random

const val rock = """
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
"""

const val paper = """
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
"""

const val scissors = """
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
"""

fun main() {
    val gameImages = listOf(rock, paper, scissors)
    var continueGame = true

    while (continueGame) {
        val userChoice = userChoice()
        val computerChoice = computerChoice()
        if (userChoice != null) {
            if (userChoice in 0..2) {
                println("You:")
                println(gameImages[userChoice])
                println("Computer:")
                println(gameImages[computerChoice])
            }
            determineWin(computerChoice, userChoice)
        }
        continueGame = keepPlaying()
    }
}

// userChoice returns an integer between 0 and 2 that represents the user's game choice
fun userChoice(): Int? {
    print("Game on! Type 0 for Rock, 1 for Paper or 2 for Scissors: ")
    val userChoice = readlnOrNull()
    return userChoice?.toIntOrNull()
}

// computerChoice returns a random integer between 0 and 2 that represents the computer's game choice
fun computerChoice(): Int {
    val random = Random()
    return random.nextInt(2)
}

// determineWin provides the user with feedback about the outcome of the game
fun determineWin(computerChoice: Int, userChoice: Int) {
    if (userChoice > 3 || userChoice < 0) {
        println("Invalid choice")
    } else if (userChoice == 0 && computerChoice == 2) {
        println("You win! 🎉")
    } else if (userChoice == 2 && computerChoice == 0) {
        println("This computer wins this round, better luck next time")
    } else if (computerChoice > userChoice) {
        println("This computer wins this round, better luck next time")
    } else if (userChoice > computerChoice) {
        println("You win! 🎉")
    } else {
        println("It's a draw! Play again.")
    }
}

// keepPlaying returns a boolean value about whether the user would like to continue playing
fun keepPlaying(): Boolean {
    print("Do you want to continue playing? Type Y for Yes and N for No: ")
    val userChoice = readlnOrNull()
    return userChoice.equals("Y", ignoreCase = true)
}