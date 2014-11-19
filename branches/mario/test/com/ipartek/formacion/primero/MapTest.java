package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.util.Dado;

public class MapTest {
	static final int TIRADAS = 1000;
	static final int TIRADA_MAXIMA = Dado.ALUMNOS_TIRADA.length;
	static final int TIRADA_MINIMA = 0;

	HashMap<Integer, Boolean> map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		map = new HashMap<Integer, Boolean>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		int tirada = 0;
		String msg = null;

		for (int i = 0; i < TIRADAS; i++) {
			tirada = Dado.getTirada();
			msg = "La tirada " + tirada + "debe estar entre [" + TIRADA_MINIMA
					+ "," + TIRADA_MAXIMA + "]";

			map.put(tirada, true);

			assertTrue(msg, (TIRADA_MINIMA <= tirada)
					&& (TIRADA_MAXIMA >= tirada));

		}
		assertEquals(12, map.size());
		for (int j = 0; j < TIRADA_MAXIMA; j++) {
			assertTrue(map.get(j));
		}

	}

}
