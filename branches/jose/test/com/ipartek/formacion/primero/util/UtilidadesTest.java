package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilidadesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsVocal() {

		//test vocales
		char[] vocales = new char[]{'a','e','i','o','u','á','é','í','ó','ú'};
		for (int i = 0; i < vocales.length; i++) {
			assertTrue("la vocal [" + vocales[i] + "] deberia ser true", Utilidades.isVocal( vocales[i]) );
			assertTrue("la vocal Mayuscula [" + Character.toUpperCase(vocales[i]) + "] deberia ser true", Utilidades.isVocal( Character.toUpperCase(vocales[i]) ) );			
		}
		
		//test NO vocales
		char[] noVocales = new char[]{'m','p','^',' ','¿','z'};
		for (int i = 0; i < noVocales.length; i++) {
			assertFalse("la NO vocal [" + noVocales[i] + "] deberia ser false", Utilidades.isVocal( noVocales[i]) );
			assertFalse("la NO vocal [" + Character.toUpperCase(noVocales[i]) + "] deberia ser false", Utilidades.isVocal( Character.toUpperCase(noVocales[i])) );
		}
		
				
	}

}
