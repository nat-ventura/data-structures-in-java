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

}
