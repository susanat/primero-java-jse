package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.net.PortUnreachableException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

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
		
		listaPaises = new ArrayList();
		listaPaises.add(ESPANA); // Ocupa la posición 0
		listaPaises.add(FRANCIA); // Ocupa la posición 1
		listaPaises.add(PORTUGAL); // Ocupa la posición 2
		
		listaPaisesDesordenada = new ArrayList();
		listaPaisesDesordenada.add(PORTUGAL);
		listaPaisesDesordenada.add(EUSKADI);
		listaPaisesDesordenada.add(ESPANA);
		
		listaCaracteresEspeciales = new ArrayList();
			
		
		listaVehiculos = new ArrayList();
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
		System.out.println("Ordenados");
		for(String a:listaCaracteresEspeciales){
			System.out.println(a);
		}
		
		assertSame(";", listaCaracteresEspeciales.get(0));
		assertSame("1", listaCaracteresEspeciales.get(1));
		assertSame("á", listaCaracteresEspeciales.get(2));
		assertSame("b", listaCaracteresEspeciales.get(3));
		
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
		
		assertEquals(50f, listaVehiculos.get(0).getPotencia(), DELTA);
		assertEquals(150f, listaVehiculos.get(1).getPotencia(), DELTA);
		assertEquals(350f, listaVehiculos.get(2).getPotencia(), DELTA);
	}
}
