package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehiculoElectricoTest {

	//desviación de los float para la comparación de float
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
	public void testVehiculoElectrico() {
		//comprobar que llamamos al constructor del padre vehiculo
		VehiculoElectrico obj = new VehiculoElectrico();
		
		//Resultados esperados
		assertEquals(VehiculoElectrico.MIN_CAPACIDAD_BATERIA, obj.getCapacidadBaterias(), DELTA);
		assertEquals(VehiculoElectrico.MIN_DIM, obj.getDimensiones(), DELTA);
		assertEquals(VehiculoElectrico.MIN_PLAZAS, obj.getNumPlazas());
		assertEquals(VehiculoElectrico.MIN_POTENCIA, obj.getPotencia(), DELTA);
		
		assertEquals(obj.getCapacidadBaterias(), obj.getPeso(), DELTA);
		
		
		
	}

}
