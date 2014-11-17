package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona.ComparatorEdad;
import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {
	ArrayList<Persona> personas = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		personas = new ArrayList<Persona>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Persona zuhaitz = new Persona("Zuhaitz", 29);
		Persona susana = new Persona("Susana", 23);
		Persona kepa = new Persona("kepa", 34);
		Persona urko = new Persona("Úrko", 37);
		Persona jon = new Persona("Jon", 35);
		Persona sergio = new Persona("Sergio", 18);
		Persona srnu = new Persona("Ñu", 32);
		Persona joseba = new Persona("Joseba", 26);
		Persona mario = new Persona("Mario", 29);
		Persona aritz = new Persona("Áritz", 20);
		Persona fran = new Persona("fran", 33);
		Persona maitane = new Persona("Maitane", 28);
		Persona jose = new Persona("Jose", 99);

		personas.add(zuhaitz);
		personas.add(susana);
		personas.add(kepa);
		personas.add(urko);
		personas.add(jon);
		personas.add(sergio);
		personas.add(srnu);
		personas.add(joseba);
		personas.add(mario);
		personas.add(aritz);
		personas.add(fran);
		personas.add(maitane);
		personas.add(jose);

		Collections.sort(personas);

		assertEquals(aritz, personas.get(0));
		assertEquals(fran, personas.get(1));
		assertEquals(jon, personas.get(2));
		assertEquals(jose, personas.get(3));
		assertEquals(joseba, personas.get(4));
		assertEquals(kepa, personas.get(5));
		assertEquals(maitane, personas.get(6));
		assertEquals(mario, personas.get(7));
		assertEquals(srnu, personas.get(8));
		assertEquals(sergio, personas.get(9));
		assertEquals(susana, personas.get(10));
		assertEquals(urko, personas.get(11));
		assertEquals(zuhaitz, personas.get(12));

		Collections.sort(personas, new ComparatorEdad());

		assertEquals(sergio, personas.get(0));
		assertEquals(aritz, personas.get(1));
		assertEquals(susana, personas.get(2));
		assertEquals(joseba, personas.get(3));
		assertEquals(maitane, personas.get(4));
		assertEquals(mario, personas.get(5));
		assertEquals(zuhaitz, personas.get(6));
		assertEquals(srnu, personas.get(7));
		assertEquals(fran, personas.get(8));
		assertEquals(kepa, personas.get(9));
		assertEquals(jon, personas.get(10));
		assertEquals(urko, personas.get(11));
		assertEquals(jose, personas.get(12));
	}

	@Test(expected = PersonaException.class)
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		p.setEdad(Persona.MIN_EDAD - 1);
		p.setEdad(Persona.MAX_EDAD + 1);
		// fail("No se lanza PersonaException");
	}

	@Test
	public void testExcepcionEdad() {
		// testear el mensaje y codigo de la excepcion
		Persona p = new Persona();

		try {
			p.setEdad(Persona.MIN_EDAD - 1);
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
		}

		try {
			p.setNombre("a");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_INVALIDA, e.getMessage());
		}

		try {
			p.setApellido1("b");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_INVALIDA, e.getMessage());
		}

		try {
			p.setApellido2("c");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_INVALIDA, e.getMessage());
		}

	}
}
