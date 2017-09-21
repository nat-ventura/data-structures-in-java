import java.util.*;

/**
 * @author natventura
 *
 */

public class MyOtherStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    private int top = 0;

    public int size() {
	return top;
    }

    public void push(T item) {
	stack.add(top++, item);
    }

    public T pop() {
	return stack.remove(--top);
    }

    public static void main(String[] args) {
	MyOtherStack<Integer> s = new MyOtherStack<Integer>();
	s.push(17);
	int i = s.pop();
	System.out.format("%4d%n", i);

    }

}
