import java.util.*;

/**
 * The Kremala (hanged man) game
 * @author I. Vetsikas
 *
 */
public class Kremala {

	/**
	 * The minimum length of a valid word to be hidden
	 */
	public static final int MIN_WORD_LENGTH = 8;

	/**
	 * Returns true if the character is a letter (lower or capital)
	 * @param c : character to be checked
	 * @return true/false
	 */
	public static boolean isLetter(char c)
	{
		return ((c>='A' && c<='Z') || (c>='a' && c<='z'));
	}
	
	/**
	 * Reads a word from the scanner (i.e. keyboard) making certain that it contains only letters
	 * and its length is at least minLen characters/letters.
	 * Note that it does not check that the letter constitute a valid english word!
	 * @param inS : where to read from
	 * @param minLen : minimum length of the word we want
	 * @return : a string containing a valid word
	 */
	public static String readWordFromScanner(Scanner inS, int minLen)
	{
		boolean notAWord = false;
		String temp;
		do
		{
			System.out.print("Player 1 - Please enter a word with "+minLen+" letters or more:");
			temp = inS.next();
			notAWord = false;
			if (temp.length()<minLen)
			{
				System.out.printf("***ERROR:You entered \"%s\", which only has %d (<%d) characters.\n", temp, temp.length(), minLen);
				notAWord = true;
			}
			else
			{
				for (int i=0; i<temp.length(); i++)
				{
					char c = temp.charAt(i);
					if ( !isLetter(c) )
					{
						notAWord = true;
					}
				}
				if (notAWord) 
				{
					System.out.printf("***ERROR:You entered \"%s\", which is not a word.\n", temp);
				}
			}
		}
		while (notAWord);
		
		return temp;
	}
	
	/**
	 * Read a character from the scanner (i.e. keyboard) and makes sure it is a letter.
	 * Note that is you write a whole string of characters it will consider only the first character
	 * @param inS : where to read from
	 * @return : a character that is a letter
	 */
	public static char readLetterFromScanner(Scanner inS)
	{
		char c;
		do 
		{
			System.out.print("Player 2 - Guess a letter:");
			c = inS.next().toUpperCase().charAt(0);
			if (!isLetter(c))
			{
				System.out.printf("***ERROR:You entered \"%s\", which is not a letter.\n", c);				
			}
		}
		while (!isLetter(c));
		
		return c;
	}
	
	/**
	 * Hides all letters in the string except the first and the last
	 * @param s : string containing word to hide
	 * @return : the new string which the letters hidden (except the first and last)
	 */
	public static String hideLetters (String s)
	{
		String hideS = "";
		for (int i=s.length()-2; i>0; i--)
		{
			hideS = hideS + "_";
			//System.out.println(hideS);
		}
		hideS = s.charAt(0) + hideS + s.charAt(s.length()-1);
		
		return hideS;
	}

	/**
	 * Prints the hanged man
	 * @param wrongLetters : how many wrong guesses have been entered
	 */
	public static void printHangedMan(int wrongLetters)
	{
		System.out.println();
		System.out.println("+-------+");
		System.out.println("|       |");
		//print head
		if (wrongLetters<1)
		{
			System.out.println("|");
		}
		else
		{
			System.out.println("|       O");
		}
		//print torso and hands
		if (wrongLetters<2)
		{
			System.out.println("|");			
			System.out.println("|");			
		}
		else if (wrongLetters==2)
		{
			System.out.println("|       |");
			System.out.println("|       |");
		}
		else if (wrongLetters==3)
		{
			System.out.println("|     --|");
			System.out.println("|       |");
		}
		else
		{
			System.out.println("|     --|--");
			System.out.println("|       |");
		}
		//print legs
		if (wrongLetters<5)
		{
			System.out.println("|");			
			System.out.println("|");			
		}
		else if (wrongLetters==5)
		{
			System.out.println("|      /");
			System.out.println("|     /");
		}
		else
		{
			System.out.println("|      / \\");
			System.out.println("|     /   \\");
		}
		System.out.println("|");			
	}
	
	/**
	 * Searched string s to find if character c exists in it 
	 * @param s : String to search
	 * @param c : Character that is to be matched
	 * @return : -1 if the character does not exist in the string otherwise the first position it occurs
	 */
	public static int firstLetterInString(String s, char c)
	{
		int position=-1;
		for (int i=s.length()-1; i>=0; i--)
		{
			if (s.charAt(i)==c)
				position = i;
		}
		return position;
	}
	
	/**
	 * uncovers (and returns) the letter c in hideStr (getting the letter from the full word originalStr)
	 * @param hideStr : String with hidden letters
	 * @param originalStr : Original word
	 * @param c : Character to uncover (if it exists)
	 * @return The string with hidden letters where the new letter has been input (if it exists)
	 */
	public static String uncoverLetters(String hideStr, String originalStr, char c)
	{
		String updatedHideS = "";
		for (int i=0; i<hideStr.length(); i++)
		{
			if (originalStr.charAt(i)==c)
			{
				updatedHideS = updatedHideS + c;
			}
			else
			{
				updatedHideS = updatedHideS + hideStr.charAt(i);
			}
		}

		return updatedHideS;
	}
	
	/**
	 * The main method where the game is implemented
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("-------------------\n");
		System.out.println("Welcome to KREMALA!\n");
		System.out.println("-------------------\n");
		
		String wordToGuess = readWordFromScanner(in, MIN_WORD_LENGTH).toUpperCase();
		
		System.out.printf("Player 1 - You entered \"%s\"\n", wordToGuess);
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		for (int i=1; i<50; i++)
			System.out.println();
		
		// Player 2 guesses now
		int wrongL = 0;
		String guessingS = hideLetters(wordToGuess);
		
		/*
		for (int i=0; i<=6; i++)
			printHangedMan(i);
		System.out.println();
		 */
		
		boolean wordFound = false;
		while (wrongL<6 && !wordFound)
		{
			printHangedMan(wrongL);
			System.out.printf("\n%s   Wrong Guesses:%d\n", guessingS, wrongL);
			char c = readLetterFromScanner(in);
			String guessingS2 = uncoverLetters(guessingS, wordToGuess, c);
			if (guessingS2.equals(guessingS))
			{
				//System.out.println(guessingS2);
				wrongL++;
			}
			else
			guessingS=guessingS2;
			if (guessingS.equals(wordToGuess))
			{
				wordFound = true;
			}
		}
		
		if (wrongL>=6)
		{
			printHangedMan(wrongL);
			System.out.printf("\nPlayer 2 You got hanged! The word you had to guess is: %s\n", wordToGuess);
		}
		else
		{
			System.out.printf("\nPlayer 2 You won! You guessed the word: %s\n", wordToGuess);			
		}
	}

}