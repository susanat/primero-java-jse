package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DadoTest {
	static final int TIRADAS = 1000;
	static final int TIRADAS_MIN = 0;
	static final int TIRADAS_MAX = Dado.ALUMNOS_TIRADA.length;

	HashSet<Integer> hasSet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hasSet = new HashSet<Integer>(TIRADAS_MAX);
	}

	@After
	public void tearDown() throws Exception {
		hasSet = null;
	}

	@Test
	public void testTirar() {
		int tirada = -1;
		String msg = null;
		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();

			hasSet.add(tirada);

		}

		for (int i = 0; i < TIRADAS_MAX; i++) {
			msg = "El elemento " + Dado.ALUMNOS_TIRADA[i]
					+ " no sale nunca en las tiradas";
			assertTrue(msg, hasSet.contains(i));

		}

	}

	@Test
	public void testGetTirada() {
		int tirada = -1;
		String msg = null;
		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			msg = "la tirada " + tirada + " debe estar entre [ " + TIRADAS_MIN
					+ " y " + TIRADAS_MAX + " ]";

			assertTrue(msg, (TIRADAS_MIN <= tirada) && (tirada <= TIRADAS_MAX));
		}
	}
}
