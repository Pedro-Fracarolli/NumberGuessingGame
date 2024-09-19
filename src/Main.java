import java.util.Random;
import java.util.Scanner;

public class Main {

    static int chances = 0;
    static int highest_score = 0;
    static int current_score = 0;
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

            String diff = difficulty_level(difficulty);
            System.out.println("I'm thinking of a number between 1 and 100");
            int random_number = computer_turn();
            while(true) {
                System.out.print("- ");
                int player_guess = scan.nextInt();

                if (player_guess == random_number) {
                    System.out.println("Congratulations! You guessed the correct number in " + misses + " attempts.");
                    System.out.println("Thanks for playing.");
                    current_score = chances;

                    if (diff.equals("Medium")) {
                        System.out.println("Difficulty Bonus Points: +5");
                        current_score += 5;
                    } else if (diff.equals("Hard")) {
                        System.out.println("Difficulty Bonus Points: +15");
                        current_score += 15;
                    }

                    if (highest_score == 0) {
                        highest_score = current_score;
                    } else if (current_score > highest_score) {
                        highest_score = current_score;
                        System.out.println("New record: " + highest_score + "!");
                    }


                    System.out.println("Highest score: " + highest_score);
                    System.out.println("Current score: " + current_score);
                    if (highest_score != current_score) {
                        System.out.println("You were " + (highest_score - current_score) + " Points away from the highest score!");
                    }
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
                    System.out.println("You failed! The number was: " + random_number);
                    break;
                }
                System.out.println(chances + " chances left.");

                String hint = hint(random_number);
                if (diff.equals("Easy") && chances < 6) {
                    System.out.println("HINT: " + hint);
                } else if (diff.equals("Medium") && chances < 3) {
                    System.out.println("HINT: " + hint);
                } else if (diff.equals("Hard") && chances < 2) {
                    System.out.println("HINT: " + hint);
                }
            }

            System.out.print("Play again? Y/N - ");
            String answer = scan.next().toLowerCase();

            if (answer.equals("y")) {
                System.out.println("Restarting...");
                play = 1;
                chances = 0;
                misses = 0;
            } else {
                System.out.println("Exiting...");
                play = 0;
            }
        } while (play == 1);
    }

    public static int computer_turn() {
        Random generator = new Random();
        return generator.nextInt(100);
    }

    public static String hint(int random_number) {
        int last_digit = random_number % 10;
        return "This number ends with... " + last_digit;

    }

    public static String difficulty_level(int difficulty) {
        String result;

        switch(difficulty) {
            case 1:
                chances = 10;
                System.out.println("Great! You have selected the Easy difficulty level.");
                result = "Easy";
                break;
            case 2:
                chances = 5;
                System.out.println("Great! You have selected the Medium difficulty level.");
                result = "Medium";
                break;
            case 3:
                chances = 3;
                System.out.println("Great! You have selected the Hard difficulty level.");
                result = "Hard";
                break;
            default:
                System.out.println("Invalid difficulty level. Please select a valid option.");
                result = "Invalid";
                break;
        }
        return result;
    }
}