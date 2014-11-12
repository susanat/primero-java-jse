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
		concesionario.setVentasGlobales(0);
	}

	@After
	public void tearDown() throws Exception {
		concesionario = null;
	}

	@Test
	public void testComprarCoche() {

		Vehiculo ve = concesionario.comprarVehiculo(true); // electrico
		Vehiculo vg = concesionario.comprarVehiculo(false); // gasolina

		// test q es vheiculo electrico y no gasolina
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);
		assertTrue(ve instanceof Vehiculo);

		// test q es vheiculo gasolina y no electrico
		assertTrue(vg instanceof VehiculoGasolina);
		assertFalse(vg instanceof VehiculoElectrico);
		assertTrue(vg instanceof Vehiculo);

	}

	/**
	 * queremos testear q si compro un vehiculo electrico pueda saber la
	 * CapacidadBaterias
	 */
	@Test
	public void testComprarCocheElectrico() {

		Vehiculo ve = concesionario.comprarVehiculo(true);
		assertTrue(ve instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {
			// castear de vehiculo a vehiculoelectrico
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();

			assertTrue("No se consiguio castear en una nueva variable", true);

			// casteo directo
			((VehiculoElectrico) ve).getCapacidadBaterias();

			assertTrue("no se consiguio casteo directo", true);
		}
	}

	/**
	 * test para comprobar el numero de ventas por concesionario y ventas
	 * globales
	 * <ul>
	 * <li>instanciar 2 objetos de tipo <code>concesionario</code></li>
	 * <li>objeto 1 vende 3 vehiculos</li>
	 * <li>objeto 2 vende 5 vwehiculos</li>
	 * <li>testventas==3 en onjeto 1</li>
	 * <li>testventas==5 en onjeto 2</li>
	 * <li>test ventasGlobales == 8</li>
	 * </ul>
	 */
	@Test
	public void testVentas() {

		int ventasLeio = 2;
		int ventasBaraka = 5;

		Concesionario leioa = new Concesionario();
		Concesionario baraka = new Concesionario();

		for (int i = 0; i < ventasLeio; i++) {
			leioa.comprarVehiculo(true);
		}

		assertSame("ventas por concesionario", 3, leioa.getVentas());

		for (int i = 0; i < ventasBaraka; i++) {
			baraka.comprarVehiculo(true);
		}

		assertSame("ventas por concesionario", 5, baraka.getVentas());

		// ventas globales
		assertSame("ventas globales", 8, Concesionario.getVentasGlobales());
		assertSame("ventas globales", 8, leioa.getVentasGlobales());
		assertSame("ventas globales", 8, baraka.getVentasGlobales());

	}
}
