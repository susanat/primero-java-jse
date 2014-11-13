package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChurroElectricoTest {

	VehiculoElectrico ve1 = null;
	VehiculoElectrico ve2 = null;
	VehiculoElectrico ve3 = null;

	Churro ch1 = null;
	Churro ch2 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ve1 = new VehiculoElectrico(100.0f);
		ve2 = new VehiculoElectrico(0.0f);
		ve3 = new VehiculoElectrico(10.0f);

		ch1 = new Churro("Chocolate", 50);
		ch2 = new Churro("Normal", 35);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test para ordenar de menor a mayor las calorías de los
	 * <code>Churro</code> y la potencia de <code>VehiculoElectrico</code>
	 */
	@Test
	public void testChurros() {
		// VE100 CH50 CH35 VE0 VE10

		ArrayList<Ordenable> churrosVElectrico = new ArrayList<Ordenable>();

		churrosVElectrico.add(ve1);
		churrosVElectrico.add(ch1);
		churrosVElectrico.add(ch2);
		churrosVElectrico.add(ve2);
		churrosVElectrico.add(ve3);

		// Ordenamos sobre Churros y Vehiculos
		Collections.sort(churrosVElectrico, new ComparatorCVE());

		assertEquals(0, churrosVElectrico.get(0).getPeso());
		assertEquals(10, churrosVElectrico.get(1).getPeso());
		assertEquals(35, churrosVElectrico.get(2).getPeso());
		assertEquals(50, churrosVElectrico.get(3).getPeso());
		assertEquals(100, churrosVElectrico.get(4).getPeso());

	}

}
