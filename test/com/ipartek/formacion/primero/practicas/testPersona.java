package com.ipartek.formacion.primero.practicas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;
import com.ipartek.formacion.primero.practicas.migracion.Persona;

public class testPersona {

	Persona p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		p = new Persona();

	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testPersonaStringStringStringIntStringStringString() {
		assertTrue(true);
	}

	@Test
	public void testSetEdad() {
		// le asignamos una edad menor a 18
		try {
			p.setEdad(0);
			fail("NO lanza la excepcion");
		} catch (PersonaException e) {
			if (PersonaException.MSG_EDAD_NO_VALIDA.equals(e.getMessage())) {
				assertEquals(p.getEdad(), 0);
			} else {
				assertEquals(PersonaException.MSG_EDAD_NO_VALIDA,
						e.getMessage());
			}
		} catch (Exception e) {
			fail("Lanzo otra excepcion");
		}

		// le asignamos una edad mayor a 99
		// le asignamos una edad correcta
		assertTrue(true);

	}

	@Test
	public void testSetEmail() {
		assertTrue(true);
	}

	@Test
	public void testSetDni() {
		assertTrue(true);
	}

}
