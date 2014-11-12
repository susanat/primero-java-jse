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
	public void testComprarVehiculo() {
		//usar la palabra reservada instanceof
		
		Vehiculo ve = Concesionario.comprarVehiculo(true); //electrico
		Vehiculo vg = Concesionario.comprarVehiculo(false); //gasolina
		
		//test que es vehiculo electrico y no es gasolina
		assertTrue(  ve instanceof VehiculoElectrico );
		assertFalse( ve instanceof VehiculoGasolina );
		assertTrue(  ve instanceof Vehiculo );
	
		assertTrue(  vg instanceof VehiculoGasolina );
		assertFalse( vg instanceof VehiculoElectrico );
		assertTrue(  vg instanceof Vehiculo );
		
	}
	
	/**
	 * Queremos testear que si compro un VehiculoElectrico pueda saber la CapacidadBaterias
	 */
	@Test
	public void testComprarVehiculoElectrico() {
		Vehiculo ve = Concesionario.comprarVehiculo(true);
		assertTrue( "No es una instancia de VehiculoElectrico", ve instanceof VehiculoElectrico );
		
		if ( ve instanceof VehiculoElectrico){
			//castear de Vehiculo a VehiculoElectrico
			VehiculoElectrico ve2 = (VehiculoElectrico) ve;
			ve2.getCapacidadBaterias();
			
			assertTrue (true);
			
			//casteo directo
			((VehiculoElectrico) ve).getCapacidadBaterias();
			assertTrue (true);
		}
		
	}

}












