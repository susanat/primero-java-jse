package com.ipartek.formacion.primero.bean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {

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

	@Test(expected = PersonaException.class)
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		p.setEdad(Persona.MIN_EDAD - 1);
		p.setEdad(Persona.MAX_EDAD + 1);
		// fail("No se lanza PersonaException ");
	}

	@Test
	public void testExceptionEdad() {
		// testear el mensaje y codigo de la Exception

	}

}
