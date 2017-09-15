/**
 * TODO - your comments here
 */

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

    protected class MyListIterator implements ListIterator<T> {

        // TODO - your code here

    }


    // TODO - your code here

}

