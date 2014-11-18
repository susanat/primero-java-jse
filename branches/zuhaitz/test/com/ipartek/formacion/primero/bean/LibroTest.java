package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {

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

	// empiezan nuetros Test Unitarios

	@Test
	public void testLibro() {
		Libro libroPorDefecto = new Libro();
		assertTrue("NO son el numero de paginas esperado",
				0 == libroPorDefecto.getPaginas());
	}

}
