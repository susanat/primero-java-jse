package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DadoTest {
	static final int TIRADAS = 1000;
	static final int TIRADA_MAXIMA = Dado.ALUMNOS_TIRADA.length;
	static final int TIRADA_MINIMA = 0;

	HashSet<Integer> setTiradas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		setTiradas = new HashSet<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTirada() {
		int tirada = 0;
		String msg = null;

		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			msg = "La tirada " + tirada + "debe estar entre [" + TIRADA_MINIMA
					+ "," + TIRADA_MAXIMA + "]";

			setTiradas.add(tirada);

			assertTrue(msg, (TIRADA_MINIMA <= tirada)
					&& (TIRADA_MAXIMA >= tirada));

		}
		assertEquals(12, setTiradas.size());

		assertTrue(setTiradas.contains(0));
		assertTrue(setTiradas.contains(1));
		assertTrue(setTiradas.contains(2));
		assertTrue(setTiradas.contains(3));
		assertTrue(setTiradas.contains(4));
		assertTrue(setTiradas.contains(5));
		assertTrue(setTiradas.contains(6));
		assertTrue(setTiradas.contains(7));
		assertTrue(setTiradas.contains(8));
		assertTrue(setTiradas.contains(9));
		assertTrue(setTiradas.contains(10));
		assertTrue(setTiradas.contains(11));

	}
}
