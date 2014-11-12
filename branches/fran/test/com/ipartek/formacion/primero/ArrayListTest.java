package com.ipartek.formacion.primero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTest {
	
	ArrayList<String> listaPaises = null;

	static final String ESPANA = "Espa�a";
	static final String FRANCIA = "Francia";
	static final String PORTUGAL = "Portugal";
	static final String EUSKADI = "Euskadi";
	static final String BARAKALDO = "Barakaldo";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		listaPaises = new ArrayList<String>();
		listaPaises.add(ESPANA); // Ocupa la posici�n 0
		listaPaises.add(FRANCIA); // Ocupa la posici�n 1
		listaPaises.add(PORTUGAL); // Ocupa la posici�n 2
		
	}

	@After
	public void tearDown() throws Exception {
		
		listaPaises = null;
	}

	@Test
	public void testPoscion() {

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame( 3, listaPaises.size() );

	}
	
	@Test
	public void testInsertarEnPoscion() {
		
		//insertar Barakaldo en posicion 1
		listaPaises.add(1, BARAKALDO);
		
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(BARAKALDO, listaPaises.get(1));
		assertSame(FRANCIA, listaPaises.get(2));
		assertSame(PORTUGAL, listaPaises.get(3));
		assertSame( 4 , listaPaises.size() );

	}
	
	
	@Test
	public void testEliminar() {
		
		//eliminar por key o valor
		listaPaises.remove(FRANCIA);
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(PORTUGAL, listaPaises.get(1));
		assertSame( 2, listaPaises.size() );
	
		//eliminar por index o posicion
		listaPaises.remove(1);
		assertSame(ESPANA, listaPaises.get(0));
		assertSame( 1, listaPaises.size() );
	
	}
	

	@Test(expected=	IndexOutOfBoundsException.class	)
	public void testIndexException() {
	
		listaPaises.get(3);	
	}
	
	@Test
	public void testAgurEspana() {
		listaPaises.set(0, EUSKADI);
		assertSame(EUSKADI, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame( 3, listaPaises.size() );
		assertFalse( listaPaises.contains(ESPANA));
	}
	
	
	@Test
	public void testEliminarIntegers() {
		
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(1);
		
		//remover por indice
		int index = 1;
		listaNumeros.remove(index);
		assertSame( 3, listaNumeros.size() );
		assertSame(1, listaNumeros.get(0));
		assertSame(3, listaNumeros.get(1));
		assertSame(1, listaNumeros.get(2));
		
		//remover por objeto
		Integer object = new Integer(1); 
		listaNumeros.remove( object );
		assertSame( 2, listaNumeros.size() );
		assertSame( 3, listaNumeros.get(0));
		assertSame( 1, listaNumeros.get(1));
		
	}
	
	
}