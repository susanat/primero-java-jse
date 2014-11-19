package com.ipartek.formacion.primero;

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

	@Test
	public void test() {
		Persona p = null;
		try {
			p.getApellido1();
			assertTrue("Deber�a haber saltado la excepci�n", false);
		} catch (Exception e) {
			assertTrue(true);
		} finally {
			assertTrue("Siempre se deber�a ejecutar", true);
		}

		try {
			p = new Persona();
			p.getApellido1();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue("No deber�a haber saltado la excepci�n", false);
		} finally {
			assertTrue("Siempre se deber�a ejecutar", true);
		}
	}

}