package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {
	Concesionario concesionario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		concesionario = new Concesionario();

	}

	@After
	public void tearDown() throws Exception {
		concesionario = null;

	}

	@Test
	public void testComprarCoche() {
		// usar la palabra reservada instanceof
		Vehiculo ve = concesionario.comprarVehiculo(true);
		Vehiculo vg = concesionario.comprarVehiculo(false);

		// test que es vehiculo electrico y no es gasolina
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);

		assertTrue(vg instanceof VehiculoGasolina);
		assertFalse(vg instanceof VehiculoElectrico);
	}

	/**
	 * queremos testear que si compro un VehiculoElectrico pueda saber la
	 * capacidadBaterias.
	 */
	@Test
	public void testComprarCocheElectrico() {

		Vehiculo ve = concesionario.comprarVehiculo(true);
		assertTrue(ve instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();
			assertTrue(true);
			// casteo directo
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue(true);
		}

	}

	/**
	 * test para comprobar el numero de ventas por concesionario y ventas
	 * globales
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo concesionario</li>
	 * <li>objeto1 vende 3 vehiculos</li>
	 * <li>objeto2 vende 5 vehiculor</li>
	 * <li>test ventas == 3 en objeto1</li>
	 * <li>test ventas == 5 en objeto2</li>
	 * <li>test ventas == 8 en objeto1 y objeto2</li>
	 * </ul>
	 */
	@Test
	public void testVentas() {
		Concesionario conc1 = new Concesionario();
		Concesionario conc2 = new Concesionario();
		conc1.setVentasGlobales(0);
		for (int i = 0; i < 3; i++) {
			conc1.comprarVehiculo(true);
		}

		for (int i = 0; i < 5; i++) {
			conc2.comprarVehiculo(true);
		}

		assertEquals(3, conc1.getVentas());
		assertEquals(5, conc2.getVentas());
		assertEquals(8, Concesionario.getVentasGlobales());
	}
}
