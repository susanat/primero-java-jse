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
	static final String CUATRO = "cuatro";
	static final int LONGITUD_INIAL = 3;
			
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
	public void test() {

		//Compruebo que la longitud del array sea el correcto
		assertEquals(LONGITUD_INIAL, hasSet.size());
		//compruebo que la coleccion no esta vacia
		assertFalse("deberia estar vacio", hasSet.isEmpty());
		
		assertTrue(hasSet.contains(UNO));
		assertTrue(hasSet.contains(DOS));
		assertTrue(hasSet.contains(TRES));
		
		assertFalse(hasSet.contains(CUATRO));
		hasSet.add(CUATRO);
		assertTrue(hasSet.contains(CUATRO));
		assertEquals(LONGITUD_INIAL + 1, hasSet.size());
		hasSet.remove(CUATRO);
		
		//No permite elementos duplicados
		hasSet.add(DOS);
		assertEquals(LONGITUD_INIAL, hasSet.size());
		
		hasSet.clear();
		assertTrue("deberia estar vacio", hasSet.isEmpty());
		assertEquals(0, hasSet.size());
	}

}
