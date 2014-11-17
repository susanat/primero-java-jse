package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {
	static final String FICHERO_NAME_TEST1 = "filename.txt";
	static final String FICHERO_CONTENT_TEST1 = "Hello World";
	static final String FICHERO_CONTENT_TEST2 = "filename.txt \nlinea1 \nlinea2";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertTrue(FICHERO_NAME_TEST1 + " no se pudo eliminar ",
				Fichero.remove(FICHERO_NAME_TEST1));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		assertTrue(Fichero.create(FICHERO_NAME_TEST1, FICHERO_CONTENT_TEST1));

	}

	@Test
	public void testRead() {

		try {
			assertTrue(Fichero
					.create(FICHERO_NAME_TEST1, FICHERO_CONTENT_TEST2));
			Fichero.read(FICHERO_NAME_TEST1);
		} catch (Exception e) {
			fail("Exception leyendo fichero");
		}

	}

}
