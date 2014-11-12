package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChurrosTest {

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
	public void test() {
		
		churros obj = new churros(50);
		
		assertEquals(obj.getCalorias(), obj.getPeso(), DELTA);
		
		
		//ordenar array
		
		IOrdenable[] aObjetos = 
			{ 
				new VehiculoElectrico(90),
				new churros(50), 
				new churros(10), 
				new churros(60), 
				new VehiculoElectrico(10),
				new VehiculoElectrico(100),
			};
		
		
		
	}

}
