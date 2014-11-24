package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

import java.util.HashSet;

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
		// test vocales
		char[] vocales = new char[] { 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í',
				'ó', 'ú' };
		for (int i = 0; i < vocales.length; i++) {
			assertTrue("la vocal [" + vocales[i] + "] deberia ser true",
					Utilidades.isVocal(vocales[i]));
			assertTrue(
					"la vocal Mayuscula [" + Character.toUpperCase(vocales[i])
							+ "] deberia ser true",
					Utilidades.isVocal(Character.toUpperCase(vocales[i])));
		}

		// test NO vocales
		char[] noVocales = new char[] { 'm', 'p', '^', ' ', '¿', 'z' };
		for (int i = 0; i < noVocales.length; i++) {
			assertFalse("la NO vocal [" + noVocales[i] + "] deberia ser false",
					Utilidades.isVocal(noVocales[i]));
			assertFalse("la NO vocal [" + Character.toUpperCase(noVocales[i])
					+ "] deberia ser false",
					Utilidades.isVocal(Character.toUpperCase(noVocales[i])));
		}
	}

	@Test
	public void testGetTirada() throws Exception {
		HashSet<Integer> valores = new HashSet<Integer>();
		int tirada = -1;

		for (int i = 0; i < 10000; i++) {
			tirada = Dado.getTirada();
			// assertTrue(String.valueOf(tirada), (0 <= tirada)
			// && (Dado.alumnos.length >= tirada));
			valores.add(tirada);
		}
		assertEquals(Dado.alumnos.length, valores.size());

		// Comprobacion de tamaño inferior
		valores.clear();
		for (int i = 0; i < 10; i++) {
			tirada = Dado.getTirada();
			valores.add(tirada);
		}
		assertTrue(valores.size() < Dado.alumnos.length);
	}
}
