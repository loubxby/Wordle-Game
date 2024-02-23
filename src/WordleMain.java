import java.util.Random;
import java.util.Scanner;

public class WordleMain
{
    public static void main(String[] args)
    {
        Boolean winner = false;

        Random random = new Random();

        WordList word = new WordList();

        String[] randomWords = word.getWordList();

        String correct = randomWords[random.nextInt(20)];

        Scanner userInput = new Scanner(System.in);

        // color codes
        // green for correct character and position
        // yellow for correct character but incorrect position
        final String BG_GREEN = "\u001b[42m";
        final String BG_YELLOW = "\u001b[43m";
        final String RESET = "\u001b[0m";

        System.out.println("WORDLE!"); // game title

        for (int count = 0; count < 6; count++) // 6 chances to guess 5-letter word
        {
            int win = 0; // keep track of correct letters
            System.out.println("Enter Word");
            String guess = userInput.nextLine();
            while (guess.length() != 5)
            {
                System.out.println("Your word must be 5 letters");
                guess = userInput.nextLine();
            }

            StringBuilder attempt = new StringBuilder();

            for (int letterCount = 0; letterCount < correct.length(); letterCount++)
            {
                if (guess.substring(letterCount, letterCount + 1)
                        .equals(correct.substring(letterCount, letterCount + 1)))
                {
                    attempt.append(BG_GREEN).append(guess.charAt(letterCount)).append(RESET);
                    win += 1;
                }
                else if (correct.contains(guess.substring(letterCount, letterCount + 1)))
                {
                    attempt.append(BG_YELLOW).append(guess.charAt(letterCount)).append(RESET);
                }
                else attempt.append(guess.charAt(letterCount));
            }
            System.out.println(attempt);
            if (win == 5)
            {
                System.out.println("You Win!!");
                winner.equals(true);
                break;
            }
        }
        if (winner.equals(false))
        {
            System.out.println("The Correct Answer is " + correct);
        }
    }
}
