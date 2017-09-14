import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 */

/**
 * @author natventura
 *
 */

public class Redactor {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Scanner redactFile = null;
	int wordCounter = 0;
	
	try {
	    redactFile = new Scanner(new File(args[0]));
	    while (redactFile.hasNextLine()) {
		++wordCounter;
		redactFile.nextLine();
	    }
	    String toRedact[] = new String[wordCounter];
	    Scanner scanner2 = new Scanner(new File(args[0]));
	    int lineCounter = 0;
	    while(scanner2.hasNextLine()) {
		toRedact[lineCounter] = scanner2.next();
		lineCounter++;
		scanner2.nextLine();
	    }
	    Scanner article = new Scanner(new File(args[1]));
	    ArrayList<String> articleArray = new ArrayList<String>();
	    while (article.hasNext()) {
		articleArray.add(article.next());
	    }
	    for (String s: articleArray) {
		for (String z: toRedact) {
		    if (s.equals(z)) {
			s = "XXXXXXX";
		    }
		}
		System.out.print(s + ' ');
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	}
    }

}
