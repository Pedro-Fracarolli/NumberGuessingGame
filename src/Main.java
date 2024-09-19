import java.util.Random;
import java.util.Scanner;

public class Main {

    static int chances = 0;
    static int misses = 0;
    static int play = 1;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("WELCOME TO THE NUMBER GUESSING GAME!");
            System.out.println("------------------------------------");
            System.out.println("Please select the difficulty level:");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");
            System.out.print("Enter your choice: "); int difficulty = scan.nextInt();

            difficulty_level(difficulty);
            System.out.println("I'm thinking of a number between 1 and 100");
            int random_number = computer_turn();
            while(true) {
                System.out.print("- ");
                int player_guess = scan.nextInt();

                if (player_guess == random_number) {
                    System.out.println("Congratulations! You guessed the correct number in " + misses + " attempts.");
                    System.out.println("Thanks for playing.");
                    break;
                }
                if (player_guess > random_number) {
                    System.out.println("Incorrect! The number is less than " + player_guess + ".");
                    misses = misses + 1;
                    chances -= 1;
                }
                if (player_guess < random_number){
                    System.out.println("Incorrect! The number is greater than " + player_guess + ".");
                    misses = misses + 1;
                    chances -= 1;
                }
                if (chances <= 0) {
                    System.out.println("You failed!");
                    break;
                }
                System.out.println(chances + " chances left.");
            }

            System.out.print("Play again? Y/N - ");
            String answer = scan.next().toLowerCase();

            if (answer.equals("y")) {
                System.out.println("Recomeçando...");
                play = 1;
                chances = 0;
                misses = 0;
            } else {
                System.out.println("Saindo...");
                play = 0;
            }
        } while (play == 1);



    }

    public static int computer_turn() {
        Random generator = new Random();
        return generator.nextInt(100);
    }

    public static void difficulty_level(int difficulty) {
        switch(difficulty) {
            case 1:
                chances = 10;
                System.out.println("Great! You have selected the Easy difficulty level.");
                break;
            case 2:
                chances = 5;
                System.out.println("Great! You have selected the Medium difficulty level.");
                break;
            case 3:
                chances = 3;
                System.out.println("Great! You have selected the Hard difficulty level.");
                break;
        }
    }
}