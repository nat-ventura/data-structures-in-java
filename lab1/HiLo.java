import java.util.Random;
import java.util.Scanner;

/** Numeric guessing game. Computer picks a number between 1 and 1000,
 * then the user guesses what the number is.
 */

/**
 * @author natventura
 *
 */

public class HiLo {

    /**
     * @param args
     */
    public static void main(String[] args) {

	System.out.println("Welcome to the HiLo guessing game!\n " + "I will pick a number between 1 and 100.\n "
		+ "Try guessing the number! :)");

	Random randoNum = new Random();
	int target = randoNum.nextInt(1000) + 1;
	int userGuess = -1;
	int guessCount = 0;
	System.out.println("What's your guess? ");
	Scanner input = new Scanner(System.in); // reading user input

	while (input.hasNextLine()) { // keep looping for each guess, use
				      // 'break' to exit
	    guessCount += 1;
	    String line = input.nextLine(); // read next line of input from user
	    Scanner s2 = new Scanner(line); // s2 will let me break 'line' apart
	    
	    if (s2.hasNextInt()) { // check to see if s2 would next see an integer number
		userGuess = s2.nextInt(); // read in that number
		if (userGuess < target) {
		    System.out.println("Too low! Guess again?");
		} else if (target < userGuess) {
		    System.out.println("Too high! Guess again?");
		} else {
		    System.out.println("You guessed it! It took you " + guessCount + " tries.");
		    break;
		}
	    } else {
		System.out.println("That's not a number! Please enter a numberrrrrr.. What's your number?");
		continue; // jump back to the top of the while loop
	    }

	}

    }

}
