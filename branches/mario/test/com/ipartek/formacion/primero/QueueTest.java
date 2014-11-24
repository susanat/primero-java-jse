package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {

    static final String JAVA = "java";
    static final String NET = ".NET";
    static final String JAVASCRIPT = "JavaScript";
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
    public void testPila() {
	Queue<String> queue = new LinkedList<String>();

	queue.offer(JAVA);
	queue.offer(NET);
	queue.offer(JAVASCRIPT);
	queue.offer(HTML5);
	queue.offer(JQUERY);

	// Trabajar como si fuera FIFO
	assertEquals(5, queue.size());

	// peek NO elimina
	assertEquals(JAVA, queue.peek());
	assertEquals(5, queue.size());

	// pull SI elimina
	assertEquals(JAVA, queue.poll());
	assertEquals(4, queue.size());

	assertEquals(NET, queue.poll());
	assertEquals(3, queue.size());

	assertEquals(JAVASCRIPT, queue.poll());
	assertEquals(2, queue.size());

	assertEquals(HTML5, queue.poll());
	assertEquals(1, queue.size());

	assertEquals(JQUERY, queue.poll());
	assertEquals(0, queue.size());

	assertEquals(null, queue.poll());
	assertEquals(0, queue.size());

	try {
	    // remove lanza exception si no hay nada en la Queue
	    assertEquals(null, queue.remove());
	    fail("debería haber lanzado NoSuchElementException");
	} catch (NoSuchElementException e) {
	    assertTrue(true);
	}
    }

}
