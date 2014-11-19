package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.sergio.utils.ClsUtilsColecciones;

public class dadoTest {

	private static final int TIRADAS = 1000000;

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
	public void test() {

		HashMap<String, Integer> mapTiradas = new HashMap<String, Integer>();

		Dado dado = new Dado();
		int anteriorvalor = 0;
		
		
		for(int i = 0; i < TIRADAS; i++){

			dado.tirar();

			if (mapTiradas.containsKey(dado.toString())){
				anteriorvalor = mapTiradas.get(dado.toString()) + 1;
				mapTiradas.put(dado.toString(), anteriorvalor);
			}
			else{
				mapTiradas.put(dado.toString(), 1);
			}
		}
		
		//Test
		assertEquals(Dado.alumnos.length, mapTiradas.size());
			
		
		
		
		int valor2 = 0;		
		System.out.println("Sin ordenar (por aparición)");
		for (Entry<String, Integer> tirada : mapTiradas.entrySet()){
			String clave = tirada.getKey();
			Integer valor = tirada.getValue();
						
			System.out.println(clave+"  ->  "+valor);
			
			valor2 += valor; 
		}
		
		System.out.println("Total tiradas: " + valor2);
		System.out.println("************************");
		System.out.println("");
		
		
			
		mapTiradas = (HashMap<String, Integer>) ClsUtilsColecciones.mapSortByKeys(mapTiradas);		
		System.out.println("Ordenado por key ascendente: ");
		for (Entry<String, Integer> tirada : mapTiradas.entrySet()){
			String clave = tirada.getKey();
			Integer valor = tirada.getValue();
			System.out.println(clave+"  ->  "+valor);
			
			valor2 += valor; 
		}
		
		System.out.println("************************");
		System.out.println("");
		
		mapTiradas = (HashMap<String, Integer>) ClsUtilsColecciones.mapSortByKeys(mapTiradas,true);
		System.out.println("Ordenado por key descendente: ");
		for (Entry<String, Integer> tirada : mapTiradas.entrySet()){
			String clave = tirada.getKey();
			Integer valor = tirada.getValue();
			System.out.println(clave+"  ->  "+valor);
			
			valor2 += valor; 
		}
		
		System.out.println("************************");
		System.out.println("");
		
		mapTiradas = (HashMap<String, Integer>) ClsUtilsColecciones.mapSortByValues(mapTiradas);
		System.out.println("Ordenado por value ascendente: ");
		for (Entry<String, Integer> tirada : mapTiradas.entrySet()){
			String clave = tirada.getKey();
			Integer valor = tirada.getValue();
			System.out.println(clave+"  ->  "+valor);
			
			valor2 += valor; 
		}
		
		System.out.println("************************");
		System.out.println("");
		
		mapTiradas = (HashMap<String, Integer>) ClsUtilsColecciones.mapSortByValues(mapTiradas);
		System.out.println("Ordenado por value descendente: ");
		for (Entry<String, Integer> tirada : mapTiradas.entrySet()){
			String clave = tirada.getKey();
			Integer valor = tirada.getValue();
			System.out.println(clave+"  ->  "+valor);
			
			valor2 += valor; 
		}
		
		
	}

}
