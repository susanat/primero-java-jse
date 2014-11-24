package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {

	static final String JAVA = "Java";
	static final String NET = "Net";
	static final String JS = "JavaScript";
	static final String HTML5 = "HTML5";
	static final String JQUERY = "jQuery";

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

		// añadir elementos a queue
		queue.add(JAVA);
		queue.offer(NET);
		queue.offer(JS);
		queue.offer(HTML5);
		queue.offer(JQUERY);

		assertEquals(5, queue.size());

		// Trabajar como si fuera FIFO

		assertEquals(JAVA, queue.peekFirst());// peek no elimina
		assertEquals(5, queue.size());

		assertEquals(JAVA, queue.pollFirst());// poll elimina
		assertEquals(4, queue.size());

		assertEquals(NET, queue.pollFirst());// poll elimina
		assertEquals(3, queue.size());

		assertEquals(JS, queue.pollFirst());// poll elimina
		assertEquals(2, queue.size());

		assertEquals(HTML5, queue.pollFirst());// poll elimina
		assertEquals(1, queue.size());

		assertEquals(JQUERY, queue.pollFirst());// poll elimina
		assertEquals(0, queue.size());

		assertEquals(null, queue.pollFirst());// poll elimina
		assertEquals(0, queue.size());

		try {

			assertEquals(null, queue.remove());
			fail("deberia haber lanzado NoSuchElementException");

		} catch (NoSuchElementException e) {
			assertTrue(true);
		}

	}

}
