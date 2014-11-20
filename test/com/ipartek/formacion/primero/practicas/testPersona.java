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

		// le asignamos un dato no numerico
		try {
			p.setEdad("0.0");
			fail("NO lanza la excepcion");
		} catch (PersonaException e) {
			fail("Lanzo PersonaException");
		} catch (NumberFormatException e) {
			assertTrue(true);
			assertEquals(p.getEdad(), "0.0");
		} catch (Exception e) {
			fail("Lanzo otra excepcion");
		}

		// le asignamos una edad menor a 18
		try {
			p.setEdad("0");
			fail("NO lanza la excepcion");
		} catch (PersonaException e) {
			if (PersonaException.MSG_EDAD_NO_VALIDA.equals(e.getMessage())) {
				assertEquals(p.getEdad(), "0");
			} else {
				assertEquals(PersonaException.MSG_EDAD_NO_VALIDA,
						e.getMessage());
			}
		} catch (Exception e) {
			fail("Lanzo otra excepcion");
		}

		// le asignamos una edad mayor a 99
		try {
			p.setEdad("100");
			fail("NO lanza la excepcion");
		} catch (PersonaException e) {
			if (PersonaException.MSG_EDAD_NO_VALIDA.equals(e.getMessage())) {
				assertEquals(p.getEdad(), "100");
			} else {
				assertEquals(PersonaException.MSG_EDAD_NO_VALIDA,
						e.getMessage());
			}
		} catch (Exception e) {
			fail("Lanzo otra excepcion");
		}
		// le asignamos una edad correcta
		assertTrue(true);

	}

	@Test
	public void testSetEmail() {
		assertTrue(true);
	}

	@Test
	public void testSetDni() {
		// Formato erroneo del DNI
		try {
			p.setDni("1a");
			fail("NO lanza la excepcion");
		} catch (PersonaException e) {
			assertTrue(true);
			assertEquals(e.getMessage(),
					PersonaException.MSG_FORMATO_DNI_INCORRECTO);
			assertEquals(p.getDni(), "1a");
		} catch (NumberFormatException e) {
			fail("01- Lanzo la NumberFormatException");
		}

		// Letra incorrecta del DNI
		try {
			p.setDni("22750794a");
			fail("NO lanza la excepcion");

		} catch (PersonaException e) {
			assertTrue(true);
			assertEquals(e.getMessage(),
					PersonaException.MSG_LETRA_DNI_INCORRECTA);
			assertEquals(p.getDni(), "22750794A");
		} catch (NumberFormatException e) {
			fail("02- Lanzo la NumberFormatException");
		}

		// DNI correcto
		try {
			p.setDni("22750794e");
			assertEquals(p.getDni(), "22750794E");
		} catch (PersonaException e) {
			fail("lanza la PersonaException");
		} catch (NumberFormatException e) {
			fail("03- Lanzo la PersonaException");
		}
	}

}
