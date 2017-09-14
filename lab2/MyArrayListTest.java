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

    @Ignore
    public void testRemove() throws FileNotFoundException {
	Scanner c = new Scanner(new File("test1.txt"));
	MyArrayList<String> test = new MyArrayList<String>();
	MyArrayList<String> second = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	ArrayList<String> real2 = new ArrayList<String>();

	while (c.hasNext()) {
	    String s = c.next();
	    test.add(s);
	    real.add(s);
	}
	for (int i = 0; i < test.size(); i++) {
	    if (i % 2 == 0) {
		second.add(test.remove(i));
		real2.add(real.remove(i));
	    }
	}
	for (int i = 0; i < second.size(); i++) {
	    assertSame("Same string?", real2.get(i), second.get(i));
	}
	System.out.println(test);
	System.out.println(second);
	System.out.println(real);
	System.out.println(real2);
    }

    @Ignore
    public void testSet() throws FileNotFoundException {
	Scanner c = new Scanner(new File("test1.txt"));
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	ArrayList<String> real2 = real;
	MyArrayList<String> test2 = test;

	while (c.hasNext()) {
	    String s = c.next();
	    test.add(s);
	    real.add(s);
	}
	for (int i = 0; i < test.size(); i++) {
	    String q = test.get(test.size() - i - 1);
	    String r = real.get(real.size() - i - 1);
	    test2.set(i, q);
	    real2.set(i, r);
	}

	for (int i = 0; i < test2.size(); i++) {
	    assertSame("Same string?", real.get(i), test2.get(i));
	}
    }

    @Ignore
    public void testAdd() throws Exception {
	MyArrayList<Integer> test = new MyArrayList();
	ArrayList<Integer> real = new ArrayList<Integer>();
	test.add(1);
	real.add(1);
	test.add(2);
	real.add(2);
	test.add(0, 0);
	real.add(0, 0);
	assertEquals("Size after construction: ", test.size(), real.size());
    }

    @Ignore
    public void isEmptyTest() {
	MyArrayList<String> test = new MyArrayList<String>();
	assertTrue(test.isEmpty());
    }

    @Ignore
    public void clearTest() throws FileNotFoundException {
	Scanner c = new Scanner(new File("test1.txt"));
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	while (c.hasNext()) {
	    String s = c.next();
	    test.add(s);
	    real.add(s);
	}
	test.clear();
	real.clear();
	assertEquals(true, test.isEmpty());
	assertEquals(true, real.isEmpty());
    }

    @Ignore
    public void testAddEfficiency() throws InterruptedException {
	int counter = 0;
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	for (int i = 0; i < 100000; i++) {
	    int addMe = test.size();
	    test.add(addMe);
	    counter++;
	    if (counter == 100000) {
		System.out.println(test.size());
		counter = 0;
	    }
	}
    }

    @Ignore
    public void testRemoveEfficiency() throws InterruptedException {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	for (int i = 0; i < 100000; i++) {
	    test.add(i);
	}
	int counter = 0;
	for (int j = 99999; j >= 0; j--) {
	    test.remove(j);
	    counter++;
	    if (counter == 100000) {
		System.out.println(test.size());
		counter = 0;
	    }
	}
	System.out.println(test.size());
    }

    @Test
    public void testMemory() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	for (int i = 0; i < 100000; i++) {
	    while (9 < i) {
		i /= 10;
	    }
	    if (Math.abs(i) == 1) {
		test.add(i);
		if ((i % 10000) == 0) {
		    System.out.println(i);
		}
	    }
	}
    }


}
