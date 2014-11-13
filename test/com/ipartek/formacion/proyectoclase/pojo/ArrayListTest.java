package com.ipartek.formacion.proyectoclase.pojo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.proyectoclase.pojo.herencia.Vehiculo;
import com.ipartek.formacion.proyectoclase.pojo.herencia.Vehiculo.ComparatorNumeroPlazas;

public class ArrayListTest {
	private ArrayList<String> paises = null;
	private ArrayList<String> listaOrdenada = null;
	private ArrayList<Integer> listaNumeros = null;
	private ArrayList<Integer> listaNumOrdenada = null;
	private ArrayList<Vehiculo> listaVehiculos = null;
	private ArrayList<Vehiculo> lVehiOrdenada = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		paises = new ArrayList<String>();
		listaOrdenada = new ArrayList<String>();
		listaNumeros = new ArrayList<Integer>();
		listaNumOrdenada = new ArrayList<Integer>();
		listaVehiculos = new ArrayList<Vehiculo>();
		lVehiOrdenada = new ArrayList<Vehiculo>();
	}

	@After
	public void tearDown() throws Exception {
		paises = null;
		listaOrdenada = null;
		listaNumeros = null;
		listaNumOrdenada = null;
		listaVehiculos = null;
		lVehiOrdenada = null;
	}

	@Test
	public void test() {
		paises.add("España");
		paises.add("Portugal");
		paises.add("Suiza");
		paises.add("Francia");

		listaOrdenada.add("España");
		listaOrdenada.add("Francia");
		listaOrdenada.add("Portugal");
		listaOrdenada.add("Suiza");

		Collections.sort(paises);

		assertEquals("La lista no se ha ordenado correctamente", listaOrdenada,
				paises);
		// TODO comprobar acentos ñ mayusculas y minusculas

		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(1);

		Collections.sort(listaNumeros);

		listaNumOrdenada.add(1);
		listaNumOrdenada.add(1);
		listaNumOrdenada.add(2);
		listaNumOrdenada.add(3);
		assertEquals("La lista no se ha ordenado correctamente",
				listaNumOrdenada, listaNumeros);

		Collections.sort(listaNumeros, Collections.reverseOrder());
	}

	@Test
	public void testCollectionSortClases() {
		listaVehiculos.add(new Vehiculo(150.0));
		listaVehiculos.add(new Vehiculo(100.0));
		listaVehiculos.add(new Vehiculo(250.0));
		listaVehiculos.add(new Vehiculo(125.0));
		Collections.sort(listaVehiculos);

		lVehiOrdenada.add(new Vehiculo(100.0));
		lVehiOrdenada.add(new Vehiculo(125.0));
		lVehiOrdenada.add(new Vehiculo(150.0));
		lVehiOrdenada.add(new Vehiculo(250.0));

		assertEquals("La lista de vehiculos no ha sido ordenada correctamente",
				100.0, listaVehiculos.get(0).getPotencia(), 0f);
		assertEquals("La lista de vehiculos no ha sido ordenada correctamente",
				125.0, listaVehiculos.get(1).getPotencia(), 0f);
		assertEquals("La lista de vehiculos no ha sido ordenada correctamente",
				150.0, listaVehiculos.get(2).getPotencia(), 0f);
		assertEquals("La lista de vehiculos no ha sido ordenada correctamente",
				250.0, listaVehiculos.get(3).getPotencia(), 0f);

		listaVehiculos = new ArrayList<Vehiculo>();
		listaVehiculos.add(new Vehiculo(150.0, 3));
		listaVehiculos.add(new Vehiculo(100.0, 7));
		listaVehiculos.add(new Vehiculo(250.0, 5));
		listaVehiculos.add(new Vehiculo(125.0, 4));
		Collections.sort(listaVehiculos, new ComparatorNumeroPlazas());
	}
}
