/**
 * @author natventura
 *
 */

public class MyQueue {
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
	    try {
		if (queue.size() != 0) {
		    return queue.remove(0);
		} else {
		    throw new NoSuchElementException();
		}
	    } catch (NoSuchElementException e) {
		System.out.println("Queue is empty.");
	    }
	    return null;
	}
    }
}
