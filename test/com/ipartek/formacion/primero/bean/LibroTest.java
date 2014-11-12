package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {

	// Variable de libro global
	static Libro libroPorDefecto;
	
	static Libro libroConParametros;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//inicializar la variable
		libroPorDefecto = new Libro();
		libroConParametros = new Libro(2,"hola");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		//Destruyo la variable en el recolector de basura
		libroPorDefecto = null;
	}

	
	//Empiezan nuestros Test Unitarios
	
	@Test
	public void testLibro() {	 
		//Comprobar que las paginas en el constructor vacio sea 0 y el titulo sea "Sin definir"
		assertTrue("No son el numero de paginas esperedas", 0 == libroPorDefecto.getPaginas());
		assertTrue("Tiene que ser sin definir","Sin definir".equals(libroPorDefecto.getTitulo()));
		
		//Comprobar que el numero de paginas no sea negativo y que el titulo no sea diferente a hola
		assertTrue("El numero de pagina no puede ser negativo",  (libroConParametros.getPaginas()>=0));
		assertTrue("Se esperaba el titulo hola",!"hola".equals(libroConParametros.getTitulo()));
	}
	

}
