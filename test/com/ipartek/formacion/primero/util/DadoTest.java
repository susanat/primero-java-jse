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

			assertTrue(msg, (TIRADA_MINIMA <= tirada)
					&& (TIRADA_MAXIMA >= tirada));

		}

	}

	public void testTodosLosParticipantes() {
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < TIRADAS; i++) {
			hs.add(Dado.getTirada());
		}

		assertEquals(TIRADA_MAXIMA, hs.size());

		for (int j = 0; j < TIRADA_MAXIMA; j++) {
			assertTrue(hs.contains(j));
		}

	}
}
