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
import com.ipartek.formacion.primero.bean.herencia.Vehiculo.ComparatorNumPlazas;

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
		listaVehiculos.add(new Vehiculo(350f, 4));
	}

	@After
	public void tearDown() throws Exception {
		listaPaises = null;
		listaPaisesDesordenada = null;
		listaNumeros = null;
		listaVehiculos = null;
	}

	@Test
	public void testPosicion() throws Exception {
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());
	}

	@Test
	public void testInsertarEnPosicion() throws Exception {
		// insertar Barakaldo en posicion 1
		listaPaises.add(1, BARAKALDO);

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(BARAKALDO, listaPaises.get(1));
		assertSame(FRANCIA, listaPaises.get(2));
		assertSame(PORTUGAL, listaPaises.get(3));
		assertSame(4, listaPaises.size());
	}

	@Test
	public void testEliminar() throws Exception {
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
	public void testAgurEspana() throws Exception {
		listaPaises.set(0, EUSKADI);
		assertSame(EUSKADI, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());
		assertFalse(listaPaises.contains(ESPANA));
	}

	@Test
	public void testEliminarIntegers() throws Exception {
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
	public void testCollectionSortPrimitivos() throws Exception {
		// Ordenar alfabéticamente Strings
		Collections.sort(listaPaisesDesordenada);
		// TODO comprobar con acentos, ñ, mayúsculas y minúsculas
		assertSame("La lista de paises no está ordenada.", ESPANA,
				listaPaisesDesordenada.get(0));
		assertSame("La lista de paises no está ordenada.", EUSKADI,
				listaPaisesDesordenada.get(1));
		assertSame("La lista de paises no está ordenada.", PORTUGAL,
				listaPaisesDesordenada.get(2));

		// Ordenar al revés
		Collections.reverse(listaPaisesDesordenada);
		assertSame("La lista de paises no está ordenada.", PORTUGAL,
				listaPaisesDesordenada.get(0));
		assertSame("La lista de paises no está ordenada.", EUSKADI,
				listaPaisesDesordenada.get(1));
		assertSame("La lista de paises no está ordenada.", ESPANA,
				listaPaisesDesordenada.get(2));

		// Ordenar de menor a mayor int
		Collections.sort(listaNumeros);
		assertSame("La lista de números no está ordenada.", 1,
				listaNumeros.get(0));
		assertSame("La lista de números no está ordenada.", 1,
				listaNumeros.get(1));
		assertSame("La lista de números no está ordenada.", 2,
				listaNumeros.get(2));
		assertSame("La lista de números no está ordenada.", 3,
				listaNumeros.get(3));
	}

	@Test
	public void testCollectionSortClases() throws Exception {
		Collections.sort(listaVehiculos);
		assertEquals("La lista de vehículos no está ordenada.", 50f,
				listaVehiculos.get(0).getPotencia(), 0f);
		assertEquals("La lista de vehículos no está ordenada.", 150f,
				listaVehiculos.get(1).getPotencia(), 0f);
		assertEquals("La lista de vehículos no está ordenada.", 350f,
				listaVehiculos.get(2).getPotencia(), 0f);

		Collections.sort(listaVehiculos, new ComparatorNumPlazas());
		assertEquals("La lista de vehículos no está ordenada.", 2,
				listaVehiculos.get(0).getNumPlazas());
		assertEquals("La lista de vehículos no está ordenada.", 4,
				listaVehiculos.get(1).getNumPlazas());
		assertEquals("La lista de vehículos no está ordenada.", 5,
				listaVehiculos.get(2).getNumPlazas());

	}
}
