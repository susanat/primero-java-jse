package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {

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
	public void testComprarVehiculo() throws Exception {
		// Usar la palabra reservada instanceof
		Vehiculo ve = Concesionario.comprarVehiculo(true); // eléctrico
		Vehiculo vg = Concesionario.comprarVehiculo(false); // gasolina

		// Test que es vehículo eléctrico
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);
		assertTrue(ve instanceof Vehiculo);

		// Test que es vehículo gasolina
		assertFalse(vg instanceof VehiculoElectrico);
		assertTrue(vg instanceof VehiculoGasolina);
		assertTrue(vg instanceof Vehiculo);
	}

	/**
	 * Si se compra un VehiculoElectrico pueda saber la CapacidadBaterias
	 * 
	 * @throws Exception
	 */
	@Test
	public void testComprarVehiculoElectrico() throws Exception {
		Vehiculo v = Concesionario.comprarVehiculo(true);
		assertTrue("No es una instancia de VehiculoElectrico",
				v instanceof VehiculoElectrico);

		if (v instanceof VehiculoElectrico) {
			((VehiculoElectrico) v).getCapacidadBaterias();
			assertTrue(true);
		}
	}

}
