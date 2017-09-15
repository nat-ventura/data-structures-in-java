import java.util.*;

public class MyLinkedList<T> extends AbstractList<T>  {

    Node head;
    Node tail;

    protected class Node {
        T data;
        Node next;
        Node prev;
    }

    public MyLinkedList() {
	head = new Node();
	tail = new Node();
	head.next = tail;
	tail.prev = head;
    }

    private Node getNth(int index) throws Exception {
	if (index < 0 || index > this.size()) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node p = new Node();
	    p = head.next;
	    int count = 0;
	    while (count != index) {
		p = p.next;
		count++;
	    }
	    return p;
	}
    }

    // public ListIterator<T> listIterator() {
    // MyListIterator n = new MyListIterator();
    // return n;
    // }

    // public Iterator<T> iterator() {
    // ListIterator n = new MyListIterator();
    // return n;
    // }

    protected class MyListIterator implements ListIterator<T> {

	private Node iterator = head;
	private Node lastIterator = null;

	private int nCalled = 0;
	private int pCalled = 0;

	private int aCalled = 0;
	private int rCalled = 0;

	// renames method add1...
	public void add1(T x) {
	    Node middleFriend = new Node();
	    middleFriend.data = x;
	    Node lastFriend = iterator.next;

	    Node firstFriend = iterator;

	    // this is the doubly linked part lol
	    firstFriend.next = middleFriend;
	    middleFriend.next = lastFriend;
	    lastFriend.prev = middleFriend;
	    middleFriend.prev = firstFriend;

	    iterator = lastFriend;

	}

	@Override
	public boolean hasNext() {
	    if (iterator.next != tail) {
		return true;
	    } else {
		return false;
	    }
	}

	@Override
	public boolean hasPrevious() {
	    if (iterator.prev != head) {
		return true;
	    } else {
		return false;
	    }
	}

	@Override
	public T next() {
	    if (this.hasNext() == false) {
		throw new NoSuchElementException();
	    } else {
		nCalled = 1;
		pCalled = 0;
		aCalled = 0;
		rCalled = 0;

		lastIterator = iterator;
		iterator = iterator.next;
		T item = iterator.data;
		return item;
	    }
	}

	@Override
	public T previous() {
	    if (hasPrevious() == false) {
		throw new NoSuchElementException();
	    } else {
		pCalled = 1;
		nCalled = 0;
		rCalled = 0;
		aCalled = 0;
		lastIterator = iterator;
		T item = iterator.data;
		iterator = iterator.prev;
		return item;
	    }
	}

	@Override
	public int nextIndex() {
	    if (this.hasNext() == false) {
		if (iterator == tail) {
		    return this.size();
		} else {
		    throw new NoSuchElementException();
		}
	    } else {
		Node p = iterator.next;
		Node q = head;
		int index = 0;
		while (q != p) {
		    q = q.next;
		    index++;
		}
		return index;

	    }
	}

	@Override
	public int previousIndex() {
	    if (hasPrevious() == false) {
		if (iterator == head) {
		    return -1;
		} else {
		    throw new NoSuchElementException();
		}
	    } else {
		Node p = iterator.prev;
		Node q = head;
		int index = 0;
		while (q != p) {
		    q = q.next;
		    index++;
		}
		return index;
	    }
	}

	public T get(int arg0) {
	    return null;
	}

	public int size() {
	    int size = 0;
	    Node p = head;
	    while (p.next != null && p.next != tail) {
		p = p.next;
		size++;
	    }
	    return size;
	}

	public void remove() {
	    if (lastIterator == null) {
		throw new IllegalStateException();
	    } else {
		if (aCalled = 1) {
		    throw new IllegalStateException();
		} else {
		    aCalled = 0;
		    rCalled = 1;
		    if (nCalled == 1 && pCalled == 0) {
			Node x = lastIterator.prev;
			Node y = lastIterator.next;
			T item = lastIterator.data;
			x.next = y;
			y.prev = x;
			lastIterator = null;
		    } else if (pCalled == 1 && nCalled == 0) {
			Node y = lastIterator.prev;
			Node x = lastIterator.next;
			T item = lastIterator.data;
			y.next = x;
			x.prev = y;
			lastIterator = null;
		    }
		}
	    }
	}

	@Override
	public void set(T x) {
	    if (lastIterator == null) {
		throw new IllegalStateException();
	    } else {
		if (rCalled == 1 || aCalled == 1) {
		    throw new IllegalStateException();
		} else {
		    lastIterator.data = x;
		}
	    }
	}

	@Override
	public T get(int arg0) {
	    try {
		return this.getData(arg0)
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public int size() {
	    int size = 0;
	    Node p = head;
	    while (p.next != null && p.next != tail) {
		p = p.next;
		size++;
	    }
	    return size;
	}

	public boolean add(T data) {
	    Node p = tail.prev;
	    Node x = new Node();
	    x.data = data;
	    p.next = x;
	    tail.prev = x;
	    x.next = tail;
	    x.prev = p;
	    return true;
	}

	public void add (int index, T data) {
	    if (data == null) {
		throw new NullPointerException()
	    } else if (index < 0 || index > this.size()) {
		throw new IndexOutOfBoundsException();
	    } else {
		if (index == 0) {
		    Node p = head.next;
		    Node x = new Node();
		    x.data = data;
		    head.next = x;
		    p.prev = x;
		    x.next = p;
		    x.prev = head;
		} else if (index == this.size()) {
		    Node p = tail.prev;
		    Node x = new Node();
		    x.data = data;
		    p.next = x;
		    tail.prev = x;
		    x.next = tail;
		    x.prev = p;
		} else {
		    Node p = null;
		    try {
			p = (Node) this.getNth(index);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    Node y = p.next;
		    Node x = new Node();
		    x.data = data;
		    p.next = x;
		    x.next = y;
		    y.prev = x;
		    x.prev = p;
		}
	    }
	}

	public T getData(int index) throws Exception {
	    if (index < 0 || index > this.size()) {
		throw new IndexOutOfBoundsException();
	    } else {
		Node p = this.getNth(index);
		return p.data;
	    }
	}

	public T remove() {
	    Node p = tail.prev;
	    Node q = p.prev;
	    q.next = tail;
	    tail.prev = q;
	    return p.data;
	}

	public void set(T data, int index) throws Exception {
	    if (data == null) {
		throw new NullPointerException();
	    } else if (index < 0 || index > this.size() - 1) {
		throw new IndexOutOfBoundsException();
	    } else {
		Node p = this.getNth(index);
		p.data = data;
	    }
	}

	public T remove(int index) {
	    if (index < 0 || index > this.size() - 1) {
		throw new IndexOutOfBoundsException();
	    } else {
		if (index == this.size() - 1) {
		    return this.remove(index);
		} else {
		    Node p = null;
		    try {
			p = (Node) this.getNth(index - 1);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    Node y = p.next.next;
		    Node x = p.next;

		    p.next = y;
		    y.prev = p;
		    return x.data;
		}
	    }
	}

	public void clear() {
	    tail = head.next;
	    head = tail.prev;
	}

	public boolean isEmpty() {
	    if (head.next == tail) {
		return true;
	    } else {
		return false;
	    }
	}

	@Override
	public boolean contains(Object o) {
	    Node p = head.next;
	    while (p != tail) {
		if (p.data == (T) o) {
		    return true;
		}
		p = p.next;
	    }
	    return false;
	}

    }

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * @return
     */
    @Override
    public int size() {
	// TODO Auto-generated method stub
	return 0;
    }

}

