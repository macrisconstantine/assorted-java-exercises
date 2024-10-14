import java.util.Random;
import java.util.Scanner;

/**
 * The Hi-Low game
 * @author I. Vetsikas
 *
 */
public class HiLow {

    public static final int MAX_NUMBER = 100;

    // note this check whether an integer was entered, not whether it is in range!
    public static int readIntFromScanner(Scanner inS, int minN, int maxN)
    {
        System.out.printf("Give me an integer in range %d-%d:", minN, maxN);
        while (!inS.hasNextInt())
        {
            String temp = inS.next();
            System.out.printf("***ERROR:You entered \"%s\", which is not an integer.\n", temp);
            System.out.printf("Give me an integer in range %d-%d:", minN, maxN);
        }
        return inS.nextInt();
    }

    // whether the integer is in range!
    public static int readIntFromScannerInRange(Scanner inS, int minN, int maxN)
    {
        int i;
        boolean doLoop = true;

        do
        {
            i = readIntFromScanner(inS,minN,maxN);
            if (i>=minN && i<=maxN)
            {
                doLoop = false;
            }
            else
            {
                System.out.printf("***ERROR:The integer is NOT in the correct range (%d-%d)\n", minN, maxN);
            }
        }
        while (doLoop);
        return i;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // create random number
        Random rand = new Random();
        int numToGuess = rand.nextInt(MAX_NUMBER)+1;

        int lastGuess = 0;
        int minRange = 1;
        int maxRange = MAX_NUMBER;
        int countGuesses = 0;

        do
        {
            lastGuess = readIntFromScannerInRange(in,minRange,maxRange);
            countGuesses++;
            if (lastGuess<numToGuess)
            {
                System.out.println("HIGHER");
                minRange = lastGuess+1;
            }
            else if (lastGuess>numToGuess)
            {
                System.out.println("LOWER");
                maxRange = lastGuess-1;
            }
            else
            {
                System.out.println("CORRECT");
            }
        }
        while (lastGuess!=numToGuess);

        System.out.printf("Number of guesses=%d",countGuesses);
    }

}
