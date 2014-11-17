package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManejadorFicheroTest {
	final String FICHERO_NAME_TEST1 = "FILENAME";
	final String FICHERO_EXT_TEST1 = "TXT";
	final String FICHERO_PATH_TEST1 = "C://";

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
	public void crearArchivoTexto() {

	}

	@Test
	public void borrarArchivoTexto() {
		assertTrue("El fichero no ha sido creado con exito", true);
	}

	@Test
	public void leerArchivoTexto() {
		assertTrue("", true);
	}
}
