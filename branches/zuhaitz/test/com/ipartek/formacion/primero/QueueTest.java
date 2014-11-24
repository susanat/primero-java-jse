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

	static final String JAVA = "Java";
	static final String NET = "NET";
	static final String JS = "Javascript";
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
	public void test() {
		final Queue<String> queue = new LinkedList<String>();
		queue.add(JAVA);
		queue.offer(NET);
		queue.offer(JS);
		queue.offer(HTML5);
		queue.offer(JQUERY);

		assertEquals(5, queue.size());

		// Trabajar como si fuera FIFO
		// peek no elimina, solo se posiciona en el primero
		assertEquals(JAVA, ((LinkedList<String>) queue).peekFirst());
		assertEquals(5, queue.size());

		// poll lo elimina
		assertEquals(JAVA, ((LinkedList<String>) queue).pollFirst());
		assertEquals(4, queue.size());

		assertEquals(NET, ((LinkedList<String>) queue).pollFirst());
		assertEquals(3, queue.size());

		assertEquals(JS, ((LinkedList<String>) queue).pollFirst());
		assertEquals(2, queue.size());

		assertEquals(HTML5, ((LinkedList<String>) queue).pollFirst());
		assertEquals(1, queue.size());

		assertEquals(JQUERY, ((LinkedList<String>) queue).pollFirst());
		assertEquals(0, queue.size());

		assertEquals(null, ((LinkedList<String>) queue).pollFirst());
		assertEquals(0, queue.size());

		try {
			assertEquals(null, ((LinkedList<String>) queue).remove());
			fail("Debería haber lanzado NoSuchElementException.");
		} catch (final NoSuchElementException e) {
			assertTrue(true);
		}
	}
}
