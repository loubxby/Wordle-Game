import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordleMain
{
    public static void main(String[] args)
    {
        Random random = new Random();
        WordList word = new WordList();
        String[] randomWords = word.getWordList();
        String correct = randomWords[random.nextInt(20)];
        Scanner userInput = new Scanner(System.in);

        final String BG_GREEN = "\u001b[42m";
        final String BG_YELLOW = "\u001b[43m";
        final String RESET = "\u001b[0m";

        System.out.println("WORDLE!");
        for (int count = 0; count < 5; count++)
        {
            int win = 0;
            System.out.println("Enter Word");
            String guess = userInput.nextLine();

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
                break;
            }
        }
    }
}
