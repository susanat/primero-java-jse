package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
	
	ArrayList<Persona> listaPersona;
	Persona pZuahitz;
	Persona pSusána;
	Persona pkepa;
	Persona pÚrko;
	Persona pJon;
	Persona pSergío;
	Persona pJoséba;
	Persona pMarío;
	Persona pÁritz;
	Persona pfran;
	Persona pMaitane;
	Persona pJose;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		listaPersona = new ArrayList<Persona>();
		pZuahitz = new Persona("Zuhaitz",29);
		pSusána = new Persona("Susána",23);
		pkepa = new Persona("kepa",34);
		pÚrko = new Persona("Úrko",37);
		pJon = new Persona("Jon",35);
		pSergío = new Persona("Sergío",18);
		pJoséba = new Persona("Joséba",26);
		pMarío = new Persona("Marío",29);
		pÁritz = new Persona("Áritz",20);
		pfran = new Persona("fran",33);
		pMaitane = new Persona("Maitane",29);
		pJose = new Persona("Jose",44);
		
		listaPersona.add (pZuahitz);
		listaPersona.add (pSusána);
		listaPersona.add (pkepa);
		listaPersona.add (pÚrko);
		listaPersona.add (pJon);
		listaPersona.add (pSergío);
		listaPersona.add (pJoséba);
		listaPersona.add (pMarío);
		listaPersona.add (pÁritz);
		listaPersona.add (pfran);
		listaPersona.add (pMaitane);
		listaPersona.add (pJose);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertEquals(pZuahitz, listaPersona.get(0));
		assertEquals(pSusána, listaPersona.get(1));
		assertEquals(pkepa, listaPersona.get(2));
		assertEquals(pÚrko, listaPersona.get(3));
		assertEquals(pJon, listaPersona.get(4));
		assertEquals(pSergío, listaPersona.get(5));
		assertEquals(pJoséba, listaPersona.get(6));
		assertEquals(pMarío, listaPersona.get(7));
		assertEquals(pÁritz, listaPersona.get(8));
		assertEquals(pfran, listaPersona.get(9));
		assertEquals(pMaitane, listaPersona.get(10));
		assertEquals(pJose, listaPersona.get(11));
		
		
		/**
		 * Ordeno por edad y con assertEquals compruebo que me lo ha ordenado
		 * Primeramente indicar en la clase <code>implements Comparable<Persona></code> 
		 * y añadir
		 * <code>public int compareTo(Persona p) {</code>
		 *	<code>return Integer.compare(this.getEdad(), p.getEdad());</code>
		 * <code>}</code>
		 */
		Collections.sort(listaPersona);
		assertEquals(18, listaPersona.get(0).getEdad());
		assertEquals(20, listaPersona.get(1).getEdad());
		assertEquals(23, listaPersona.get(2).getEdad());
		assertEquals(26, listaPersona.get(3).getEdad());
		assertEquals(29, listaPersona.get(5).getEdad());
		assertEquals(29, listaPersona.get(6).getEdad());
		assertEquals(33, listaPersona.get(7).getEdad());
		assertEquals(34, listaPersona.get(8).getEdad());
		assertEquals(35, listaPersona.get(9).getEdad());
		assertEquals(37, listaPersona.get(10).getEdad());
		assertEquals(44, listaPersona.get(11).getEdad());
		
		
		//Ordeno por nombre
		
				
		
		
	
		
		
		
		
	}

}
