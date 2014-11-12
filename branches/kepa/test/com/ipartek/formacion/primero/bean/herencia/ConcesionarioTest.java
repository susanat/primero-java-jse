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
	private Concesionario con1;
	private Concesionario con2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con1 = new Concesionario();
		con2 = new Concesionario();
		Concesionario.setVentaGlobal(0);
	}

	@After
	public void tearDown() throws Exception {
		con1 = null;
		con2 = null;
	}

	@Test
	public void testComprarCoche() {
		// usar la palabra reservada instanceof

		Vehiculo ve = con1.comprarVehiculo(true); // electrico
		Vehiculo vg = con1.comprarVehiculo(false); // gasolina

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
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario</code></li>
	 * <li>Objeto1 vende 3 vehiculos</li>
	 * <li>Objeto2 vende 5 vehiculos</li>
	 * <li>Test ventas == 3 en objeto1</li>
	 * <li>Test ventas == 5 en objeto2</li>
	 * <li>Test ventasGlobales == 8 en objeto1 y objeto2</li>
	 * </ul>
	 */
	@Test
	public void testVentas() {

		for (int i = 0; i < 3; i++) {
			con1.comprarVehiculo(true);
		}

		assertSame("Ventas por concesionario", 3, con1.getVenta());

		for (int i = 0; i < 5; i++) {
			con2.comprarVehiculo(true);
		}

		assertSame("Ventas por concesionario", 5, con2.getVenta());

	}

	@Test
	public void testComprarCocheElectrico() {

		Vehiculo ve = con1.comprarVehiculo(true);
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

}
