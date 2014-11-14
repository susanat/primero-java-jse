package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

	static int cont;
	static int CONT_ASSERT = 3;
	ArrayList<Persona> listaPersona = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cont = 0;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// assertEquals(CONT_ASSERT, cont);
	}

	@Before
	public void setUp() throws Exception {
		listaPersona = new ArrayList<Persona>();
		listaPersona.add(new Persona("Zuhaitz", 29));
		listaPersona.add(new Persona("Susána", 23));
		listaPersona.add(new Persona("kepa", 34));
		listaPersona.add(new Persona("Úrko", 37));
		listaPersona.add(new Persona("Jon", 35));
		listaPersona.add(new Persona("Sergio", 18));
		listaPersona.add(new Persona("Ñu", 32));
		listaPersona.add(new Persona("Joséba", 26));
		listaPersona.add(new Persona("Mário", 29));
		listaPersona.add(new Persona("Áritz", 20));
		listaPersona.add(new Persona("fran", 33));
		listaPersona.add(new Persona("Maitane", 28));
		listaPersona.add(new Persona("Jose", 99));
	}

	@After
	public void tearDown() throws Exception {
		listaPersona = null;
	}

	@Test(expected = PersonaException.class)
	public void TestExceptions() throws PersonaException {
		Persona p = new Persona();
		// cont++;
		p.setEdad(Persona.MIN_EDAD - 1);
		// cont--;
		// p.setEdad(Persona.MAX_EDAD + 1);
		p.setNombre("a");

	}

	@Test
	public void testExceptionEdad() throws PersonaException {
		// testear el mensaje y el codigo de la Exception

		try {
			Persona p = new Persona();
			p.setEdad(Persona.MIN_EDAD - 1);
			fail("No lanza PersonaException por edad");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_EDAD_NO_VALIDO, e.getMessage());
			assertEquals(PersonaException.CODE_EDAD_NO_VALIDO, e.getCodigo());

		}

	}

	@Test
	public void testExceptionString() throws PersonaException {
		// testear el mensaje y el codigo de la Exception

		try {
			Persona p = new Persona();
			p.setNombre("l");

			fail("No lanza PersonaException por nombre");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_STRING_NO_VALIDO,
					e.getMessage());
			assertEquals(PersonaException.CODE_LONG_STRING_NO_VALIDO,
					e.getCodigo());

		}

		try {
			Persona p = new Persona();
			p.setApellido1("s");

			fail("No lanza PersonaException por apellido1");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_STRING_NO_VALIDO,
					e.getMessage());
			assertEquals(PersonaException.CODE_LONG_STRING_NO_VALIDO,
					e.getCodigo());

		}

		try {
			Persona p = new Persona();
			p.setApellido2("d");

			fail("No lanza PersonaException por apellido2");
		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_LONG_STRING_NO_VALIDO,
					e.getMessage());
			assertEquals(PersonaException.CODE_LONG_STRING_NO_VALIDO,
					e.getCodigo());

		}

	}

	@Test
	public void testSortPersona() {
		// Ordenar por nombre (ComparaTo--> por defecto)
		// Collator esCollator = Collator.getInstance(new Locale("es_ES"));

		Collections.sort(listaPersona);

		/*
		 * try {
		 *
		 * RuleBasedCollator spCollator = new RuleBasedCollator(
		 * traditionalSpanishRules);
		 *
		 * // Collections.sort(listaPersona); Collections.sort(spCollator,
		 * listaPersona);
		 *
		 * } catch (ParseException pe) {
		 * System.out.println("Parse exception for rules"); }
		 */

		assertEquals("Áritz", listaPersona.get(0).getNombre());
		assertEquals("fran", listaPersona.get(1).getNombre());
		assertEquals("Jon", listaPersona.get(2).getNombre());
		assertEquals("Jose", listaPersona.get(3).getNombre());
		assertEquals("Joséba", listaPersona.get(4).getNombre());
		assertEquals("kepa", listaPersona.get(5).getNombre());
		assertEquals("Maitane", listaPersona.get(6).getNombre());
		assertEquals("Mário", listaPersona.get(7).getNombre());
		assertEquals("Ñu", listaPersona.get(8).getNombre());
		assertEquals("Sergio", listaPersona.get(9).getNombre());
		assertEquals("Susána", listaPersona.get(10).getNombre());
		assertEquals("Úrko", listaPersona.get(11).getNombre());
		assertEquals("Zuhaitz", listaPersona.get(12).getNombre());

		// Ordenar por edad (Comparable)

		Collections.sort(listaPersona, new ComparatorEdad());
		assertEquals(18, listaPersona.get(0).getEdad());
		assertEquals(20, listaPersona.get(1).getEdad());
		assertEquals(23, listaPersona.get(2).getEdad());
		assertEquals(26, listaPersona.get(3).getEdad());
		assertEquals(28, listaPersona.get(4).getEdad());
		assertEquals(29, listaPersona.get(5).getEdad());
		assertEquals(29, listaPersona.get(6).getEdad());
		assertEquals(32, listaPersona.get(7).getEdad());
		assertEquals(33, listaPersona.get(8).getEdad());
		assertEquals(34, listaPersona.get(9).getEdad());
		assertEquals(35, listaPersona.get(10).getEdad());
		assertEquals(37, listaPersona.get(11).getEdad());
		assertEquals(99, listaPersona.get(12).getEdad());

	}

}
