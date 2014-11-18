package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {
	Concesionario concesionario = null;

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
	public void testComprarCoche() {
		// usar la palabra reservada instanceof

		Vehiculo ve = concesionario.comprarVehiculo(true); // electrico
		Vehiculo vg = concesionario.comprarVehiculo(false); // gasolina

		// test que es vehiculo electrico y no gasolina
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);
		assertTrue(ve instanceof Vehiculo);

		assertFalse(vg instanceof VehiculoElectrico);
		assertTrue(vg instanceof VehiculoGasolina);
		assertTrue(vg instanceof Vehiculo);

	}

	/**
	 * Queremos testear que si compro un VehiculoElectrico pueda saber la
	 * CapacidadBaterias
	 */
	@Test
	public void testComprarCocheElectrico() {

		Vehiculo ve = concesionario.comprarVehiculo(true);
		assertTrue("No es una instancia de VehiculoElectrico",
				ve instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {
			// castear de Vehiculo a VehiculoElectrico
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();
			assertTrue(true);

			// casteo directo
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue(true);
		}
	}

	/**
	 * Test para comprobar el numero de ventas por Concesionario y
	 * ventasGlobales
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario</code></li>
	 * <li>Objeto1 vende 3 vehiculos</li>
	 * <li>Objeto2 vende 5 vehiculos</li>
	 * <li>test ventas ==3 en objeto1</li>
	 * <li>test ventas ==5 en objeto2</li>
	 * <li>test ventasGlobales ==8 en objeto1 y objeto2</li>
	 * </ul>
	 */

	@Test
	public void testVentas() {

		for (int i = 0; i < 3; i++) {
			concesionario.comprarVehiculo(true);

		}

		Concesionario concesionario2 = new Concesionario();

		for (int i = 0; i < 5; i++) {
			concesionario2.comprarVehiculo(true);
		}

		assertEquals(
				"El numero de vehiculos vendidos en concesionario 1 no es correcto",
				concesionario.getVentas(), 3);
		assertEquals(
				"El numero de vehiculos vendidos en concesionario 2 no es correcto",
				concesionario2.getVentas(), 5);

		// ventas globales
		assertEquals(
				"El numero de vehiculos vendidos en todos los concesionario no es correcto",
				Concesionario.getVentasGlobales(), 8);
		assertSame(
				"El numero de vehiculos vendidos en todos los concesionario no es correcto",
				8, Concesionario.getVentasGlobales());
		assertSame(
				"El numero de vehiculos vendidos en todos los concesionario no es correcto",
				8, Concesionario.getVentasGlobales());

	}
}
