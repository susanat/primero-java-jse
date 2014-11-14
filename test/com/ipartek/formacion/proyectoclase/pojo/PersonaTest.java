package com.ipartek.formacion.proyectoclase.pojo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.proyectoclase.excepciones.PersonaException;
import com.ipartek.formacion.proyectoclase.pojo.Persona.ComparatorPersonaEdad;

public class PersonaTest {
	ArrayList<Persona> alumnos = null;
	Persona pzuhaitz = null;
	Persona psusana = null;
	Persona pkepa = null;
	Persona purko = null;
	Persona pjon = null;
	Persona psergio = null;
	Persona pjoseba = null;
	Persona pmario = null;
	Persona paritz = null;
	Persona pfran = null;
	Persona pmaitane = null;
	Persona pjose = null;
	Persona pnu = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1985);
		pzuhaitz = new Persona("Zuhaitz", c);

		c.set(Calendar.YEAR, 1991);
		psusana = new Persona("Susúna", c);

		c.set(Calendar.YEAR, 1980);
		pkepa = new Persona("kepa", c);

		c.set(Calendar.YEAR, 1977);
		purko = new Persona("Úrko", c);

		c.set(Calendar.YEAR, 1979);
		pjon = new Persona("Jon", c);

		c.set(Calendar.YEAR, 1996);
		psergio = new Persona("Sergio", c);

		c.set(Calendar.YEAR, 1988);
		pjoseba = new Persona("Joséba", c);

		c.set(Calendar.YEAR, 1991);
		pmario = new Persona("Mário", c);

		c.set(Calendar.YEAR, 1994);
		paritz = new Persona("Áritz", c);

		c.set(Calendar.YEAR, 1981);
		pfran = new Persona("fran", c);

		c.set(Calendar.YEAR, 1986);
		pmaitane = new Persona("Maitane", c);

		c.set(Calendar.YEAR, 1965);
		pjose = new Persona("Jose", c);

		c.set(Calendar.YEAR, 1982);
		pnu = new Persona("Ñu", c);

		alumnos = new ArrayList<Persona>();

		alumnos.add(pzuhaitz);
		alumnos.add(psusana);
		alumnos.add(pkepa);
		alumnos.add(pjon);
		alumnos.add(psergio);
		alumnos.add(pjoseba);
		alumnos.add(pmario);
		alumnos.add(paritz);
		alumnos.add(pfran);
		alumnos.add(pmaitane);
		alumnos.add(pjose);
		alumnos.add(pnu);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPersona() {
		// fail("Not yet implemented");
		Collections.sort(alumnos);

		assertEquals("La lista no esta bien ordenada por nombres", paritz,
				alumnos.get(0));
		assertEquals("La lista no esta bien ordenada por nombres", pzuhaitz,
				alumnos.get(alumnos.size() - 1));

		Collections.sort(alumnos, new ComparatorPersonaEdad());

		assertEquals(
				"La lista no esta bien ordenada por edades"
						+ alumnos.get(0).getNombre(), pjose, alumnos.get(0));

		assertEquals("La lista no esta bien ordenada por edades "
				+ alumnos.get(alumnos.size() - 1).getNombre(), psergio,
				alumnos.get(alumnos.size() - 1));

	}

	@Test(expected = PersonaException.class)
	public void testException() throws PersonaException {
		Persona p = new Persona();
		p.setFnacimiento(Calendar.getInstance());
	}

}
