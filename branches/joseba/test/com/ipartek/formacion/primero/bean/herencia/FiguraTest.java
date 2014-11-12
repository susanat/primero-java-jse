package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FiguraTest {

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
	public void testLinea() {
		// Test para la clase Linea

		Linea l1 = new Linea(20, 30);
		new Linea(20, 30);
		assertTrue(l1 instanceof Figura);
		assertEquals(l1.getLongitud(), 1);
	}

}
