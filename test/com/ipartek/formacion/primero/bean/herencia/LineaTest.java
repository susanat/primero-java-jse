package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LineaTest {
	public static final int PUNTO_X = 3 ; 
	public static final int PUNTO_Y = 5 ; 
	public static final int LONG = 4 ; 
	
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
	public void testLinea() {
		Linea lv = new Linea();
		Linea lp = new Linea( PUNTO_X, PUNTO_Y, LONG );
		
		
		assertEquals( Figura.ORIGEN_X, lv.getPunto().getX() );
		assertEquals( Figura.ORIGEN_Y, lv.getPunto().getY() );
		assertEquals( Linea.LONG_MIN, lv.getLongitud() );
		
		
		assertEquals( PUNTO_X, lp.getPunto().getX() );
		assertEquals( PUNTO_Y, lp.getPunto().getY() );
		assertEquals( LONG, lp.getLongitud() );
	}

}
