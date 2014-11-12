package com.ipartek.formacion.proyectoclase.pojo.herencia;

import static org.junit.Assert.assertFalse;
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
	}

	@After
	public void tearDown() throws Exception {
		con1 = null;
		con2 = null;
	}

	@Test
	public void testComprarVehiculo() {
		Vehiculo ve;
		Vehiculo vg;
		// para usar la palabra reservada instance of
		ve = con1.comprarVehiculo(true);
		vg = con1.comprarVehiculo(false);

		assertTrue("", ve instanceof VehiculoElectrico);
		assertFalse("", ve instanceof VehiculoGasolina);

		assertTrue("", vg instanceof VehiculoGasolina);
		assertFalse("", vg instanceof VehiculoElectrico);

		if (ve instanceof VehiculoElectrico) {
			VehiculoElectrico vel = (VehiculoElectrico) ve;
			vel.getCapaBateria();
			assertTrue("No se consigio", true);
			((VehiculoElectrico) ve).getCapaBateria();
			assertTrue("No se consigio", true);
		}
	}

	/**
	 * Test para comprobar el número de ventas por Concesionario y ventas
	 * globales
	 * <ul>
	 * <li>Instanciar 2 objetos de tipo <code>Concesionario</code></li>
	 * <li>Objeto1 vende 3 vehiculos</li>
	 * <li>Objetos vende 5 vehiculos</li>
	 * <li>test ventas == 3 en obejto1</li>
	 * <li>test ventas == 5 en objeto2</li>
	 * <li>test ventas Globales == 8 en objeto1 y objeto2</li>
	 * </ul>
	 */
	@Test
	public void testVentas() {
		Concesionario.resetearCompraVehiculos();
		con1.comprarVehiculo(false);
		con1.comprarVehiculo(false);
		con1.comprarVehiculo(false);

		con2.comprarVehiculo(true);
		con2.comprarVehiculo(true);
		con2.comprarVehiculo(true);
		con2.comprarVehiculo(true);
		con2.comprarVehiculo(true);

		assertTrue("", 3 == con1.getVenta());
		assertTrue("", 5 == con2.getVenta());
		assertTrue("El valor de Venta global es: " + con1.getVentaGlobal()
				+ " y " + con2.getVentaGlobal(), 8 == con1.getVentaGlobal()
				&& con2.getVentaGlobal() == 8);

	}
}
