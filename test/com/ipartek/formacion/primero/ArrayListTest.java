package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;

public class ArrayListTest {
	
	//desviación de los float para la comparación de float
	static final float DELTA = 0f;
	
	
	ArrayList<String> listaPaises = null;
	ArrayList<String> listaPaisesDesordenada = null;
	ArrayList<String> listaCaracteresEspeciales = null;
	ArrayList<Vehiculo> listaVehiculos = null;

	static final String ESPANA = "España";
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
		listaPaises.add(ESPANA); // Ocupa la posición 0
		listaPaises.add(FRANCIA); // Ocupa la posición 1
		listaPaises.add(PORTUGAL); // Ocupa la posición 2
		
		listaPaisesDesordenada = new ArrayList<String>();
		listaPaisesDesordenada.add(PORTUGAL);
		listaPaisesDesordenada.add(EUSKADI);
		listaPaisesDesordenada.add(ESPANA);
		
		listaCaracteresEspeciales = new ArrayList<String>();
			
		
		listaVehiculos = new ArrayList<Vehiculo>();
		listaVehiculos.add(new Vehiculo(150f));
		listaVehiculos.add(new Vehiculo(50f));
		listaVehiculos.add(new Vehiculo(350f));
		
	}

	@After
	public void tearDown() throws Exception {
		
		listaPaises = null;
		listaPaisesDesordenada=null;
		listaCaracteresEspeciales=null;
		listaVehiculos = null;
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
	
	@Test
	public void testCollectionSort(){
		Collections.sort(listaPaisesDesordenada);
		
		assertSame(ESPANA, listaPaisesDesordenada.get(0));
		assertSame(EUSKADI, listaPaisesDesordenada.get(1));
		assertSame(PORTUGAL, listaPaisesDesordenada.get(2));
		
		//TODO comprobar con acentos, ñ, mayúsculas y minúsculas
	}
	
	@Test
	public void testOrdenarCaracteresEspeciales(){
		
		listaCaracteresEspeciales.add("b");
		listaCaracteresEspeciales.add("ñ");
		listaCaracteresEspeciales.add("ú");
		listaCaracteresEspeciales.add("é");
		listaCaracteresEspeciales.add("ü");
		listaCaracteresEspeciales.add("á");
		listaCaracteresEspeciales.add("o");
		listaCaracteresEspeciales.add("ó");
		listaCaracteresEspeciales.add(";");
		listaCaracteresEspeciales.add("1");
		
		
		System.out.println("Desordenados");
		for(String a:listaCaracteresEspeciales){
			System.out.println(a);
		}
		
		
		
		//TODO Guardar y explicar
		//Lenguage: Java		
		//Etiquetas: Collections, Collator, sort, Locale 
		//Caracteres especiales en algún idioma, como por ejemplo, á, é, í, ü, ordena de una manera u otra dependiendo del 
				
		//Ordenar dependiendo del locale
		//You can use a sort with a custom Comparator. See the Collator interface
		Collator coll = Collator.getInstance(Locale.getDefault());
		coll.setStrength(Collator.PRIMARY); // thanks to @BheshGurung for reminding me
		Collections.sort(listaCaracteresEspeciales, coll);
		
		
		//Collections.sort(listaCaracteresEspeciales);
		System.out.println("Ordenados con locale");
		for(String a:listaCaracteresEspeciales){
			System.out.println(a);
		}
		
		assertSame(";", listaCaracteresEspeciales.get(0));
		assertSame("1", listaCaracteresEspeciales.get(1));
		assertSame("á", listaCaracteresEspeciales.get(2));
		assertSame("b", listaCaracteresEspeciales.get(3));
		
		
		// set another default locale	    
		Collections.sort(listaCaracteresEspeciales);
		//Collections.sort(listaCaracteresEspeciales);
		System.out.println("Ordenados sin locale");
		for(String a:listaCaracteresEspeciales){
			System.out.println(a);
		}
	}
	
	@Test
	public void testOrdenarVehiculos(){
		Collections.sort(listaVehiculos);
		
		assertEquals(50f, listaVehiculos.get(0).getPotencia(), DELTA);
		assertEquals(150f, listaVehiculos.get(1).getPotencia(), DELTA);
		assertEquals(350f, listaVehiculos.get(2).getPotencia(), DELTA);
	}
	
	@Test
	public void testOrdenarVehiculosMultiple(){
		listaVehiculos = new ArrayList<Vehiculo>();
		
		listaVehiculos.add(new Vehiculo(150f,3));
		listaVehiculos.add(new Vehiculo(50f,4));
		listaVehiculos.add(new Vehiculo(350f,1));
		
		Collections.sort(listaVehiculos, new Vehiculo.comparatorNumeroPlazas());
		
		//assertEquals(50f, listaVehiculos.get(0).getPotencia(), DELTA);
		//assertEquals(150f, listaVehiculos.get(1).getPotencia(), DELTA);
		//assertEquals(350f, listaVehiculos.get(2).getPotencia(), DELTA);
	}
	
	@Test
	public void testQueue(){
	    
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(ESPANA);
	    queue.add(EUSKADI);
	    queue.add(BARAKALDO);
	    queue.add(FRANCIA);	    
	    queue.add(PORTUGAL);
	    
	    for(String str : queue){
		System.out.println(str);
	    }
	    	    
	    assertEquals(5, queue.size());
	    
	    //obtener elemento con poll (obtiene y elimina)
	    String elementoPoll = queue.poll();
	    assertEquals(elementoPoll, ESPANA);
	    
	    assertEquals(4, queue.size());
	    
	    //obtener elemento con remove (obtiene y elimina)
	    String elementoRemove = queue.remove();
	    assertEquals(elementoRemove, EUSKADI);
	    
	    assertEquals(3, queue.size());
	    
	    //obtener elemento con peek (solo obtiene)
	    String elementoPeek = queue.peek();
	    assertEquals(elementoPeek, BARAKALDO);
	    
	    assertEquals(3, queue.size());
	    
	    //Eliminamos con remove más elementos de los que tiene. Esperamos excepción
	    try {
		for (int i = 0; i < queue.size() + 10; i++  ) {
		    queue.remove();
		}
		
		fail("Hasta aqui no puede llegar");
	    }catch(Exception ex){
		assertTrue("No hemos obtenido la excepcion deseada", ex instanceof NoSuchElementException);
	    }
	    
	    
	    //Eliminamos con pull sobre cola vacía. Esperamos null.
	    for (int i = 0; i < queue.size(); i++  ) {
		    String prueba = queue.poll();
		    assertTrue("Error inesperado con prueba " + prueba, prueba == "");
	    }
	    
	}
	
}
