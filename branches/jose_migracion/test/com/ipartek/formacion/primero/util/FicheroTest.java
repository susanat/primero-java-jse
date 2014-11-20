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
	static final String FICHERO_CONTENIDO_TEST1 = "Hello World";
	static final String FICHERO_CONTENIDO_TEST2 = "filename.txt \nlinea1 \nlinea2";
	int BUCLE = 1000000;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertTrue(FICHERO_NAME_TEST1 + ": No se puedo eliminar el fichero",
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
		assertTrue(Fichero.create(FICHERO_NAME_TEST1, FICHERO_CONTENIDO_TEST1));
	}

	@Test
	public void testRead() {
		try {
			assertTrue(Fichero.create(FICHERO_NAME_TEST1,
					FICHERO_CONTENIDO_TEST2));
			Fichero.read(FICHERO_NAME_TEST1);
		} catch (Exception e) {
			fail("Excepcion leyendo fichero");
		}

	}

	@Test(timeout = 500 * 3)
	public void testWriteString() {
		String content = "";
		for (int i = 0; i < BUCLE; i++) {
			content += "linea" + i + "\n";
		}
		Fichero.create(FICHERO_NAME_TEST1, content);
		assertTrue(Fichero.remove(FICHERO_CONTENIDO_TEST1));
	}

	@Test(timeout = 500 * 3)
	public void testWriteBuilder() {
		StringBuilder sbContent = new StringBuilder();
		for (int i = 0; i < BUCLE; i++) {
			sbContent.append("linea" + i + "\n");
		}
		Fichero.create(FICHERO_NAME_TEST1, sbContent.toString());
		assertTrue(Fichero.remove(FICHERO_CONTENIDO_TEST1));
	}

}
