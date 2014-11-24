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

/**
 * Ejemplo de Queue
 * 
 * @author Susana Costoya
 *
 */

public class Queue {

    static final String JAVA = "Java";
    static final String NET = "Net";
    static final String JS = "JavaScript";
    static final String HTML5 = "HTML5";
    static final String JQUERY = "Jquery";

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

	// you add elements to queue using offer method

	queue.offer(JAVA);
	queue.offer(NET);
	queue.offer(JS);
	queue.offer(HTML5);
	queue.offer(JQUERY);

	assertEquals(5, queue.size());

	// trabajar como si fuera FIFO
	assertEquals(JAVA, queue.peekFirst());// peek no elimina
	assertEquals(5, queue.size());

	assertEquals(JAVA, queue.pollFirst());// peek elimina
	assertEquals(4, queue.size());

	assertEquals(NET, queue.pollFirst());// peek elimina
	assertEquals(3, queue.size());

	assertEquals(JS, queue.pollFirst());// peek elimina
	assertEquals(2, queue.size());

	assertEquals(HTML5, queue.pollFirst());// peek elimina
	assertEquals(1, queue.size());

	assertEquals(JQUERY, queue.pollFirst());// peek elimina
	assertEquals(0, queue.size());

	assertEquals(null, queue.pollFirst());// Sino existen elementos
	assertEquals(0, queue.size());

	try {
	    assertEquals(null, queue.remove());// remove lanza una Exception
	    fail("Deberia haber lanzado NoSuchElementException ");

	} catch (NoSuchElementException e) {
	    assertTrue(true);

	}

    }

}
