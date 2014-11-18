package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDado {

	static final int TIRADAS = 1000;
	static final int TIRADA_MIN = 0;
	static final int TIRADA_MAX = Dado.ALUMNOS_TIRADA.length;

	HashMap<Integer, String> hm;
	HashMap<String, Integer> hm2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hm = new HashMap<Integer, String>();
		hm2 = new HashMap<String, Integer>();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTirada() {
		int tirada = -1;
		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			hm.put(tirada, Dado.ALUMNOS_TIRADA[tirada]);
			if (hm2.get(Dado.ALUMNOS_TIRADA[tirada]) == null) {
				hm2.put(Dado.ALUMNOS_TIRADA[tirada], 1);

			} else {
				hm2.put(Dado.ALUMNOS_TIRADA[tirada],
						hm2.get(Dado.ALUMNOS_TIRADA[tirada]) + 1);
			}

			/*
			 * assertTrue("La tirada " + tirada + "debe estar entre " +
			 * TIRADA_MIN + " y " + TIRADA_MAX, (TIRADA_MIN <= tirada) &&
			 * (TIRADA_MAX >= tirada));
			 */
		}
		assertEquals("No han salido todos los alumnos al menos una vez",
				Dado.ALUMNOS_TIRADA.length, hm.size());
		assertEquals(Dado.ALUMNOS_TIRADA.length, hm2.size());

		// Vamos a iterar sobre el HashMap usando un Iterator y vamos a ir
		// lanzando un test por cada uno de los alumnos comprobando que su
		// numero es mayor que cero, lo que demostraría que todos han salido mas
		// de una vez
		Iterator<Map.Entry<String, Integer>> iterator = hm2.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			assertTrue(entry.getValue() > 0);
			System.out.println(entry.getKey() + " --> " + entry.getValue());

		}

	}
}
