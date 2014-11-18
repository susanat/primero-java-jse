package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChurrosElectricosTest {

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
	public void testOrdenarChurrosVehiculos() {

		ArrayList<Ordenable> lista = new ArrayList<Ordenable>();

		lista.add(new VehiculoElectrico(100f));
		lista.add(new VehiculoElectrico(200f));
		lista.add(new VehiculoElectrico(35f));
		lista.add(new VehiculoElectrico(50f));
		lista.add(new VehiculoElectrico(125f));

		lista.add(new Churro(34f));
		lista.add(new Churro(156f));
		lista.add(new Churro(73f));
		lista.add(new Churro(125f));
		lista.add(new Churro(201f));

		Collections.sort(lista, new ComparatorOrdenable());

		// test ordenacion del 1º y ultimo
		assertEquals(12, lista.get(0).getPeso());
		assertEquals(101, lista.get(3).getPeso());
		assertEquals(1030, lista.get((lista.size() - 1)).getPeso());

	}

}
