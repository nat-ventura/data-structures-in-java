import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author natventura
 *
 *
 */
public class MyQueue<T> implements QueueADT {
    public ArrayList<T> queue;

    @SuppressWarnings("unchecked")
    public MyQueue() {
	queue = new ArrayList<T>();
    }

    @Override
    public void enqueue(Object item) {
	queue.add((T) item);
    }

    @Override
    public T dequeue() {
	if (queue.size() != 0) {
		return queue.remove(0);
	} else {
		throw new NoSuchElementException();
	}
    }

    @Override
    public T front() {
	if (queue.size() != 0) {
	    return queue.get(0);
	} else {
	    throw new NoSuchElementException();
	}
    }

    @Override
    public int size() {
	return queue.size();
    }

    @Override
    public boolean isEmpty() {
	return queue.isEmpty();
    }

    @Override
    public void clear() {
	queue.clear();
    }
}
