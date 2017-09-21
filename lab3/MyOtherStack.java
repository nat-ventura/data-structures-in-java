import java.util.*;

/**
 * @author natalievillasana
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


}
