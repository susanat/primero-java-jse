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
	HashSet<String> hasSetAlumnos;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hasSetAlumnos = new HashSet<String>();
	}

	@After
	public void tearDown() throws Exception {
		hasSetAlumnos = null;
	}

	@Test
	public void testGetTirada() {
		int tirada;
		String msg = "";

		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			msg = "la tirada " + tirada + "debe de estar entre [" + TIRADA_MIN
					+ "," + TIRADA_MAX + "]";
			assertTrue(msg, (tirada >= TIRADA_MIN) && (tirada < TIRADA_MAX));

			// Se agnada los alumnos que van saliendo
			hasSetAlumnos.add(Dado.ALUMNOS_TIRADA[tirada]);
		}

		// Recorremos el array de alumnos y comprobamos que esten todos en el
		// HasSet
		assertEquals(hasSetAlumnos.size(), TIRADA_MAX);
		for (int i = TIRADA_MIN; i < TIRADA_MAX; i++) {
			assertTrue(hasSetAlumnos.contains(Dado.ALUMNOS_TIRADA[i]));
		}
	}

}
