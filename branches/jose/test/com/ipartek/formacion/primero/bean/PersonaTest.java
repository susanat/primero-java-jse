package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {

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

	@Test
	public void testPersona() {
		Persona p=new Persona();
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.EDAD_POR_DEFECTO, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());
	}

	@Test
	public void testPersonaStringStringString() {
		Persona p=new Persona("", "", "");
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.EDAD_POR_DEFECTO, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());
		
		Persona p2=new Persona("Jose", "Perez", "12345678x");
		assertEquals("Jose", p2.getNombre());
		assertEquals("Perez", p2.getApellido1());
		assertEquals("12345678x", p2.getDni());
		assertEquals(Persona.EDAD_POR_DEFECTO, p2.getEdad());
		assertEquals(Persona.SEXO_VARON, p2.getSexo());
	}

	@Test
	public void testPersonaStringStringIntString() {
		Persona p=new Persona("", "", 0, "");
		assertEquals(Persona.APELLIDO_NULO, p.getNombre());
		assertEquals(Persona.APELLIDO_NULO, p.getApellido1());
		assertEquals(Persona.DNI_NULO, p.getDni());
		assertEquals(Persona.EDAD_POR_DEFECTO, p.getEdad());
		assertEquals(Persona.SEXO_VARON, p.getSexo());
		
		Persona p2=new Persona("Jose", "Perez", 20, "12345678x");
		assertEquals("Jose", p2.getNombre());
		assertEquals("Perez", p2.getApellido1());
		assertEquals("12345678x", p2.getDni());
		assertEquals(20, p2.getEdad());
		assertEquals(Persona.SEXO_VARON, p2.getSexo());
		
	}

}
