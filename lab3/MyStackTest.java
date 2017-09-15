import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Stack;

/**
 * @author natventura
 *
 */

public class MyStackTest {
    @Test
    public void testSize() throws Exception {
	MyStack testStack = new MyStack<Square>();
	Stack realstack = new Stack();
	assertEquals("Sizes", testStack.size(), realstack.size());
    }
    
    @Test
    public void testPush() throws Exception {
	MyStack testStack = new MyStack<Square>();
	Stack realStack = new Stack<Square>();
	Square testSquare = new Square(3, 0, 0);
	testStack.push(testSquare);
	realStack.push(testSquare);
	assertEquals("Size", testStack.size(), realStack.size());
    }

    @Test
    public void testPop() throws Exception {
	MyStack testStack = new MyStack<Square>();
	Stack realStack = new Stack();
	Square testSquare = new Square(3, 0, 0);
	testStack.push(testSquare);
	realStack.push(testSquare);
	realStack.pop();
	testStack.pop();
	assertEquals("Size", testStack.size(), realStack.size());
    }

    @Test
    public void testPop() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }
}
