package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {

	static Concesionario concesionario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		concesionario = new Concesionario();
		Concesionario.setVentasGlobales(0);
	}

	@After
	public void tearDown() throws Exception {
		concesionario = null;
	}

	@Test
	public void testComprarVehiculo() throws Exception {
		// Usar la palabra reservada instanceof
		Vehiculo ve = concesionario.comprarVehiculo(true); // eléctrico
		Vehiculo vg = concesionario.comprarVehiculo(false); // gasolina

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
		Vehiculo v = concesionario.comprarVehiculo(true);
		assertTrue("No es una instancia de VehiculoElectrico",
				v instanceof VehiculoElectrico);

		if (v instanceof VehiculoElectrico) {
			((VehiculoElectrico) v).getCapacidadBaterias();
			assertTrue(true);
		}
	}

	/**
	 * Test para comprobar el número de ventas por Concesionario y ventas
	 * generales
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario<code></li>
	 * <li>Objeto1 vende 3 <code>Vehiculo<code></li>
	 * <li>Objeto2 vende 5 <code>Vehiculo<code></li>
	 * <li>test ventas == 3 en objeto1</li>
	 * <li>test ventas == 5 en objeto2</li>
	 * <li>test ventasGlobales == 8 en objeto1 y objeto2</li>
	 * <ul>
	 */
	@Test
	public void testVentas() throws Exception {
		Concesionario c1 = new Concesionario();
		Concesionario c2 = new Concesionario();

		for (int i = 1; i <= 8; i++) {
			if (i <= 3) {
				c1.comprarVehiculo((i % 2 == 0) ? true : false);
			} else {
				c2.comprarVehiculo((i % 2 == 0) ? true : false);
			}
		}

		assertTrue(
				"Las ventas globales de vehículos se están contabilizando mal.",
				Concesionario.ventasGlobales == 8);
		assertTrue(
				"Las ventas de vehículos por concesionario se están contabilizando mal.",
				c1.getVentas() == 3);
		assertTrue(
				"Las ventas de vehículos por concesionario se están contabilizando mal.",
				c2.getVentas() == 5);

		c1 = null;
		c2 = null;
	}
}
