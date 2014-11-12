package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {

	Concesionario concesionario = new Concesionario();

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
		// uasr la palabra reservada instanceof

		Vehiculo ve = concesionario.comprarVehiculo(true);// electrico
		Vehiculo vg = concesionario.comprarVehiculo(false);// gasolina

		// test que es vehiculo electrico o no
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);
		assertTrue(ve instanceof Vehiculo);

		assertFalse(vg instanceof VehiculoElectrico);
		assertTrue(vg instanceof VehiculoGasolina);
		assertTrue(vg instanceof Vehiculo);
	}

	/**
	 * Queremos testear que si compro un vehiculo electrico pueda saber la
	 * CapacidadBateria
	 */
	@Test
	public void testComprarCocheElectrico() {

		Vehiculo ve = concesionario.comprarVehiculo(true);
		assertTrue(ve instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {
			// Castear de vehiculo a VehiculoElectrico
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			// mejor el casteo directo
			ve2.getCapacidadBaterias();
			assertTrue("No se consigio castar en una nueva variable", true);

			// casteo directo
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue("No se consigio casteo directo", true);
		}

	}

	/**
	 * Test para comprobar el numero de ventas por Concesionario y
	 * ventasglobales
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario</code></li>
	 * <li>objeto1 vende 3 vehiculos</li>
	 * <li>objeto2 vende 5 vehiculos</li>
	 * <li>test ventas == 3 en objeto1</li>
	 * <li>test ventas == 5 en objeto1</li>
	 * <li>test ventasGlobales == 8 en objeto1 y objeto2</li>
	 * </ul>
	 */

	@Test
	public void testVentas() {

		Concesionario c1 = new Concesionario();
		Concesionario c2 = new Concesionario();

		for (int i = 0; i < 3; i++) {
			c1.comprarVehiculo(true);
		}
		assertSame("Ventas por concesionario", 3, c1.getVentas());

		for (int i = 0; i < 5; i++) {
			c2.comprarVehiculo(true);
		}
		assertSame("Ventas por concesionario", 5, c2.getVentas());

		// ventas Globales
		assertSame("Ventas Gloables", 8, Concesionario.getVentasGlobales());
		assertSame("Ventas Gloables", 8, c2.getVentasGlobales());
		assertSame("Ventas Gloables", 8, c1.getVentasGlobales());

	}

}
