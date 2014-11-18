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
		setTiradas = null;
	}

	@Test
	public void testGetTirada() {
		int tirada = -1;
		String msg = null;

		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			setTiradas.add(tirada);
			msg = "La tirada " + tirada + " de dado debe estar entre "
					+ TIRADA_MIN + " y " + TIRADA_MAX + ".";

			assertTrue(msg, TIRADA_MIN <= tirada && TIRADA_MAX >= tirada);
		}

		assertEquals("El tamaño del HashSetes incorrecto.", TIRADA_MAX,
				setTiradas.size());
		for (int i = 0; i < TIRADA_MAX; i++) {
			assertTrue("El valor " + i + " no está en el HashSet.",
					setTiradas.contains(i));
		}
	}

}
