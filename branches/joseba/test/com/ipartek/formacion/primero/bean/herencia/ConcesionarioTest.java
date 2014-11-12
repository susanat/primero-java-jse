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

	Concesionario concesionarioBasauri = null;
	Concesionario concesionario1 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		concesionario1 = new Concesionario();
		concesionario1.setVentasGlobales(0);
		concesionarioBasauri = new Concesionario();
	}

	@After
	public void tearDown() throws Exception {
		concesionarioBasauri = null;
	}

	@Test
	public void testComprarCoche() {

		// usaremos instanceOf
		Vehiculo ve = concesionarioBasauri.comprarVehiculo(true); // Electrico
		Vehiculo vg = concesionarioBasauri.comprarVehiculo(false); // Gasolina

		assertTrue("El vehiculo no es electrico",
				ve instanceof VehiculoElectrico);
		assertFalse("El vehiculo es de gasolina",
				ve instanceof VehiculoGasolina);
		assertTrue("No es una instancia de Vehiculo", ve instanceof Vehiculo);

		assertTrue("El vehiculo no es gasolina", vg instanceof VehiculoGasolina);
		assertFalse("El vehiculo es electrico", vg instanceof VehiculoElectrico);
		assertTrue("No es una instancia de Vehiculo", vg instanceof Vehiculo);

	}

	/**
	 * Queremos testear que si compramos un VehiculoElectrico podemos saber la
	 * capacidad de las baterias
	 */
	@Test
	public void testComprarCocheElectrico() {
		Vehiculo ve = concesionarioBasauri.comprarVehiculo(true);
		assertTrue("No es una instancia de VehiculoElectrico",
				ve instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {

			// Castear de Vehiculo a VehiculoElectrico de forma intermedia
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();
			assertTrue(true);

			// casteo de forma directa
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue(true);

		}

	}

	/**
	 * Test para comprobar el numero de ventas por concesionario y ventas
	 * globales
	 * <ul>
	 * <li>Instanciar dos objetos de tipo Concesionario</li>
	 * <li>Objeto 1 vende 3 vehiculos</li>
	 * <li>Objeto 2 vende 5 vehiculos</li>
	 * <li>Test ventas == 3 en objeto 1</li>
	 * <li>Test ventas == 5 en objeto 2</li>
	 * <li>Test ventasGlobales == 8 en objeto 1 y objeto 2</li>
	 * </ul>
	 */

	@Test
	public void testVentas() {

		Concesionario CBarakaldo = new Concesionario();
		Concesionario CBasauri = new Concesionario();

		// Los concesionarios venden 3 y 5 coches respectivamente

		for (int i = 0; i < 3; i++) {
			CBarakaldo.comprarVehiculo(true);
		}
		assertEquals(3, CBarakaldo.getVentas());

		for (int i = 0; i < 5; i++) {
			CBasauri.comprarVehiculo(false);
		}
		assertEquals(5, CBasauri.getVentas());

		// Comprobacion de ventas globales
		assertEquals(8, CBarakaldo.getVentasGlobales());
		assertEquals(8, CBasauri.getVentasGlobales());

	}
}
