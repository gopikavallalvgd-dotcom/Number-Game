 import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Game! ===");

        // Requirement 6: Option for multiple rounds
        while (playAgain) {
            // Requirement 1: Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1; 
            
            // Requirement 5: Limit the number of attempts
            int maxAttempts = 7; 
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Requirement 4: Repeat steps 2 and 3 until correct or out of attempts
            while (attemptsUsed < maxAttempts && !guessedCorrectly) {
                // Requirement 2: Prompt user for their guess
                System.out.print("Enter your guess (Attempt " + (attemptsUsed + 1) + " of " + maxAttempts + "): ");
                
                // Input validation to ensure the user enters an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                    System.out.print("Enter your guess: ");
                }
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                // Requirement 3: Compare guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++; // Requirement 7: Track score based on rounds won
                } else if (userGuess < targetNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + targetNumber);
            }

            // Requirement 7: Display the user's score
            System.out.println("Current Score (Rounds Won): " + roundsWon);

            // Ask if they want to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
        }

        System.out.println("\nThanks for playing! Final Score: " + roundsWon);
        scanner.close();
    }
}
