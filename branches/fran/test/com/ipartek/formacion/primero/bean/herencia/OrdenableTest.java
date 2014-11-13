package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.util.Utilidades;

public class OrdenableTest {

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
	public void testConArray() {
		Ordenable[] array = new Ordenable[5];
		array[0] = new Churro(330f);
		array[1] = new VehiculoElectrico(120f);
		array[2] = new Churro(100f);
		array[3] = new VehiculoElectrico(101f);
		array[4] = new VehiculoElectrico(200f);
		Utilidades.ordenarOrd(array);
		assertTrue("Primer elemento mal", array[0].getPeso() == 100f);
		assertTrue("Segundo elemento mal", array[1].getPeso() == 101f);
		assertTrue("Tercero elemento mal", array[2].getPeso() == 120f);
		assertTrue("Cuarto elemento mal", array[3].getPeso() == 200f);
		assertTrue("Quinto elemento mal", array[4].getPeso() == 330f);
	}

	@Test
	public void testConArrayList() {
		ArrayList<Ordenable> alOrdenable = new ArrayList<Ordenable>();
		alOrdenable.add(new Churro(330f));
		alOrdenable.add(new VehiculoElectrico(120f));
		alOrdenable.add(new Churro(100f));
		alOrdenable.add(new VehiculoElectrico(101f));
		alOrdenable.add(new VehiculoElectrico(200f));
		Collections.sort(alOrdenable, new ComparatorOrdenable());
		assertTrue("Primer elemento mal", alOrdenable.get(0).getPeso() == 100f);
		assertTrue("Segundo elemento mal", alOrdenable.get(1).getPeso() == 101f);
		assertTrue("Tercero elemento mal", alOrdenable.get(2).getPeso() == 120f);
		assertTrue("Cuarto elemento mal", alOrdenable.get(3).getPeso() == 200f);
		assertTrue("Quinto elemento mal", alOrdenable.get(4).getPeso() == 330f);

	}

}
