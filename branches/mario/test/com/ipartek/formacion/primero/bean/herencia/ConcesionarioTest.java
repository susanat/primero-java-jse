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

	Concesionario concesionario = null;

	private static final int VENTAS1 = 3;
	private static final int VENTAS2 = 5;

	private static final int VENTAGLOBAL = VENTAS1 + VENTAS2;

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
	public void testComprarVehiculo() {
		// usar la palabra reservada instanceof

		Vehiculo ve = concesionario.comprarVehiculo(true); // electrico
		Vehiculo vg = concesionario.comprarVehiculo(false); // gasolina

		// test que es vehiculo electrico y no es gasolina
		assertTrue(ve instanceof VehiculoElectrico);
		assertFalse(ve instanceof VehiculoGasolina);
		assertTrue(ve instanceof Vehiculo);

		assertTrue(vg instanceof VehiculoGasolina);
		assertFalse(vg instanceof VehiculoElectrico);
		assertTrue(vg instanceof Vehiculo);

	}

	/**
	 * Queremos testear que si compro un VehiculoElectrico pueda saber la
	 * CapacidadBaterias
	 */
	@Test
	public void testComprarVehiculoElectrico() {

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
	 * Test para comprobar el numero de ventas por <code>Concesionario</code> y
	 * <code>ventasGlobales</code>
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario</code></li>
	 * <li>objeto1 vende 3 <code>Vehiculos </code></li>
	 * <li>objeto2 vende 5 <code>Vehiculos </code></li>
	 * <li>Test ventas == 3 en objeto1 </code></li>
	 * <li>Test ventas == 5 en objeto1 </code></li>
	 * <li>Test ventasGlobales == 8 en objeto1 y objeto2 </code></li>
	 * </ul>
	 *
	 */
	@Test
	public void testVentas() {
		Concesionario concBilbao = new Concesionario();
		Concesionario concGalda = new Concesionario();

		for (int i = 0; i < VENTAS1; i++) {
			concBilbao.comprarVehiculo(false);
		}
		for (int i = 0; i < VENTAS2; i++) {
			concGalda.comprarVehiculo(true);
		}

		assertEquals("Ventas por concesionario erroneas", VENTAS1,
				concBilbao.getVentas());
		assertEquals("Ventas por concesionario erroneas", VENTAS2,
				concGalda.getVentas());

		// Ventas globales en ambos objetos
		assertEquals(VENTAGLOBAL, concGalda.getVentasGlobales());
		assertEquals(VENTAGLOBAL, concBilbao.getVentasGlobales());
	}
}
