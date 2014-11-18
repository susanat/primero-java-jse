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

	HashSet<String> hasSet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		hasSet = new HashSet<String>();
		hasSet.add(UNO);
		hasSet.add(DOS);
		hasSet.add(TRES);
	}

	@After
	public void tearDown() throws Exception {
		hasSet = null;
	}

	@Test
	public void testHashSet() {
		assertEquals(LONG_INICIAL, hasSet.size());
		assertFalse("Deberia estar vacio", hasSet.isEmpty());

		assertTrue(hasSet.contains(UNO));
		assertTrue(hasSet.contains(DOS));
		assertTrue(hasSet.contains(TRES));
		assertFalse(hasSet.contains(CUATRO));

		hasSet.add(CUATRO);
		assertEquals(LONG_INICIAL + 1, hasSet.size());
		hasSet.remove(CUATRO);

		assertTrue(hasSet.contains(DOS));
		// longitud ?--> no se incrementa xk set no permite elementos
		// duplicados, asik no lo añadira

		// assertEquals(LONG_INICIAL + 1, hasSet.size());

		hasSet.clear();
		assertTrue("Deberia estar vacio", hasSet.isEmpty());
		assertEquals(0, hasSet.size());

	}

}
