package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;

public class ArrayListTest {

	ArrayList<String> listaPaises = null;
	ArrayList<String> listaPaisesDesordenada = null;
	ArrayList<Integer> listaNumeros = null;
	ArrayList<Vehiculo> listaVehiculos = null;

	static final String ESPANA = "España";
	static final String FRANCIA = "Francia";
	static final String PORTUGAL = "Portugal";
	static final String EUSKADI = "Euskadi";
	static final String BARAKALDO = "Barakaldo";
	static final float DELTA = 0.0f;

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
		listaPaisesDesordenada.add(PORTUGAL); // Ocupa la posición 0
		listaPaisesDesordenada.add(EUSKADI); // Ocupa la posición 1
		listaPaisesDesordenada.add(ESPANA); // Ocupa la posición 2

		listaNumeros = new ArrayList<Integer>();
		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(1);

		listaVehiculos = new ArrayList<Vehiculo>();
		listaVehiculos.add(new Vehiculo(150f, 5));
		listaVehiculos.add(new Vehiculo(50f, 2));
		listaVehiculos.add(new Vehiculo(300f, 4));
	}

	@After
	public void tearDown() throws Exception {
		listaPaises = null;
		listaPaisesDesordenada = null;
		listaVehiculos = null;
	}

	@Test
	public void testPoscion() {

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());

	}

	@Test
	public void testInsertarEnPoscion() {

		// insertar Barakaldo en posicion 1
		listaPaises.add(1, BARAKALDO);

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(BARAKALDO, listaPaises.get(1));
		assertSame(FRANCIA, listaPaises.get(2));
		assertSame(PORTUGAL, listaPaises.get(3));
		assertSame(4, listaPaises.size());

	}

	@Test
	public void testEliminar() {

		// eliminar por key o valor
		listaPaises.remove(FRANCIA);
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(PORTUGAL, listaPaises.get(1));
		assertSame(2, listaPaises.size());

		// eliminar por index o posicion
		listaPaises.remove(1);
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(1, listaPaises.size());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexException() {
		listaPaises.get(3);
	}

	@Test
	public void testAgurEspana() {
		listaPaises.set(0, EUSKADI);
		assertSame(EUSKADI, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());
		assertFalse(listaPaises.contains(ESPANA));
	}

	@Test
	public void testEliminarIntegers() {
		// remover por indice
		int index = 1;
		listaNumeros.remove(index);
		assertSame(3, listaNumeros.size());
		assertSame(1, listaNumeros.get(0));
		assertSame(3, listaNumeros.get(1));
		assertSame(1, listaNumeros.get(2));

		// remover por objeto
		Integer object = new Integer(1);
		listaNumeros.remove(object);
		assertSame(2, listaNumeros.size());
		assertSame(3, listaNumeros.get(0));
		assertSame(1, listaNumeros.get(1));
	}

	@Test
	public void testCollectionSortPrimitivos() {
		// Ordenar strings alfabeticamente
		Collections.sort(listaPaisesDesordenada);
		assertSame(ESPANA, listaPaisesDesordenada.get(0));
		assertSame(EUSKADI, listaPaisesDesordenada.get(1));
		assertSame(PORTUGAL, listaPaisesDesordenada.get(2));

		// Ordenar numeros
		Collections.sort(listaNumeros);
		assertSame(1, listaNumeros.get(0));
		assertSame(1, listaNumeros.get(1));
		assertSame(2, listaNumeros.get(2));
		assertSame(3, listaNumeros.get(3));
	}

	@Test
	public void testCollectionSortClases() {
		// Ordenar por potencia
		Collections.sort(listaVehiculos);
		assertEquals(listaVehiculos.get(0).getPotencia(), 50f, DELTA);
		assertEquals(listaVehiculos.get(1).getPotencia(), 150f, DELTA);
		assertEquals(listaVehiculos.get(2).getPotencia(), 300f, DELTA);

		// Ordenar por número de plazas
		Collections.sort(listaVehiculos,
				listaVehiculos.get(0).new ComparatorNumeroPlazas());
		assertEquals(listaVehiculos.get(0).getNumPlazas(), 2);
		assertEquals(listaVehiculos.get(1).getNumPlazas(), 4);
		assertEquals(listaVehiculos.get(2).getNumPlazas(), 5);
	}
}
