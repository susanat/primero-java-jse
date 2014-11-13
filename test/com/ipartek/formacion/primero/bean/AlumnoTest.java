package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Alumno.ComparatorEdadAlumnos;
import com.ipartek.formacion.primero.bean.Alumno.ComparatorNombreAlumnos;

public class AlumnoTest {

	ArrayList<Alumno> listaAlumnos = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos.add(new Alumno("Zuhaitz", 29)); // Ocupa la posición 0
		listaAlumnos.add(new Alumno("Susána", 23)); // Ocupa la posición 1
		listaAlumnos.add(new Alumno("kepa", 34)); // Ocupa la posición 2
		listaAlumnos.add(new Alumno("Urko", 37)); // Ocupa la posición 3
		listaAlumnos.add(new Alumno("Jon", 35)); // Ocupa la posición 4
		listaAlumnos.add(new Alumno("Sergio", 18)); // Ocupa la posición 5
		listaAlumnos.add(new Alumno("Sr Ñu", 32)); // Ocupa la posición 6
		listaAlumnos.add(new Alumno("Joséba", 26)); // Ocupa la posición 7
		listaAlumnos.add(new Alumno("Mário", 29)); // Ocupa la posición 8
		listaAlumnos.add(new Alumno("Áritz", 20)); // Ocupa la posición 9
		listaAlumnos.add(new Alumno("fran", 33)); // Ocupa la posición 10
		listaAlumnos.add(new Alumno("Maitane", 28)); // Ocupa la posición 11
		listaAlumnos.add(new Alumno("Jose", 99)); // Ocupa la posición 12
	}

	@After
	public void tearDown() throws Exception {

		listaAlumnos = null;
	}

	@Test
	public void testOrdenarAlumnosEdad() {
		Collections.sort(listaAlumnos, new ComparatorEdadAlumnos());
		assertEquals(18, listaAlumnos.get(0).getEdad());
		assertEquals(20, listaAlumnos.get(1).getEdad());
		assertEquals(23, listaAlumnos.get(2).getEdad());
		assertEquals(26, listaAlumnos.get(3).getEdad());
		assertEquals(28, listaAlumnos.get(4).getEdad());
		assertEquals(29, listaAlumnos.get(5).getEdad());
		assertEquals(29, listaAlumnos.get(6).getEdad());
		assertEquals(32, listaAlumnos.get(7).getEdad());
		assertEquals(33, listaAlumnos.get(8).getEdad());
		assertEquals(34, listaAlumnos.get(9).getEdad());
		assertEquals(35, listaAlumnos.get(10).getEdad());
		assertEquals(37, listaAlumnos.get(11).getEdad());
		assertEquals(99, listaAlumnos.get(12).getEdad());

	}

	@Test
	public void testOrdenarAlumnosNombre() {
		Collections.sort(listaAlumnos, new ComparatorNombreAlumnos());
		assertEquals("Áritz", listaAlumnos.get(0).getNombre());
		assertEquals("fran", listaAlumnos.get(1).getNombre());
		assertEquals("Jon", listaAlumnos.get(2).getNombre());
		assertEquals("Jose", listaAlumnos.get(3).getNombre());
		assertEquals("Joséba", listaAlumnos.get(4).getNombre());
		assertEquals("kepa", listaAlumnos.get(5).getNombre());
		assertEquals("Maitane", listaAlumnos.get(6).getNombre());
		assertEquals("Mário", listaAlumnos.get(7).getNombre());
		assertEquals("Sergio", listaAlumnos.get(8).getNombre());
		assertEquals("Sr Ñu", listaAlumnos.get(9).getNombre());
		assertEquals("Susána", listaAlumnos.get(10).getNombre());
		assertEquals("Urko", listaAlumnos.get(11).getNombre());
		assertEquals("Zuhaitz", listaAlumnos.get(12).getNombre());

	}
}
