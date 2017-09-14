import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * 
 */

/**
 * @author natventura
 *
 */

public class MyArrayListTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMyArrayList() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
    }

    @Test
    public void testSize() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
	test.add(0, 5);
	real.add(0, 5);
	assertEquals("Size after add", real.size(), test.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(test.size() + 1, 5);
    }

    @Ignore
    public void testAddIntEFront() throws FileNotFoundException {
	Scanner c = new Scanner(new File("test1.txt"));
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	while (c.hasNextLine()) {
	    String s = c.nextLine();
	    test.add(0, s);
	    real.add(0, s);
	}
	if (test.size() == real.size()) {
	    for (int i = 0; i < real.size(); i++) {
		assertSame(test.get(i), real.get(i));
	    }
	}
    }

    @Ignore
    public void testAddIntEBack() throws FileNotFoundException {
	Scanner c = new Scanner(new File("test1.txt"));
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	while (c.hasNextLine()) {
	    String s = c.nextLine();
	    test.add((test.size() / 2), s);
	    real.add((real.size() / 2), s);
	}
	if (test.size() == real.size()) {
	    for (int i = 0; i < real.size(); i++) {
		assertSame(test.get(i), real.get(i));
	    }
	}
    }

    @Ignore
    public void testGet() throws Exception {
	MyArrayList<Integer> test = new MyArrayList();
	ArrayList<Integer> real = new ArrayList<Integer>();
	test.add(1);
	real.add(1);
	test.add(2);
	real.add(2);
	test.add(0, 0);
	real.add(0, 0);
	assertEquals("Size after construction: ", test.get(1), real.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsGet() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(1);
	test.add(2);
	test.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsGet2() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(1);
	test.add(2);
	test.get(-1);
    }

}
