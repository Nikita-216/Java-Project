import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("ROCK - PAPER - SCISSORS GAME");
        System.out.println("First to 3 points wins!\n");

        while (playerScore < 3 && computerScore < 3) {
            System.out.println("Choose: 1 = Rock, 2 = Paper, 3 = Scissors");
            System.out.print("Your choice: ");
            int player = sc.nextInt();

            int computer = rand.nextInt(3) + 1;  // 1–3

            System.out.println("Computer chose: " + computer);

            // Check draw
            if (player == computer) {
                System.out.println("It's a DRAW!");
            }

            // Player wins
            else if ((player == 1 && computer == 3) ||
                     (player == 2 && computer == 1) ||
                     (player == 3 && computer == 2)) {

                System.out.println("You WIN this round!");
                playerScore += 1;    // using += operator
            }

            // Computer wins
            else {
                System.out.println("Computer WINS this round!");
                computerScore += 1;   // using += operator
            }

            System.out.println("Score → You: " + playerScore + " | Computer: " + computerScore);
            System.out.println("----------------------------------");
        }

        // Final result
        if (playerScore == 3) {
            System.out.println("YOU WIN THE GAME!");
        } else {
            System.out.println("COMPUTER WINS THE GAME!");
        }
    }
}
