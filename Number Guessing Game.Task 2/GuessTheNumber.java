import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalRounds = 3;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Guess the Number Game!");
        System.out.println("You have to guess the number between 1 and 100.");
        System.out.println("You will get 10 attempts in each round. Let's begin!\n");

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = rand.nextInt(100) + 1;
            int attempts = 10;
            boolean isGuessed = false;

            System.out.println("🔁 Round " + round + " begins!");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + " - Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed it in " + i + " attempts.");
                    int score = 100 - (i - 1) * 10;  // 100 points max, -10 per extra attempt
                    System.out.println("You earned " + score + " points.\n");
                    totalScore += score;
                    isGuessed = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!isGuessed) {
                System.out.println("❌ You've used all attempts. The correct number was: " + targetNumber + "\n");
            }
        }

        System.out.println("🏁 Game Over!");
        System.out.println("Your total score after " + totalRounds + " rounds is: " + totalScore);
        sc.close();
    }
}

