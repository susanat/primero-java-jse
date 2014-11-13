package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona.comparatorEdad;

public class TestPersona {

	ArrayList<Persona> listaPersonas = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Creamos el juego de datos en el setup del test
		listaPersonas = new ArrayList<Persona>();

		listaPersonas.add(new Persona("Zuhaitz", 29));
		listaPersonas.add(new Persona("Susána", 23));
		listaPersonas.add(new Persona("kepa", 34));
		listaPersonas.add(new Persona("Úrko", 37));
		listaPersonas.add(new Persona("Jon", 35));
		listaPersonas.add(new Persona("Sergio", 18));
		listaPersonas.add(new Persona("Ñu", 32));
		listaPersonas.add(new Persona("Joséba", 26));
		listaPersonas.add(new Persona("Mário", 29));
		listaPersonas.add(new Persona("Áritz", 20));
		listaPersonas.add(new Persona("fran", 33));
		listaPersonas.add(new Persona("Maitane", 28));
		listaPersonas.add(new Persona("Jose", 99));

	}

	@After
	public void tearDown() throws Exception {
		listaPersonas = null;
	}

	@Test
	public void test() {
		// Ordenamos alfabeticamente
		Collections.sort(listaPersonas);

		assertEquals("Áritz", listaPersonas.get(0).getNombre());
		assertEquals("fran", listaPersonas.get(1).getNombre());
		assertEquals("Jon", listaPersonas.get(2).getNombre());
		assertEquals("Jose", listaPersonas.get(3).getNombre());
		assertEquals("Joséba", listaPersonas.get(4).getNombre());
		assertEquals("kepa", listaPersonas.get(5).getNombre());
		assertEquals("Maitane", listaPersonas.get(6).getNombre());
		assertEquals("Mário", listaPersonas.get(7).getNombre());
		assertEquals("Ñu", listaPersonas.get(8).getNombre());
		assertEquals("Sergio", listaPersonas.get(9).getNombre());
		assertEquals("Susána", listaPersonas.get(10).getNombre());
		assertEquals("Úrko", listaPersonas.get(11).getNombre());
		assertEquals("Zuhaitz", listaPersonas.get(12).getNombre());

		// Ordenamos por edad
		Collections.sort(listaPersonas, new comparatorEdad());

		assertEquals("Sergio", listaPersonas.get(0).getNombre());
		assertEquals("Áritz", listaPersonas.get(1).getNombre());
		assertEquals("Susána", listaPersonas.get(2).getNombre());
		assertEquals("Joséba", listaPersonas.get(3).getNombre());
		assertEquals("Maitane", listaPersonas.get(4).getNombre());
		assertEquals("Mário", listaPersonas.get(5).getNombre());
		assertEquals("Zuhaitz", listaPersonas.get(6).getNombre());
		assertEquals("Ñu", listaPersonas.get(7).getNombre());
		assertEquals("fran", listaPersonas.get(8).getNombre());
		assertEquals("kepa", listaPersonas.get(9).getNombre());
		assertEquals("Jon", listaPersonas.get(10).getNombre());
		assertEquals("Úrko", listaPersonas.get(11).getNombre());
		assertEquals("Jose", listaPersonas.get(12).getNombre());
	}
}
