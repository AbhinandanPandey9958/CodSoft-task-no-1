import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1; 
        int maxRange = 100;
        int maxAttempts = 5;
        
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have generated a number between " + minRange + " and " + maxRange);
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The correct number was " + targetNumber);
            }
            
            score += guessedCorrectly ? 1 : 0;
            
            System.out.println("Your current score is: " + score);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        
        System.out.println("Game over. Your final score is: " + score);
        
        scanner.close();
    }
}
