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
	static final int LONGITUD_INICIAL = 3;

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
		assertEquals(LONGITUD_INICIAL, hasSet.size());
		assertFalse("deberia estar vacio", hasSet.isEmpty());

		assertTrue(hasSet.contains(UNO));
		assertTrue(hasSet.contains(DOS));
		assertTrue(hasSet.contains(TRES));
		assertFalse(hasSet.contains(CUATRO));

		hasSet.add(CUATRO);
		assertTrue(hasSet.contains(CUATRO));
		assertEquals(LONGITUD_INICIAL + 1, hasSet.size());
		hasSet.remove(CUATRO);

		// NOTA: NO permite elementos duplicados
		hasSet.add(DOS);
		assertEquals(LONGITUD_INICIAL, hasSet.size());

		hasSet.clear();
		assertTrue("deberia estar vacio", hasSet.isEmpty());
		assertEquals(0, hasSet.size());
	}

}
