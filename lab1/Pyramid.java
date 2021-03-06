/**draws a pyramid out of *s
 * 
 */

/**
 * @author natventura
 *
 */

public class Pyramid {

    /**
     * @param args
     */
    public static void main(String[] args) {

	if (args.length != 1) {
	    System.out.println("I will draw a pyramid but please specify the pyramid height in the command line!\n"
	    	+ " i.e. `java Pyramid 6`");
	    System.exit(1);
	}
	int height = Integer.parseInt(args[0]);

	int i, space, k = 0;
	for (i = 1; i <= height; i++) {
	    for (space = 1; space <= height - i; space++) {
		System.out.print("  ");
	    }
	    while (k != (2 * i - 1)) {
		System.out.print("* ");
		k++;
	    }
	    k = 0;
	    System.out.println();
	}
	// TODO Auto-generated method stub

    }

}
