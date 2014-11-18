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
	static final String TRES = "TRES";
	static final String CUATRO = "CUATRO";

	static final int INIT_LONG = 3;

	static HashSet<String> hashSet;

	// static HashSet<String> hashMap;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hashSet = new HashSet<String>();
		hashSet.add(UNO);
		hashSet.add(DOS);
		hashSet.add(TRES);
	}

	@After
	public void tearDown() throws Exception {
		hashSet = null;
	}

	@Test
	public void testHashSet() {
		assertEquals("La longitud del HashSet está mal.", INIT_LONG,
				hashSet.size());
		assertFalse("El HashSet debería tener datos.", hashSet.isEmpty());

		assertTrue(hashSet.contains(UNO));
		assertTrue(hashSet.contains(DOS));
		assertTrue(hashSet.contains(TRES));
		assertFalse(hashSet.contains(CUATRO));

		hashSet.add(CUATRO);
		assertTrue(hashSet.contains(CUATRO));
		assertEquals("La longitud del HashSet está mal.", INIT_LONG + 1,
				hashSet.size());
		hashSet.remove(CUATRO);

		// Con ésto se comprueba que HashSet no permite elementos duplicados
		hashSet.add(DOS);
		assertEquals("La longitud del HashSet está mal.", INIT_LONG,
				hashSet.size());

		hashSet.clear();
		assertTrue("El HashSet debería estar vacío.", hashSet.isEmpty());
		assertEquals("La longitud del HashSet está mal.", 0, hashSet.size());

	}

}
