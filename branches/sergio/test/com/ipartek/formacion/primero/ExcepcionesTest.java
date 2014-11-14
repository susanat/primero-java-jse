package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona;
import com.ipartek.formacion.sergio.utils.ClsUtilsFechas;

public class ExcepcionesTest {

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
	public void test() {
		
		//Forzamos excepcion
		Persona p = null;
		
		try{
			p.getApellido1();
			assertTrue("No debería ejecutar esta línea", false);
		}catch(Exception ex){
			assertTrue(true);
		} finally {
			//se tendría que ejecutar siempre		
			System.out.println(ClsUtilsFechas.getCurrentTimestamp().toString());
			
			Long prueba = ClsUtilsFechas.getCurrentTimestamp().getTime();
			System.out.println(prueba);
			
			
			System.out.println(new Timestamp(prueba));
			
		}
		
	}

}
