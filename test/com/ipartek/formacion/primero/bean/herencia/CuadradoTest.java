package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuadradoTest {
	public static final int PUNTO_X = 3 ; 
	public static final int PUNTO_Y = 5 ; 
	public static final int CARA = 4 ; 
	
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
	public void testCuadrado() {
		
		Cuadrado cv = new Cuadrado();
		Cuadrado cp = new Cuadrado( PUNTO_X, PUNTO_Y, CARA );
		
		
		assertEquals( Figura.ORIGEN_X, cv.getPunto().getX() );
		assertEquals( Figura.ORIGEN_Y, cv.getPunto().getY() );
		assertEquals( Cuadrado.LONG_MIN, cv.getCara() );
		
		
		assertEquals( PUNTO_X, cp.getPunto().getX() );
		assertEquals( PUNTO_Y, cp.getPunto().getY() );
		assertEquals( CARA, cp.getCara() );
				
	}
	


}
