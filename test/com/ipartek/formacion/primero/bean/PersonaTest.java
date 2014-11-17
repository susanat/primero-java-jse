package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {
	ArrayList<Persona> listaPersonas = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(new Persona("Zuhaitz", "", 29, ""));
		listaPersonas.add(new Persona("Susána", "", 23, ""));
		listaPersonas.add(new Persona("kepa", "", 34, ""));
		listaPersonas.add(new Persona("Úrko", "", 37, ""));
		listaPersonas.add(new Persona("Jon", "", 35, ""));
		listaPersonas.add(new Persona("Sergio", "", 18, ""));
		listaPersonas.add(new Persona("Ñu", "", 32, ""));
		listaPersonas.add(new Persona("Joséba", "", 20, ""));
		listaPersonas.add(new Persona("Mário", "", 29, ""));
		listaPersonas.add(new Persona("Áritz", "", 20, ""));
		listaPersonas.add(new Persona("fran", "", 33, ""));
		listaPersonas.add(new Persona("Maitane", "", 28, ""));
		listaPersonas.add(new Persona("Jose", "", 99, ""));
	}

	@After
	public void tearDown() throws Exception {
		listaPersonas = null;
	}

	@Test
	public void testOrdenarPersonas() {
		// Ordenar por nombre
		Collections.sort(listaPersonas);
		assertSame(listaPersonas.get(0).getNombre(), "Áritz");
		assertSame(listaPersonas.get(1).getNombre(), "fran");
		assertSame(listaPersonas.get(2).getNombre(), "Jon");
		assertSame(listaPersonas.get(3).getNombre(), "Jose");
		assertSame(listaPersonas.get(4).getNombre(), "Joséba");
		assertSame(listaPersonas.get(5).getNombre(), "kepa");
		assertSame(listaPersonas.get(6).getNombre(), "Maitane");
		assertSame(listaPersonas.get(7).getNombre(), "Mário");
		assertSame(listaPersonas.get(8).getNombre(), "Ñu");
		assertSame(listaPersonas.get(9).getNombre(), "Sergio");
		assertSame(listaPersonas.get(10).getNombre(), "Susána");
		assertSame(listaPersonas.get(11).getNombre(), "Úrko");
		assertSame(listaPersonas.get(12).getNombre(), "Zuhaitz");

		// Ordenar por número de plazas
		Collections.sort(listaPersonas,
				listaPersonas.get(0).new ComparatorEdad());
		assertSame(listaPersonas.get(0).getNombre(), "Sergio");
		assertSame(listaPersonas.get(1).getNombre(), "Áritz");
		assertSame(listaPersonas.get(2).getNombre(), "Joséba");
		assertSame(listaPersonas.get(3).getNombre(), "Susána");
		assertSame(listaPersonas.get(4).getNombre(), "Maitane");
		assertSame(listaPersonas.get(5).getNombre(), "Mário");
		assertSame(listaPersonas.get(6).getNombre(), "Zuhaitz");
		assertSame(listaPersonas.get(7).getNombre(), "Ñu");
		assertSame(listaPersonas.get(8).getNombre(), "fran");
		assertSame(listaPersonas.get(9).getNombre(), "kepa");
		assertSame(listaPersonas.get(10).getNombre(), "Jon");
		assertSame(listaPersonas.get(11).getNombre(), "Úrko");
		assertSame(listaPersonas.get(12).getNombre(), "Jose");
	}

	@Test(expected = PersonaException.class)
	public void testException() throws PersonaException {
		Persona p = new Persona();
		p.setEdad(Persona.MIN_EDAD - 1);
	}

	@Test(expected = PersonaException.class)
	public void testExceptionNombre() throws PersonaException {
		Persona p = new Persona();
		p.setNombre("sa");
		assertTrue(p.getNombre().length() == 2);
		p.setNombre("sass");
		assertTrue(p.getNombre().length() == 4);
		p.setNombre("s");
	}

	@Test(expected = PersonaException.class)
	public void testExceptionApe1() throws PersonaException {
		Persona p = new Persona();
		p.setApellido1("sa");
		assertTrue(p.getApellido1().length() == 2);
		p.setApellido1("sass");
		assertTrue(p.getApellido1().length() == 4);
		p.setApellido1("s");
	}

	@Test(expected = PersonaException.class)
	public void testExceptionApe2() throws PersonaException {
		Persona p = new Persona();
		p.setApellido2("sa");
		assertTrue(p.getApellido2().length() == 2);
		p.setApellido2("sass");
		assertTrue(p.getApellido2().length() == 4);
		p.setApellido2("s");
	}

	@Test
	public void testExceptionMsgEdad() {
		try {
			Persona p = new Persona();
			p.setEdad(Persona.MIN_EDAD - 1);
		} catch (PersonaException e) {
			assertSame(PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
			assertSame(PersonaException.COD_EDAD_NO_VALIDA, e.getCodigo());
		}

	}
}
