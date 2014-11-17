package com.ipartek.formacion.primero.streams;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertTrue(new Fichero().delete("fic.txt"));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		assertTrue(new Fichero().create("fic.txt", "Hola"));
	}

	@Test
	public void testRead() {
		try {
			Fichero fic = new Fichero();
			fic.create("fic.txt", "Hola");
			fic.read("fic.txt");
		} catch (Exception e) {
			fail("Error al leer el fichero");
		}
	}
}
