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
	static final String FICHERO_NAME_TEST2 = "milLineas.txt";
	static final String FICHERO_CONTENT_TEST1 = "Hello World";
	static final String FICHERO_CONTENT_TEST2 = "filename.txt \nlinea1 \nlinea2";

	static final int BUCLE = 10000;

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

	@Test(timeout = 500 * 3)
	public void testWriteString() {
		String content = "";

		for (int i = 0; i < BUCLE; i++) {
			content += "Linea" + i + "\n";
		}
		Fichero.create(FICHERO_NAME_TEST1, content);
		Fichero.read(FICHERO_NAME_TEST1);
		assertTrue(FICHERO_NAME_TEST1 + " no se pudo eliminar ",
				Fichero.remove(FICHERO_NAME_TEST1));

	}

	@Test(timeout = 1000 * 3)
	public void testWriteStringBuilder() {
		StringBuilder sbContent = new StringBuilder();
		for (int i = 0; i < BUCLE; i++) {
			sbContent.append("Linea" + i + "\n");
		}
		Fichero.create(FICHERO_NAME_TEST1, sbContent.toString());
		Fichero.read(FICHERO_NAME_TEST1);
		assertTrue(FICHERO_NAME_TEST1 + " no se pudo eliminar ",
				Fichero.remove(FICHERO_NAME_TEST1));
	}
}
