package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Persona.ComparatorNombres;

public class PersonaTest {
	ArrayList<Persona> listaPersona = null;

	Persona pZuhaitz = new Persona("Zuhaitz", 29);
	Persona pSusana = new Persona("Susána", 23);
	Persona pKepa = new Persona("kepa", 34);
	Persona pUrko = new Persona("Úrko", 37);
	Persona pJon = new Persona("Jon", 35);
	Persona pSergio = new Persona("Sergio", 18);
	Persona pSrNu = new Persona("Sr Ñu", 32);
	Persona pJoseba = new Persona("Joséba", 26);
	Persona pMario = new Persona("Mário", 29);
	Persona pAritz = new Persona("Áritz", 20);
	Persona pFran = new Persona("fran", 33);
	Persona pMaitane = new Persona("Maitane", 28);
	Persona pJose = new Persona("Jose", 99);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		listaPersona = new ArrayList<Persona>();

		listaPersona.add(pZuhaitz);
		listaPersona.add(pSusana);
		listaPersona.add(pKepa);
		listaPersona.add(pUrko);
		listaPersona.add(pJon);
		listaPersona.add(pSergio);
		listaPersona.add(pSrNu);
		listaPersona.add(pJoseba);
		listaPersona.add(pMario);
		listaPersona.add(pAritz);
		listaPersona.add(pFran);
		listaPersona.add(pMaitane);
		listaPersona.add(pJose);
	}

	@After
	public void tearDown() throws Exception {
		listaPersona = null;
	}

	@Test
	public void testCollectionSortPersonas() {
		// ordenamos por edad
		Collections.sort(listaPersona);

		assertSame(pSergio, listaPersona.get(0));
		assertSame(pAritz, listaPersona.get(1));
		assertSame(pSusana, listaPersona.get(2));
		assertSame(pJoseba, listaPersona.get(3));
		assertSame(pMaitane, listaPersona.get(4));
		assertSame(pZuhaitz, listaPersona.get(5));
		assertSame(pMario, listaPersona.get(6));
		assertSame(pSrNu, listaPersona.get(7));
		assertSame(pFran, listaPersona.get(8));
		assertSame(pKepa, listaPersona.get(9));
		assertSame(pJon, listaPersona.get(10));
		assertSame(pUrko, listaPersona.get(11));
		assertSame(pJose, listaPersona.get(12));

		// ordenamos por nombre
		Collections.sort(listaPersona, new ComparatorNombres());

		assertSame(pAritz, listaPersona.get(0));
		assertSame(pFran, listaPersona.get(1));
		assertSame(pJon, listaPersona.get(2));
		assertSame(pJose, listaPersona.get(3));
		assertSame(pJoseba, listaPersona.get(4));
		assertSame(pKepa, listaPersona.get(5));
		assertSame(pMaitane, listaPersona.get(6));
		assertSame(pMario, listaPersona.get(7));
		assertSame(pSergio, listaPersona.get(8));
		assertSame(pSrNu, listaPersona.get(9));
		assertSame(pSusana, listaPersona.get(10));
		assertSame(pUrko, listaPersona.get(11));
		assertSame(pZuhaitz, listaPersona.get(12));

	}
}
