package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona;
import com.ipartek.formacion.primero.bean.Persona.ComparatorEdad;
import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {

	ArrayList<Persona> listaPersonas = null;

	static final String ARITZ = "Áritz";
	static final String FRAN = "fran";
	static final String JON = "Jon";
	static final String JOSE = "Jose";
	static final String JOSEBA = "Joséba";
	static final String KEPA = "kepa";
	static final String MAITANE = "Maitane";
	static final String MARIO = "Mário";
	static final String SERGIO = "Sergio";
	static final String SRNU = "Sr ñu";
	static final String SUSANA = "Susana";
	static final String URKO = "Úrko";
	static final String ZUHAITZ = "Zuhaitz";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(new Persona(ZUHAITZ, 29));
		listaPersonas.add(new Persona(SUSANA, 23));
		listaPersonas.add(new Persona(KEPA, 34));
		listaPersonas.add(new Persona(URKO, 37));
		listaPersonas.add(new Persona(JON, 35));
		listaPersonas.add(new Persona(SERGIO, 18));
		listaPersonas.add(new Persona(SRNU, 37));
		listaPersonas.add(new Persona(JOSEBA, 26));
		listaPersonas.add(new Persona(MARIO, 29));
		listaPersonas.add(new Persona(ARITZ, 20));
		listaPersonas.add(new Persona(FRAN, 33));
		listaPersonas.add(new Persona(MAITANE, 28));
		listaPersonas.add(new Persona(JOSE, 99));
	}

	@After
	public void tearDown() throws Exception {
		listaPersonas = null;
	}

	public void testCollectionSortPersonas() {

		// ordenar alfabeticamente strings

		Collections.sort(listaPersonas);

		assertEquals(ARITZ, listaPersonas.get(0).getNombre());
		assertEquals(FRAN, listaPersonas.get(1).getNombre());
		assertEquals(JON, listaPersonas.get(2).getNombre());
		assertEquals(JOSE, listaPersonas.get(3).getNombre());
		assertEquals(JOSEBA, listaPersonas.get(4).getNombre());
		assertEquals(KEPA, listaPersonas.get(5).getNombre());
		assertEquals(MAITANE, listaPersonas.get(6).getNombre());
		assertEquals(MARIO, listaPersonas.get(7).getNombre());
		assertEquals(SERGIO, listaPersonas.get(8).getNombre());
		assertEquals(SRNU, listaPersonas.get(9).getNombre());
		assertEquals(SUSANA, listaPersonas.get(10).getNombre());
		assertEquals(URKO, listaPersonas.get(11).getNombre());
		assertEquals(ZUHAITZ, listaPersonas.get(12).getNombre());

		// ordenar por edad
		Collections.sort(listaPersonas, new ComparatorEdad());

		assertEquals(SERGIO, listaPersonas.get(0).getNombre());
		assertEquals(ARITZ, listaPersonas.get(1).getNombre());
		assertEquals(SUSANA, listaPersonas.get(2).getNombre());
		assertEquals(JOSEBA, listaPersonas.get(3).getNombre());
		assertEquals(MAITANE, listaPersonas.get(4).getNombre());
		assertEquals(MARIO, listaPersonas.get(5).getNombre());
		assertEquals(ZUHAITZ, listaPersonas.get(6).getNombre());
		assertEquals(FRAN, listaPersonas.get(7).getNombre());
		assertEquals(KEPA, listaPersonas.get(8).getNombre());
		assertEquals(JON, listaPersonas.get(9).getNombre());
		assertEquals(SRNU, listaPersonas.get(10).getNombre());
		assertEquals(URKO, listaPersonas.get(11).getNombre());
		assertEquals(JOSE, listaPersonas.get(12).getNombre());

	}

	@Test(expected = PersonaException.class)
	public void TestExceptions() throws PersonaException {

		Persona p = new Persona();
		p.setEdad(Persona.MAYOR_EDAD - 1);
		p.setEdad(Persona.MAX_EDAD + 1);
		// fail("no se lanza persona excepcion");

	}

	@Test
	public void TestExceptionEdad() {
		// testear el mensaje y el codigo de la excepcion

		try {
			Persona p = new Persona();
			p.setEdad(Persona.MAYOR_EDAD - 1);

		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
			assertEquals(PersonaException.COD_EDAD_NO_VALIDA, e.getMessage());
		}

		try {
			Persona p = new Persona();
			p.setNombre("a");
			p.setApellido1("w");
			p.setApellido2("w");

		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_NOMBRE_NO_VALIDO, e.getMessage());
			assertEquals(PersonaException.COD_NOMBRE_NO_VALIDO, e.getMessage());
		}

		try {
			Persona p = new Persona();
			p.setNombre(null);
			p.setApellido1(null);
			p.setApellido2(null);

		} catch (PersonaException e) {
			assertEquals(PersonaException.MSG_NOMBRE_NO_VALIDO, e.getMessage());
			assertEquals(PersonaException.COD_NOMBRE_NO_VALIDO, e.getMessage());
		}

	}

	@Test(expected = PersonaException.class)
	public void TestExceptionNomApe() throws PersonaException {

		Persona p = new Persona();
		p.setNombre("w");
		p.setApellido1("w");
		p.setApellido2("w");

		// fail("no se lanza persona excepcion");

	}

}
