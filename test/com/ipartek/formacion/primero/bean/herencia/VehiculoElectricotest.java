package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehiculoElectricotest {
	
	static final float DELTA = 0f;

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
	public void testVehiculoElectrico(){
		
		//comprobamos q llamamos al constructor del padre vehiculo
		VehiculoElectrico ve= new VehiculoElectrico();
		assertEquals(VehiculoElectrico.MIN_CAP_BATERIA, ve.getCapacidadBaterias(), Float.MIN_VALUE);
		
		assertEquals(VehiculoElectrico.MIN_DIM, ve.getDimensiones(), Float.MIN_VALUE);
		
		assertEquals("La potencia minima de un vehiculo electrico debe ser: " + VehiculoElectrico.MIN_POTENCIA,VehiculoElectrico.MIN_POTENCIA, ve.getPotencia(), Float.MIN_VALUE);
		
		assertEquals(VehiculoElectrico.MIN_PLAZAS, ve.getNumPlazas());
		
	}
	
}
