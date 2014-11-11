package com.ipartek.formacion.proyectoclase.pojo.herencia;

import static org.junit.Assert.*;

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
	public void testComprarVehiculo() {
		Vehiculo ve;
		Vehiculo vg;
		//para usar la palabra reservada instance of
		ve = Concesionario.comprarVehiculo(true);
		vg = Concesionario.comprarVehiculo(false);
		
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

}
