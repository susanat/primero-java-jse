package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	static String testMsg;

	ArrayList<Alumno> alumnos;
	Alumno a1;
	Alumno a2;
	Alumno a3;
	Alumno a4;
	Alumno a5;
	Alumno a6;
	Alumno a7;
	Alumno a8;
	Alumno a9;
	Alumno a10;
	Alumno a11;
	Alumno a12;
	Alumno a13;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testMsg = "";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testMsg = null;
	}

	@Before
	public void setUp() throws Exception {
		alumnos = new ArrayList<Alumno>();

		a1 = new Alumno("Zuhaitz", 29);
		a2 = new Alumno("Susána", 23);
		a3 = new Alumno("kepa", 34);
		a4 = new Alumno("Úrko", 37);
		a5 = new Alumno("Jon", 35);
		a6 = new Alumno("Sergio", 18);
		a7 = new Alumno("Ñu Sr", 32);
		a8 = new Alumno("Joséba", 26);
		a9 = new Alumno("Mário", 29);
		a10 = new Alumno("Áritz", 20);
		a11 = new Alumno("fran", 33);
		a12 = new Alumno("Maitane", 28);
		a13 = new Alumno("Jose", 99);

		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
		alumnos.add(a5);
		alumnos.add(a6);
		alumnos.add(a7);
		alumnos.add(a8);
		alumnos.add(a9);
		alumnos.add(a10);
		alumnos.add(a11);
		alumnos.add(a12);
		alumnos.add(a13);
	}

	@After
	public void tearDown() throws Exception {
		alumnos = null;
		a1 = null;
		a2 = null;
		a3 = null;
		a4 = null;
		a5 = null;
		a6 = null;
		a7 = null;
		a8 = null;
		a9 = null;
		a10 = null;
		a11 = null;
		a12 = null;
		a13 = null;
	}

	@Test
	public void testOrdenable() {
		// Comparar por defecto (por nombre)
		testMsg = "La lista de alumnos está mal ordenada por nombre.";
		Collections.sort(alumnos);
		assertEquals(testMsg, alumnos.get(0), a10);
		assertEquals(testMsg, alumnos.get(1), a11);
		assertEquals(testMsg, alumnos.get(2), a5);
		assertEquals(testMsg, alumnos.get(3), a13);
		assertEquals(testMsg, alumnos.get(4), a8);
		assertEquals(testMsg, alumnos.get(5), a3);
		assertEquals(testMsg, alumnos.get(6), a12);
		assertEquals(testMsg, alumnos.get(7), a9);
		assertEquals(testMsg, alumnos.get(8), a7);
		assertEquals(testMsg, alumnos.get(9), a6);
		assertEquals(testMsg, alumnos.get(10), a2);
		assertEquals(testMsg, alumnos.get(11), a4);
		assertEquals(testMsg, alumnos.get(12), a1);

		// Comparar por edad
		testMsg = "La lista de alumnos está mal ordenada por edad.";
		Collections.sort(alumnos, new ComparatorEdad());
		assertEquals(testMsg, alumnos.get(0), a6);
		assertEquals(testMsg, alumnos.get(1), a10);
		assertEquals(testMsg, alumnos.get(2), a2);
		assertEquals(testMsg, alumnos.get(3), a8);
		assertEquals(testMsg, alumnos.get(4), a12);
		assertTrue(testMsg,
				alumnos.get(5).equals(a1) || alumnos.get(5).equals(a9));
		assertTrue(testMsg,
				alumnos.get(6).equals(a1) || alumnos.get(6).equals(a9));
		assertEquals(testMsg, alumnos.get(7), a7);
		assertEquals(testMsg, alumnos.get(8), a11);
		assertEquals(testMsg, alumnos.get(9), a3);
		assertEquals(testMsg, alumnos.get(10), a5);
		assertEquals(testMsg, alumnos.get(11), a4);
		assertEquals(testMsg, alumnos.get(12), a13);
	}

	@Test(expected = PersonaException.class)
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		// p.setEdad(Persona.MIN_EDAD - 1);
		// p.setEdad(Persona.MIN_EDAD + 1);

		// p.setNombre("na");
		// p.setApellido1("na");
		p.setApellido2(null);
	}

	@Test
	public void testExceptionMessages() {
		try {
			Persona p = new Persona();
			// p.setEdad(Persona.MIN_EDAD - 1);
			p.setNombre("n");
		} catch (PersonaException e) {
			// assertEquals("Mensaje de PersonaException con edad incorrecto.",
			// PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
			assertEquals("Mensaje de PersonaException con length incorrecto.",
					PersonaException.MSG_LENGTH_SHORT, e.getMessage());
		}
	}

}
