package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestQueue {

    LinkedList<String> queue = new LinkedList<String>();

    static final String JAVA = "Java";
    static final String NET = "NET";
    static final String JAVASCRIPT = "javascript";
    static final String HTML5 = "HTML5";
    static final String HADOOP = "Hadoop";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testColaFIFO() {

	LinkedList<String> queue = new LinkedList<String>();

	queue.offer(JAVA);
	queue.offer(NET);
	queue.offer(JAVASCRIPT);
	queue.offer(HTML5);
	queue.offer(HADOOP);

	assertEquals(5, queue.size());

	// Trabajar como si fuera FIFO

	assertEquals(JAVA, queue.peekFirst()); // No elimina

	assertEquals(JAVA, queue.pollFirst());// Poll elimina
	assertEquals(4, queue.size());

	assertEquals(NET, queue.pollFirst());
	assertEquals(3, queue.size());

	assertEquals(JAVASCRIPT, queue.pollFirst());
	assertEquals(2, queue.size());

	assertEquals(HTML5, queue.pollFirst());
	assertEquals(1, queue.size());

	assertEquals(HADOOP, queue.pollFirst());
	assertEquals(0, queue.size());

	assertEquals(null, queue.pollFirst());
	assertEquals(0, queue.size());

	try {
	    assertEquals(null, queue.remove()); // Remove lanza
						// NoSuchElementException
	    fail("deberia haber lanzado la excepcion");
	} catch (NoSuchElementException ex) {
	    assertTrue(true);
	}
    }

}
