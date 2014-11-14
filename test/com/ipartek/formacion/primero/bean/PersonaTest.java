package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class PersonaTest {
	ArrayList<Persona> listaPersonas = null;

	ArrayList<Persona> listaPersonasReducida = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		/*
		 * listaPersonas = new ArrayList<Persona>();
		 *
		 * listaPersonas.add(new Persona("Zuhaitz", 29)); listaPersonas.add(new
		 * Persona("Susána", 23)); listaPersonas.add(new Persona("kepa", 34));
		 * listaPersonas.add(new Persona("Úrko", 37)); listaPersonas.add(new
		 * Persona("Jon", 35)); listaPersonas.add(new Persona("Sergio", 18));
		 * listaPersonas.add(new Persona("Sr Ñu", 32)); listaPersonas.add(new
		 * Persona("Joséba", 20)); listaPersonas.add(new Persona("Mário", 29));
		 * listaPersonas.add(new Persona("Áritz", 20)); listaPersonas.add(new
		 * Persona("fran", 33)); listaPersonas.add(new Persona("Maitane", 28));
		 * listaPersonas.add(new Persona("Jose", 41));
		 *
		 * // Lista Especial con Mayusculas, minusculas, acentos, dieresis, y //
		 * letras especiales como 'ñ' ArrayList<Persona> listaPersonasReducida =
		 * new ArrayList<Persona>(); listaPersonasReducida.add(new
		 * Persona("Antoniü", 12)); listaPersonasReducida.add(new
		 * Persona("antoniu", 10)); listaPersonasReducida.add(new
		 * Persona("Ántoniu", 11)); listaPersonasReducida.add(new
		 * Persona("Añtoniu", 12)); listaPersonasReducida.add(new
		 * Persona("Antoniu", 13)); listaPersonasReducida.add(new
		 * Persona("Aotoniu", 12));
		 */
	}

	@After
	public void tearDown() throws Exception {
		/*
		 * listaPersonas = null; listaPersonasReducida = null;
		 */
	}

	@Ignore
	@Test
	public void testPersona() throws PersonaException {
		Persona p = new Persona();
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.MIN_EDAD, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());
	}

	@Ignore
	@Test
	public void testPersonaStringStringString() throws PersonaException {
		Persona p = new Persona("", "", "");
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.MIN_EDAD, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());

		Persona p2 = new Persona("Jose", "Perez", "12345678x");
		assertEquals("Jose", p2.getNombre());
		assertEquals("Perez", p2.getApellido1());
		assertEquals("12345678x", p2.getDni());
		assertEquals(Persona.MIN_EDAD, p2.getEdad());
		assertEquals(Persona.SEXO_VARON, p2.getSexo());
	}

	@Ignore
	@Test
	public void testPersonaStringStringIntString() throws PersonaException {
		Persona p = new Persona("", "", 0, "");
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.MIN_EDAD, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());

		Persona p2 = new Persona("Jose", "Perez", 20, "12345678x");
		assertEquals("Jose", p2.getNombre());
		assertEquals("Perez", p2.getApellido1());
		assertEquals("12345678x", p2.getDni());
		assertEquals(20, p2.getEdad());
		assertEquals(Persona.SEXO_VARON, p2.getSexo());

	}

	@Ignore
	@Test
	public void testCompararNombreSimple() {
		Collections.sort(listaPersonasReducida);
		// , new ComparatorNombre());
		assertEquals("antoniu", listaPersonasReducida.get(0).getNombre());
		assertEquals("Ántoniu", listaPersonasReducida.get(1).getNombre());
		assertEquals("Antoniü", listaPersonasReducida.get(2).getNombre());
		assertEquals("Antoniu", listaPersonasReducida.get(3).getNombre());
		assertEquals("Añtonio", listaPersonasReducida.get(4).getNombre());
		assertEquals("Aotonio", listaPersonasReducida.get(5).getNombre());
	}

	@Test(expected = PersonaException.class)
	public void testExceptions() throws PersonaException {
		Persona p = new Persona();
		// p.setEdad(Persona.MIN_EDAD - 1);
		// p.setEdad(Persona.MAX_EDAD + 1);
		// fail("No se lanza PersonaException");

		// p.setNombre("a");
		// p.setApellido1("b");
		p.setApellido2("c");

	}

	@Test
	public void testExceptionEdad() {
		// testear el mensaje y codigo de la excepcion
		try {
			Persona p = new Persona();
			// p.setEdad(Persona.MIN_EDAD - 1);
			p.setEdad(Persona.MAX_EDAD + 1);
			fail("No se lanza PersonaException");
		}

		catch (PersonaException e) {
			assertEquals(PersonaException.COD_EDAD_NO_VALIDA, e.getCodigo());
			assertEquals(PersonaException.MSG_EDAD_NO_VALIDA, e.getMessage());
		}
	}

	@Test
	public void testExceptionNombreYApellidos() {
		// testear el mensaje y codigo de la excepcion
		try {
			Persona p = new Persona();
			// p.setNombre("a");
			// p.setApellido1("b");
			p.setApellido2("c");
			fail("No se lanza PersonaException");
		}

		catch (PersonaException e) {
			assertEquals(
					PersonaException.COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO,
					e.getCodigo());
			assertEquals(
					PersonaException.MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO,
					e.getMessage());
		}
	}

}
