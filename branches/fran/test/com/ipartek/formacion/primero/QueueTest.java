package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {

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
	public void testCola() {
		Queue<String> q = new LinkedList<String>();

		q.offer("Java");
		q.offer("Net");
		q.offer("Html5");
		q.offer("Jscript");

		assertEquals(4, q.size());
		assertEquals("Java", q.peek());
		assertEquals(4, q.size());

		assertEquals("Java", q.poll());
		assertEquals(3, q.size());

	}

}
