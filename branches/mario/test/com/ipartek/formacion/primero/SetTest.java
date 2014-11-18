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
	HashSet<String> hashSet;

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
	public void test() {

		assertEquals(LONGITUD_INICIAL, hashSet.size());
		assertFalse("deberia estar vacio", hashSet.isEmpty());

		assertTrue(hashSet.contains(UNO));
		assertTrue(hashSet.contains(DOS));
		assertTrue(hashSet.contains(TRES));
		assertFalse(hashSet.contains(CUATRO));

		hashSet.add(CUATRO);
		assertTrue(hashSet.contains(CUATRO));
		assertEquals(LONGITUD_INICIAL + 1, hashSet.size());
		hashSet.remove(CUATRO);

		hashSet.add(DOS);
		// SET no permite elementos duplicados --> DOS ya existe
		assertEquals(LONGITUD_INICIAL, hashSet.size());

		hashSet.clear();
		assertTrue("deberia estar vacio", hashSet.isEmpty());
		assertEquals(0, hashSet.size());
	}

}
