package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class TestExceptions {

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
	// Espera que se lance una excepcion de tipo PersonaException
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		p.setEdad(Persona.MIN_EDAD - 1);
		p.setEdad(Persona.MAX_EDAD + 1);

	}

	@Test(expected = PersonaException.class)
	// Esperamos que se lance una excepcion de tipo PersonaException causada por
	// poner un nombre demasiado corto
	public void testExceptionLongitud() throws PersonaException {
		Persona p = new Persona();
		p.setNombre("a");
	}

	@Test
	// testear el mensaje y codigo de la excepcion
	public void testExceptionMessage() {
		Persona p = new Persona();
		try {
			p.setNombre("b");// ponemos un nombre invalido para hacer que
			// falle
			p.setEdad(12);
		} catch (PersonaException e) {
			assertSame("Los codigos no son iguales", 1,
					PersonaException.COD_ARG_INVALIDO);
			assertSame("Los mensajes no son iguales", e.getMessage(),
					PersonaException.MSG_ARGUMENTO_INVALIDO);
		}
	}
}
