package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {

	static int count = 0;
	static int COUNT_ASSERTS = 4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		count = 0;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		assertEquals("No completadas TODAS las asserciones ", COUNT_ASSERTS,
				count);

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = PersonaException.class)
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		count++;
		p.setEdad(Persona.MIN_EDAD - 1);
		count--;

	}

	@Test
	public void testExceptionEdad() {
		// testear el mensaje y codigo de la Exception
		try {
			Persona p = new Persona();
			p.setEdad(Persona.MIN_EDAD - 1);
			fail("No lanza PersonaException por edad");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
			assertEquals(PersonaException.COD_EDAD_NO_VALIDA, e.getCodigo());
			count++;
		}

		try {
			Persona p = new Persona();
			p.setNombre("a");
			fail("No lanza PersonaException por longitud minima en nombre");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_STRING_CORTO, e.getMessage());
			assertEquals(PersonaException.COD_STRING_CORTO, e.getCodigo());
			count++;
		}

		try {
			Persona p = new Persona();
			p.setNombre(null);
			fail("No lanza PersonaException por longitud minima en nombre");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_STRING_CORTO, e.getMessage());
			assertEquals(PersonaException.COD_STRING_CORTO, e.getCodigo());
			count++;
		}

	}

}
