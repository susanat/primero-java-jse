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

	static final int TIRADA_MIN = 0;
	static final int TIRADA_MAX = Dado.ALUMNOS_TIRADA.length;

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
	public void testGetTirada() {

		int tirada = -1;
		String msg = null;

		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();

			msg = "la tirada " + tirada + " debe estar entre [" + TIRADA_MIN
					+ "," + TIRADA_MAX + "]";

			assertTrue(msg, (TIRADA_MIN <= tirada) && (TIRADA_MAX >= tirada));
		}

	}

	@Test
	public void testTodosLosParticipantes() {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < TIRADAS; i++) {
			hs.add(Dado.getTirada());
		}

		assertEquals(TIRADA_MAX, hs.size());
		for (int i = 0; i < TIRADA_MAX; i++) {
			assertTrue(hs.contains(i));
		}

	}
}