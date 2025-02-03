import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Variables to keep track of the score and rounds
        int totalRounds = 0;
        int totalAttempts = 0;

        while (true) {
            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10; // Limit the number of attempts per round
            boolean correctGuess = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");

            // Start the round
            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    correctGuess = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                }
            }

            // Check if the user won
            if (correctGuess) {
                totalRounds++;
                totalAttempts += attempts;
                System.out.println("It took you " + attempts + " attempts.");
            } else {
                System.out.println("Sorry! You've used all attempts. The correct number was " + targetNumber);
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (y/n): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }
        }

        // Display the user's score at the end
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);

        if (totalRounds > 0) {
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.println("Average attempts per round: " + averageAttempts);
        } else {
            System.out.println("You didn't play any rounds.");
        }

        scanner.close();
    }
}
