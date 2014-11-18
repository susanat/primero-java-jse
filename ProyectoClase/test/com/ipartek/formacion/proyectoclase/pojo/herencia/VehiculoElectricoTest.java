package com.ipartek.formacion.proyectoclase.pojo.herencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehiculoElectricoTest {
	private static final float DELTA = 0f;
	private static VehiculoElectrico veDefecto;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		veDefecto = new VehiculoElectrico();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		veDefecto = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVehiculoElectrico() {
	//	fail("Not yet implemented");
		assertEquals(VehiculoElectrico.MIN_CAP_BATERIA,
					veDefecto.getCapacidadBateria(),
					DELTA);

		assertEquals(VehiculoElectrico.MIN_PLAZAS,
					veDefecto.getNumPlazas(),
					DELTA);

		assertEquals(VehiculoElectrico.MIN_POTENCIA,
				veDefecto.getPotencia(),
				DELTA);

		assertEquals(VehiculoElectrico.MIN_DIM,
				veDefecto.getDim(),
				DELTA);

	}
}
