package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.util.Arrays;
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
	private static final int LONGITUD_INICIAL = 3;
	private static final String CUATRO = "cuatro";
	
	HashSet<String> hashSet;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		hashSet = new HashSet<String>
		(
				Arrays.asList(
						UNO, 
						DOS,
						TRES
						)				
		);
	}

	@After
	public void tearDown() throws Exception {
		hashSet = null;
	}

	@Test
	public void test() {
		
		assertEquals(LONGITUD_INICIAL, hashSet.size());
		assertFalse("devería estar vacío", hashSet.isEmpty());
		
		assertTrue( hashSet.contains(UNO));
		assertTrue( hashSet.contains(DOS));
		assertTrue( hashSet.contains(TRES));
		
		assertFalse( hashSet.contains(CUATRO));
		
		
		
	}

}
