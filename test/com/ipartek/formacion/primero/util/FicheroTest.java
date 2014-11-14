package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {

	static final String FICHERO_NAME_TEST1 = "filename.txt";
	static final String FICHERO_CONTENT_TEST1 = "Hello Wolrd";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		assertTrue(FICHERO_NAME_TEST1 + " No se pudo eliminar",
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

}
