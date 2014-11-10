package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalificacionTest {

	Calificacion caliNull;
	
	static final float DELTA = 0.0f; //desviacion permitida
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
			
		caliNull = new Calificacion(null, Calificacion.MAX_NOTA , new Timestamp(0));
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructores() {
		
		
		assertSame( Calificacion.ASIGNATURA_EMPTY , caliNull.getAsignatura());
		assertEquals( Calificacion.MAX_NOTA ,caliNull.getNota(), DELTA );
		
		//TODO mirar como compararlo
		//assertEquals( new Timestamp(0), caliNull.getFecha());
	}
	
	@Test
	public void testNotas() {
		//test nota negativa
		caliNull.setNota(-2);
		assertEquals( "No puede tener nota < 0", Calificacion.MIN_NOTA ,caliNull.getNota(), DELTA );
		
		
		//test nota mayor 10
		caliNull.setNota( 11 );
		assertEquals( "No puede tener nota > 10", Calificacion.MAX_NOTA ,caliNull.getNota(), DELTA );
		
		
		
	}

}
