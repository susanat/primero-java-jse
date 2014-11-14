package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impartek.formacion.primero.excepciones.PersonaException;

public class FormadorTest {

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
	public void testFormador() throws PersonaException {
		Formador formVacio = new Formador();
		Formador formador = new Formador("lala", "lolo", "45454545S", 35,
				1005.36f);

		assertEquals(Formador.NOMBRE_DEFECTO, formVacio.getNombre());

		assertEquals(Formador.APELLIDO_DEFECTO, formVacio.getApellido1());

		assertEquals(Formador.DNI_DEFECTO, formVacio.getDni());

		assertEquals(Formador.MIN_SUELDO, formVacio.getSueldo(),
				Float.MIN_VALUE);

		assertEquals("lala", formador.getNombre());

		assertEquals("lolo", formador.getApellido1());

		assertEquals("45454545S", formador.getDni());

		assertEquals(1005.36f, formador.getSueldo(), Float.MIN_VALUE);

		assertTrue("Edad incorrecta, no es mayor de edad",
				formador.isMayorEdad());

	}

}
