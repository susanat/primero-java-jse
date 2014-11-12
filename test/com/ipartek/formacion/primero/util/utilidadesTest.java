package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.practicas.Arrays;

public class utilidadesTest {
	
	static Arrays myarray;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myarray = new Arrays();
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

	/**
	 * Comprueba que sea una vocal: a,e,i,o,u,A,E,I,O,U y con acentos
	 */
	@Test
	public void testIsVocal() {
		
		//Test de vocales
		char[] vocales = new char []{'a','e','i','o','u','á','é','í','ó','ú'};
		for (int i = 0; i < vocales.length; i++) {
			assertTrue("La vocal [" + vocales[i] + "] deberia ser true" , utilidades.isVocal(vocales[i]));
			assertTrue("La vocal [" + Character.toUpperCase(vocales[i]) + "] deberia ser true" , utilidades.isVocal(Character.toUpperCase(vocales[i])));		
		}
		
		//Test No vocales
		char[] noVocales = new char []{'m','f','k','^','r','ñ','?'};
		for (int i = 0; i < noVocales.length; i++) {
			assertFalse("La NO vocal [" + noVocales[i] + "] deberia ser false" , utilidades.isVocal(noVocales[i]));
			assertFalse("La NO vocal [" + Character.toUpperCase(noVocales[i]) + "] deberia ser false" , utilidades.isVocal(Character.toUpperCase(noVocales[i])));
		}
		
	}
	
	/**
	 * Comprueba que la array tenga 10 objetos
	 */
	@Test
	public void testpintarArray() {
		//comprobar que la array llamada myarray contenga 10 objetos
			
		
		}
		
	
	
	
	

}
