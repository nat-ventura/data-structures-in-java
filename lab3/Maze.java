import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author natventura
 *
 */

public class Maze {
    private int numCols;
    private int numRows;
    private Square[][] mazeArray;
    private Square startSquare;
    private Square finishSquare;
    public boolean solvable = true;

    /**
     * Reads in text maze to initialize maze object as 2D array of squares
     * @param fileName
     * @return true if maze loads
     * @throws FileNotFoundException
     */
    
    public boolean loadMaze(String fileName) {
	try {
	    Scanner MAZE = new Scanner(new File(fileName));
	    numRows = MAZE.nextInt();
	    numCols = MAZE.nextInt();
	    mazeArray = new Square[numRows][numCols];
	    for (int row = 0; row < numCols; row++) {
		for (int col = 0; col < numCols; col++) {
		    mazeArray[row][col] = new Square(MAZE.nextInt(), row, col);
		    if (mazeArray[row][col].toString() == "S") {
			startSquare = mazeArray[row][col];
		    }
		    if (mazeArray[row][col].toString() == "E") {
			finishSquare = mazeArray[row][col];
		    }
		}
	    }
	    System.out.println(mazeArray.length);
	    reset();
	    return true;
	} catch (FileNotFoundException e) {
	    return false;
	}
    }

    /**
     * Receives neighbors of given square If statements to check if square is on
     * an edge of the maze or if neighboring square is a wall Stores values in
     * ArrayList "neighbors"
     * 
     * @param sq
     *            - the square whose neighbors you want
     * @return neighbors ArrayList
     */
    public ArrayList<Square> getNeighbors(Square sq) {
	int rowValue = sq.getRow();
	int colValue = sq.getCol();
	ArrayList<Square> neighbors = new ArrayList<Square>();

	// NORTH
	if (rowValue != 0) {
	    neighbors.add(mazeArray[rowValue - 1][colValue]);
	}
	// EAST
	if (colValue != numCols - 1) {
	    neighbors.add(mazeArray[rowValue][colValue + 1]);
	}
	// SOUTH
	if (rowValue != numRows - 1) {
	    neighbors.add(mazeArray[rowValue + 1][colValue]);
	}
	// WEST
	if (colValue != 0) {
	    neighbors.add(mazeArray[rowValue][colValue - 1]);
	}

	return neighbors;

    }

    /**
     * Finds startSquare of the maze
     * 
     * @return startSquare
     */
    public Square getStart() {
	return startSquare;
    }

    /**
     * Finds exit square of the maze
     * 
     * @return finishSquare
     */
    public Square getFinish() {
	return finishSquare;
    }

    /**
     * Resets the maze to initial configuration
     */
    public void reset() {
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		mazeArray[row][col].resetType();
	    }
	}
    }

    /**
     * Creates string representation of the maze
     * 
     * @return mazeString
     */
    public String toString() {
	String mazeString = "";
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		mazeString += mazeArray[row][col].toString();
	    }
	    mazeString += "\n";
	}
	return mazeString;
    }

    /**
     * @return numCols of the maze
     */
    public int getNumCols() {
	return numCols;
    }

    /**
     * @return numRows of the maze
     */
    public int getNumRows() {
	return numRows;
    }

    /**
     * @return mazeArray - 2D array of squares
     */
    public Square[][] getMazeArray() {
	return mazeArray;
    }
}