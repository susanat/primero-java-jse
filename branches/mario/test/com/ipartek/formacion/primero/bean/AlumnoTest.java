package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impartek.formacion.primero.excepciones.PersonaException;

public class AlumnoTest {

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
	public void testAlumno() throws PersonaException {
		Alumno aluVacio = new Alumno();
		Alumno alu = new Alumno("mario", "alvaro", "45656565J", 56, null);

		assertEquals(Alumno.NOMBRE_DEFECTO, aluVacio.getNombre());

		assertEquals(Alumno.APELLIDO_DEFECTO, aluVacio.getApellido1());

		assertEquals(Alumno.DNI_DEFECTO, aluVacio.getDni());

		assertEquals("mario", alu.getNombre());

		assertEquals("alvaro", alu.getApellido1());

		assertEquals("45656565J", alu.getDni());

	}

}
