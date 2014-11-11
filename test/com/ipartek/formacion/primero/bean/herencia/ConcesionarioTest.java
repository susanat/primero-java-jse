package com.ipartek.formacion.primero.bean.herencia;

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
	public void testComprarCoche() {
		//usaremos instanceOf
		Vehiculo ve = Concesionario.comprarVehiculo(true); //Electrico
		Vehiculo vg = Concesionario.comprarVehiculo(false); // Gasolina
		
		assertTrue("El vehiculo no es electrico", ve instanceof VehiculoElectrico );
		assertFalse("El vehiculo es de gasolina", ve instanceof VehiculoGasolina);
		assertTrue("No es una instancia de Vehiculo", ve instanceof Vehiculo);
		
		assertTrue("El vehiculo no es gasolina", vg instanceof VehiculoGasolina );
		assertFalse("El vehiculo es electrico", vg instanceof VehiculoElectrico);
		assertTrue("No es una instancia de Vehiculo", vg instanceof Vehiculo);
		
	}
	
	
	/**
	 * Queremos testear que si compramos un VehiculoElectrico podemos saber la capacidad de las baterias
	 */
	@Test
	public void testComprarCocheElectrico(){
		Vehiculo ve = Concesionario.comprarVehiculo(true);
		assertTrue("No es una instancia de VehiculoElectrico", ve instanceof VehiculoElectrico);
		
		if(ve instanceof VehiculoElectrico){
			
			//Castear de Vehiculo a VehiculoElectrico de forma intermedia
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();
			assertTrue(true);
			
			//casteo de forma directa
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue(true);
		
		}
		
		
		
	}

}
