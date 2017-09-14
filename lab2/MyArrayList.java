import java.util.AbstractList;

/**
 * 
 */

/**
 * @author natventura
 *
 */

public class MyArrayList<AnyType> extends AbstractList<AnyType> {
    private int size;
    private AnyType[] data;

    /**
     * Constructs my own ArrayList..
     * 
     * @param startSize
     */

    @SuppressWarnings("unchecked")
    public MyArrayList(int startSize) {
	int x = 1;
	while (x < startSize) {
	    x *= 2;
	}
	data = (AnyType[]) new Object[x];
    }

    /**
     * Creates an ArrayList with length 2
     */
    public MyArrayList() {
	this(2);
    }

    /**
     * Doubles size of the ArrayList
     */
    private void resize() {
	int x = data.length;
	AnyType[] newData = (AnyType[]) new Object[2 * x];
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }

    /**
     * Returns number of elements in ArrayList
     * @return
     */
    public int size() {
	int counter = 0;
	for (int z = 0; z < data.length; z++) {
	    if (data[z] != null) {
		counter++;
	    }
	}
	return counter;
    }

    /**
     * Adds element to chosen index
     * All other elements are shifted right
     * @param index
     * @param element
     */
    public void add(int index, AnyType element) {
	if (index > size()) {
	    throw new IndexOutOfBoundsException("The highest index you can enter is the first unused index");
	}
	else {
	    if (data.length == size()) {
		resize();
	    }
	    int j = size();
	    while (j > index) {
		AnyType temp = data[j - 1];
		data[j] = temp;
		j--;
	    }
	    data[index] = element;
	}
    }

    /**
     * Adds element to end of ArrayList
     * 
     * @param element
     * @return
     */
    public boolean add(AnyType element) {
	if (data.length == size()) {
	    resize();
	}
	add(size(), element);
	return true;
    }

    /**
     * Returns the value at the specified index
     * 
     * @param index
     * @return
     */
    public AnyType get(int index) {
	if (index > size() - 1) {
	    throw new IndexOutOfBoundsException("The index you entered is out of range.");
	} else {
	    return data[index];
	}
    }

}
