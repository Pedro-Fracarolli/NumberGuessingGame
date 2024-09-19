# Number Guessing Game

Welcome to the Number Guessing Game! This is a simple console-based game where the player tries to guess a randomly generated number between 1 and 100. The game offers three difficulty levels, each providing a different number of chances to guess the correct number.

## How to Play

1. Run the program.
2. Choose a difficulty level:
   - **Easy**: 10 chances
   - **Medium**: 5 chances
   - **Hard**: 3 chances
3. The game will randomly select a number between 1 and 100.
4. Enter your guesses one by one.
5. After each guess, you will receive a hint if the guess was incorrect:
   - Whether the number is higher or lower than your guess.
   - On Easy and Medium difficulties, hints about the last digit of the number will be provided after a certain number of missed attempts.
6. Keep guessing until you:
   - Guess the correct number.
   - Run out of chances.
7. After the game ends, you will be given the option to play again.

## Game Features

- **Difficulty Levels**: Choose between Easy, Medium, and Hard to test your guessing skills.
- **Hints**: Receive hints about the last digit of the number to help you make better guesses.
- **Score**: Your score is calculated based on the number of chances you have left when you guess the number correctly.
- **Replay**: Play as many times as you want.

## Game Flow

1. The game starts by asking the player to choose a difficulty level.
2. Depending on the chosen difficulty, the player will have a set number of chances to guess the number.
3. The player makes guesses, and the game provides feedback on whether the guessed number is too high or too low.
4. If the player runs out of chances, the game reveals the number.
5. The player is then prompted to either play again or exit the game.

## Code Example

Here is a snippet of the main logic for the game:

```java
// Set the difficulty level and generate a random number
String diff = difficulty_level(difficulty);
System.out.println("I'm thinking of a number between 1 and 100");
int random_number = computer_turn();

// Start guessing loop
while (true) {
    System.out.print("- ");
    int player_guess = scan.nextInt();

    if (player_guess == random_number) {
        System.out.println("Congratulations! You guessed the correct number in " + misses + " attempts.");
        System.out.println("Thanks for playing.");
        break;
    }
    // More game logic...
}
```
## Requirements

To run this game, you need to have the following installed on your system:

Java Development Kit (JDK) 8 or higher
Any Java-compatible IDE or a simple text editor (like Notepad++ or VS Code)
Command line or terminal access for compiling and running the Java program

## Acknowledgments

This game was inspired by classic number guessing games and is intended to be a simple and fun way to practice Java programming.
