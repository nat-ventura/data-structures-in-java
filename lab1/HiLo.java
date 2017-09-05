import java.util.Random;
import java.util.Scanner;

/**picks a random number, user guesses what it is
 * 
 */

/**
 * @author natalievillasana
 *
 */

public class HiLo {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Random rnd = new Random();
	int target = rnd.nextInt(1000) + 1;
	int userGuess = -1;
	Scanner input = new Scanner(System.in); // reading user input

	while (input.hasNextLine()) { // keep looping for each guess, use
				      // 'break' to exit
	    String line = input.nextLine(); // read next line of input from user
	    Scanner s2 = new Scanner(line); // s2 will let me break 'line' apart
	    if (s2.hasNextInt()) { // check to see if s2 would next see an
				   // integer number
		// do something here!
		userGuess = s2.nextInt(); // read in that number
	    } else {
		System.out.println("That's not a number! Please enter a numberrrrrr..");
		continue; // jump back to the top of the while loop
	    }

	    // more here!

	}

    }

}
