package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetTest {

	HashSet<String> hashSet;
	private static final String UNO = "uno";
	private static final String DOS = "dos";
	private static final String TRES = "tres";
	private static final String CUATRO = "CUATRO";
	private static final int LONGITUDINICIAL = 3;

	// HashMamp<int,String>

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
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		assertFalse(hashSet.isEmpty());
		assertTrue(hashSet.contains(UNO));
		assertTrue(hashSet.contains(DOS));
		assertTrue(hashSet.contains(TRES));
		assertFalse(hashSet.contains(CUATRO));

		hashSet.add(CUATRO);
		assertTrue(hashSet.contains(CUATRO));
		hashSet.remove(CUATRO);
		assertTrue(hashSet.size() == LONGITUDINICIAL);

		hashSet.clear();
		assertTrue(hashSet.size() == 0);

	}
}
