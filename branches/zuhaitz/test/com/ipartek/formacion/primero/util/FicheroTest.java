package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {

	static final String FILE_NAME = "HelloWorld.txt";
	static final String FILE_CONTENT1 = "Hello World";
	static final String FILE_CONTENT2 = "filename.txt "
			+ System.getProperty("line.separator") + "Línea 1 "
			+ System.getProperty("line.separator") + "Línea 2";

	static final int LOOP = 10000;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertTrue("No se pudo eliminar " + FILE_NAME,
				Fichero.removeFile(FILE_NAME));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		assertTrue(Fichero.createFile(FILE_NAME, FILE_CONTENT1));
	}

	@Test
	public void testRead() {
		try {
			assertTrue(Fichero.createFile(FILE_NAME, FILE_CONTENT2));
			Fichero.readFile(FILE_NAME);
		} catch (Exception e) {
			fail("Exception leyendo el fichero.");
		}
	}

	@Test(timeout = 1000 * 2)
	public void testWriteString() throws Exception {
		String content = "";
		for (int i = 0; i < LOOP; i++) {
			content += "Line " + i + System.getProperty("line.separator");
		}
		Fichero.createFile(FILE_NAME, content);
		Fichero.readFile(FILE_NAME);
		assertTrue(Fichero.removeFile(FILE_NAME));
	}

	@Test(timeout = 1000 * 2)
	public void testWriteStringBuilder() throws Exception {
		StringBuilder sbContent = new StringBuilder();
		for (int i = 0; i < LOOP; i++) {
			sbContent
					.append("Line " + i + System.getProperty("line.separator"));
		}
		Fichero.createFile(FILE_NAME, sbContent.toString());
		Fichero.readFile(FILE_NAME);
		assertTrue(Fichero.removeFile(FILE_NAME));
	}

}
