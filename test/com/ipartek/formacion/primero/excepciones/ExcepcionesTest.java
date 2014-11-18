package com.ipartek.formacion.primero.excepciones;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona;

public class ExcepcionesTest {

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

	@Test(expected = NullPointerException.class)
	public void TestExceptionAnotation() {
		String cadena = null;
		cadena.length();
	}

	@Test(expected = Exception.class)
	public void TestExceptionAnotation2() {
		String cadena = null;
		cadena.length();
	}

	@Test
	public void test() {

		Persona p = null;
		try {
			p.getApellido1();
			assertTrue("No deberia ejecutar esta linea", false);
		} catch (Exception e) {
			assertTrue(true);
		} finally {
			assertTrue("Siempre se deberia ejecutar", true);
		}

		try {
			p = new Persona();
			p.getApellido1();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(true);
		} finally {
			assertTrue("Siempre se deberia ejecutar", true);
		}

	}

}
