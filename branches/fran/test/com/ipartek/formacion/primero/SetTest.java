package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

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
	static final int LONGITUD_INICIAL = 3;

	HashSet<String> hashSet;

	// HashMap<int,String> hashMap;

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
		assertFalse(hashSet.isEmpty());

		assertTrue(hashSet.contains(UNO));
		assertTrue(hashSet.contains(DOS));
		assertTrue(hashSet.contains(TRES));

		hashSet.add(DOS);
		assertEquals(LONGITUD_INICIAL, hashSet.size());

		hashSet.clear();
		assertEquals(0, hashSet.size());
	}

}
