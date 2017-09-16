import java.awt.Point;

/**
 * @author natventura
 *
 */

public class Square {

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;

    public static final int WORKLIST = 4;
    public static final int EXPLORED = 5;
    public static final int FINALPATH = 6;
    // public static final int UNEXPLORED = 7;

    private Point location;
    private int squareType;
    private int finalType;
    // private int status;
    private Square squarePrevious;

    /**
     * Constructor for square
     * 
     * @param typeInt
     *            - integer value representing square type
     * @param Row
     *            Row value - to set square's x-coord
     * @param Column
     *            column value - to set square's y-coord
     */
    public Square(int typeInt, int Row, int Column) {
	squareType = typeInt;
	location = new Point(Row, Column);
	finalType = typeInt;
	squarePrevious = null;
	/*
	 * if (squareType == SPACE) { status = UNEXPLORED; }
	 */
    }
    
    /**
     * Receives squareType
     * 
     * @return String representation of squareType
     */
/*
    public int setStatus(int statusType) {
	if (squareType == SPACE) {
	    status = statusType;
	    return 1;
	}
	return 0;// you could throw an error here if you wanted too
    }
*/

    public String toString() {
	switch (squareType) {
	case SPACE:
	    return "_";
	case WORKLIST:
	    return "o";
	case EXPLORED:
	    return ".";
	case FINALPATH:
	    return "x";
	case WALL:
	    return "#";
	case START:
	    return "S";
	case EXIT:
	    return "E";
	default:
	    return "None";
	}

    }

    /**
     * Gets squareType
     * 
     * @return squareType, integer representation of squareType
     */
    public int getType() {
	return squareType;
    }

    /**
     * Sets squareType to WORKLIST, EXPLORED, or FINALPATH
     * 
     * @param newType
     */
    public void typeSet(int newType) {
	squareType = newType;
    }

    /**
     * Resets square to initial type instead of WORKLIST, EXPLORED, or FINALPATH
     */
    public void resetType() {
	squareType = finalType;
    }

    /**
     * Gets row coordinate of square
     * 
     * @return row coordinate
     */
    public int getRow() {
	int x = (int) location.getX();
	return x;
    }

    /**
     * Gets column coordinate of square
     * 
     * @return column coordinate
     */
    public int getCol() {
	int Y = (int) location.getY();
	return Y;
    }

    /**
     * Checks if square is EXPLORED, WALL, or WORKLIST.. Helps determine a
     * FINALPATH and confirms that WALLS are marked as WALLS
     * 
     * @return boolean - true if square is marked or a WALL
     */
    public boolean isMarked() {
	if (squareType == 4 || squareType == 5 || squareType == WALL) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Sets the class variable indicating which square added item to the
     * WORKLIST Necessary for determining a FINALPATH
     * 
     * @param sq
     *            - the square to be set as squarePrevious
     */
    public void setSquarePrevious(Square sq) {
	squarePrevious = sq;
    }

    /**
     * Gets a square's squarePrevious Used in constructing FINALPATH
     * 
     * @return squarePrevious
     */
    public Square getSquarePrevious() {
	return squarePrevious;
    }
}
