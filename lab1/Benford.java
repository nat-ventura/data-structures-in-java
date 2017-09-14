import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author natventura
 *
 */

public class Benford {

    /**
     * @param args
     */
    public static final int maximumWidth = 50;

    public static void main(String[] args) {
	Scanner input = null;
	int[] digitCountArray = new int[10];
	try {
	    
	    input = new Scanner(new File(args[0]));
	    while (input.hasNext()) {
		String wholeString = input.next();
		String leadingDigit = wholeString.substring(0, 1);
		if (Character.isDigit(wholeString.charAt(0))) {
		    int a = Integer.parseInt(leadingDigit);
		    digitCountArray[a]++;
		}
	    }
	    int max = -1;
	    int count = 0;
	    for (int i : digitCountArray) {
		count += i;
		if (i > max) {
		    max = i;
		}
	    }
	    System.out.println("Welcome to my Benford analysis program."
	    	+ " Below is a histogram representing frequency distributions"
	    	+ " of digits in the supplied text file.");
	    for (int i = 0; i < digitCountArray.length; i++) {
		float digitFrequency = (float)digitCountArray[i] / (float)count*(float)100.0;
		System.out.printf("%d %8d %4.1f%% : ", i, digitCountArray[i], digitFrequency);
		for (int bins = 0; bins < (maximumWidth * digitCountArray[i] / max); bins++) {
		    System.out.print("*");
		}
		System.out.println();
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Could not find" + e.getMessage() + " found.");
	    System.exit(1);
	}
    }

}
