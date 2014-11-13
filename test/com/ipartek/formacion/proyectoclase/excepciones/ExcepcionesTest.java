package com.ipartek.formacion.proyectoclase.excepciones;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.proyectoclase.pojo.Persona;

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
			p.getPapellido();
			assertTrue("No se debería ejecutar", false);// esto no se ejecuta
		} catch (Exception e) {
			assertTrue(true);
		} finally {
			assertTrue("Esto siempre se deberia ejecutar", true);// esto se
			// ejecuta
			// siempre
		}
		try {
			p = new Persona();
			p.getPapellido();
			assertTrue("Se ejecutara", true);// esto no se ejecuta
		} catch (Exception e) {
			assertTrue("No se va ejecutar", false);
		} finally {
			assertTrue("Esto siempre se deberia ejecutar", true);// esto se
																	// ejecuta
																	// siempre
		}
	}
}
