package com.ipartek.formacion.proyectoclase.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
	
public class LibroTest {
	private static Libro lPorDefecto;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lPorDefecto = new Libro();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		lPorDefecto = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	/*empiezan nuestros test unitarios (tb hay test funcionales que son los que se encargan de
	 *  
	 */
	@Test
	public void testLibro() {		
		assertTrue("No son el numero de paginas esperadas: Se esperaba 0 y es "+lPorDefecto.getN_paginas(),lPorDefecto.getN_paginas()==0);
		assertTrue("No es el titulo introducido por defecto: se esperaba \"sin definir\" y es"+lPorDefecto.getTitulo(),"sin definir".equals(lPorDefecto.getTitulo()));
	}

}
