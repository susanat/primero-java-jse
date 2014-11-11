package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehiculoElectricoTest {

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
	public void testVehiculoElectrico() {
		// Comprobar que llamamos al constructor del padre
		VehiculoElectrico ve = new VehiculoElectrico();

		assertEquals(VehiculoElectrico.MIN_CAP_BATERIA,
				ve.getCapacidadBaterias(), Float.MIN_VALUE);

		assertEquals(VehiculoElectrico.MIN_DIM, ve.getDimensiones(),
				Float.MIN_VALUE);

		assertEquals("La potencia mínima de un vehículo eléctrico debe ser "
				+ VehiculoElectrico.MIN_POTENCIA,
				VehiculoElectrico.MIN_POTENCIA, ve.getPotencia(),
				Float.MIN_VALUE);

		assertEquals(VehiculoElectrico.MIN_PLAZAS, ve.getNumPlazas());
	}

}
