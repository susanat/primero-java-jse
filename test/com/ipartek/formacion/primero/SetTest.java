package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetTest {

	static final String UNO = "uno";
	static final String DOS = "dos";
	static final String TRES = "tres";
	static final String CUATRO = "cuatro";
	static final int LONG_INICIAL = 3;
	HashSet<String> hs;

	// HashMap<int, String> hm;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hs = new HashSet<String>();
		hs.add(UNO);
		hs.add(DOS);
		hs.add(TRES);
	}

	@After
	public void tearDown() throws Exception {
		hs = null;
	}

	@Test
	public void testHashSet() {
		assertEquals(LONG_INICIAL, hs.size());
		assertFalse(hs.isEmpty());
		assertTrue(hs.contains(UNO));
		assertTrue(hs.contains(DOS));
		assertTrue(hs.contains(TRES));
		assertFalse(hs.contains(CUATRO));
		hs.add(CUATRO);
		assertEquals(LONG_INICIAL + 1, hs.size());
		hs.remove(CUATRO);

		// No se permiten elementos duplicados asi que lo añadimos pero el
		// tamaño no cambia porque ese elemento ya existe
		hs.add(DOS);
		assertEquals(LONG_INICIAL, hs.size());

		// Borramos todos los elementos por lo que la longitud ahora es 0
		hs.clear();
		assertEquals(0, hs.size());
		assertTrue(hs.isEmpty());
	}

}
