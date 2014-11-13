package com.ipartek.formacion.primero.bean;
import static org.junit.Assert.*;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.sergio.utils.ClsUtilsConstantes;


public class PersonaTest {
	
	ArrayList<Persona> lstPersona = null;	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		lstPersona = new ArrayList<Persona>();
		
	}

	@After
	public void tearDown() throws Exception {
		ArrayList<Persona> lstPersona = null;
	}

	@Test
	public void test() {
		
		lstPersona.add(new Persona("Zuhaitz",29));
		lstPersona.add(new Persona("Susana",23));
		lstPersona.add(new Persona("kepa",34));
		lstPersona.add(new Persona("Úrko",37));
		lstPersona.add(new Persona("urko",20));
		lstPersona.add(new Persona("Jon",35));
		lstPersona.add(new Persona("Sergio",18));
		lstPersona.add(new Persona("Ñu",32));
		lstPersona.add(new Persona("Urko",10));
		lstPersona.add(new Persona("zuhaitz",20));
		lstPersona.add(new Persona("maitane",30));
		lstPersona.add(new Persona("Zuhaitz",19));
		lstPersona.add(new Persona("Joseba",26));
		lstPersona.add(new Persona("Mario",29));
		lstPersona.add(new Persona("Aritz",20));
		lstPersona.add(new Persona("fran",33));
		lstPersona.add(new Persona("Maitane",28));
		lstPersona.add(new Persona("Jose",99));
		
		
		
		/*
		// Prueba edad y nombre
		Collections.sort(lstPersona, Persona.ObjetoComparator.getComparator
							(		
									Persona.ObjetoComparator.SORT_EDAD,
									Persona.ObjetoComparator.SORT_NOMBRE									 
									
							)
						);
		*/
		
		//Prueba solo por nombre sin locale
		Collections.sort(lstPersona, Persona.ObjetoComparator.getComparator
				(								
						Persona.ObjetoComparator.SORT_NOMBRE						
				)
				
			);
		
		
		/*
		Collator coll = Collator.getInstance(Locale.getDefault());
		coll.setStrength(Collator.PRIMARY); // thanks to @BheshGurung for reminding me
		//Prueba solo por nombre con locale e ignore case
		Collections.sort(lstPersona, Persona.ObjetoComparator.ascending(Persona.ObjetoComparator.SORT_NOMBRE_IC));
		*/
		
		Collections.sort(lstPersona, Persona.ObjetoComparator.getComparator
				(		
						Persona.ObjetoComparator.SORT_NOMBRE_COLLATOR,
						Persona.ObjetoComparator.SORT_EDAD														 
						
				)
			);		
		
		assertSame("Aritz", lstPersona.get(0).getNombre());
		assertSame(20, lstPersona.get(0).getEdad());
		
		assertSame("Zuhaitz", lstPersona.get(lstPersona.size() - 1).getNombre());
		assertSame(29, lstPersona.get(lstPersona.size()-1).getEdad());
		
		
		for(Persona per : lstPersona){
			System.out.println("Nombre: " + per.getNombre() + " - "+ "Edad: " + per.getEdad());
		}
		
		
		System.out.println(ClsUtilsConstantes.SALTO_DE_LINEA);
		System.out.println("Locate dentro de Collactor: " + ClsUtilsConstantes.SALTO_DE_LINEA);
		for(Locale s : Collator.getAvailableLocales()){
			System.out.println(
					"Country		: " + s.getDisplayCountry() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.getCountry() + ClsUtilsConstantes.SALTO_DE_LINEA 
					+ "	ISO	: " + s.getISO3Country() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "Lengua		: " + s.getDisplayLanguage() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.getLanguage() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "		: " + s.toString() + ClsUtilsConstantes.SALTO_DE_LINEA
					+ "	ISO	: " + s.getISO3Language() + ClsUtilsConstantes.SALTO_DE_LINEA				
					);
		}
		
	}

}
