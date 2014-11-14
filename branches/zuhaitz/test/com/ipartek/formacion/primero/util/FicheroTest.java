package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {

	static final String FILE_NAME = "Blablabla.txt";
	static final String FILE_CONTENT = "adgdfgsgfdg";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertTrue("No se pudo eliminar " + FILE_NAME,
				Fichero.remove(FILE_NAME));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		assertTrue(Fichero.create(FILE_NAME, FILE_CONTENT));
	}

}
