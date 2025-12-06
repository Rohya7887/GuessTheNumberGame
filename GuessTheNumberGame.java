import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 3;
        int maxAttempts = 7;
        int totalScore = 0;

        System.out.println("🎮 Welcome to Guess The Number Game!");
        System.out.println("-------------------------------------");

        for(int round = 1; round <= rounds; round++)
        {
            int number = random.nextInt(100) + 1; // 1-100
            int attemptsUsed = 0;
            boolean guessed = false;

            System.out.println("\n🔵 Round " + round + " begins!");
            System.out.println("I have selected a number between 1 and 100. ");
            System.out.println("You have " + maxAttempts + " attempts.");

            while(attemptsUsed < maxAttempts)
            {
                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attemptsUsed++;

                if(guess == number)
                {
                    guessed = true;
                    int pointsEarned = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += pointsEarned;

                    System.out.println("🎉 Correct! You guessed the number!");
                    System.out.println("Attempts used: " + attemptsUsed);
                    System.out.println("Points earned this round: " + pointsEarned);
                    break;
                } else if (guess < number)
                {
                    System.out.println("👇 Too low! Try a higher number.");
                }else{
                    System.out.println("☝️ Too high! Try a lower number.");
                }
            }
            if(!guessed)
            {
                System.out.println("❌ Out of attempts! The number was: " + number);
            }
            System.out.println("-----------------------------------------------");
        }
        System.out.println("\n🏁 Game Over!");
        System.out.println("Your total score: " + totalScore);

        if(totalScore > 200)
        
            System.out.println("🔥 Excellent Performance!");
        else if (totalScore > 100)
            System.out.println("👍 Good Job!");
        else
            System.out.println("🙂 Keep Practicing!");

        sc.close();
    }
}