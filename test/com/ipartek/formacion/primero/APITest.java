package com.ipartek.formacion.primero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.sergio.utils.ClsUtilsFechas;
import com.ipartek.formacion.sergio.utils.ClsUtilsTextos;

public class APITest {
	
	String perNombre = "Pili";
	String perAp1 = "Mili";
	String perAp2 = "Gorriti";
	String perEdad = "34";
	String perSeparador = ";";
	
	
	String lineaPersona = perNombre + perSeparador + perAp1 + perSeparador + perAp2 + perSeparador + perEdad;

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
	public void testObjectsEqual() {
		String a = "Hola";
		String aLower = "hola";
		String b = "Hola";
		String c = "Adios";
		
		String nulo = null;
		
		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, nulo));
		assertFalse(Objects.equals(a, aLower));
		
		assertTrue(Objects.equals(a.toLowerCase(), aLower.toLowerCase()));
		
	}
	
	/*
	@Test
	public void stringTrocearCadenas(){			
		//System.out.println("Prueba separador con StringTokenizer:");
		
		StringTokenizer st = new StringTokenizer(lineaPersona,perSeparador);
		while(st.hasMoreElements()){
			System.out.println(st.nextToken());
		}
		
		//System.out.println("Prueba separador con Split:");
		String[] aSplit = lineaPersona.split(perSeparador);
		for(String inSplit : aSplit){
			System.out.println(inSplit);
		}
		
		
		
		//System.out.println("Prueba separador con string builder");
		
		int init = 0;
		int fin = 0;
		
		fin = perNombre.length();
		//System.out.println(lineaPersona.substring(init, fin));
		assertTrue(lineaPersona.substring(init, fin).equals(perNombre));
		
		init = fin + 1;
		fin += perAp1.length() + 1;		
		//System.out.println(lineaPersona.substring(init, fin));
		assertTrue(lineaPersona.substring(init, fin).equals(perAp1));
		
		init = fin + 1;
		fin += perAp2.length() + 1;
		//System.out.println(lineaPersona.substring(init, fin));
		assertTrue(lineaPersona.substring(init, fin).equals(perAp2));
		
		init = fin + 1;
		fin += perEdad.length() + 1;
		//System.out.println(lineaPersona.substring(init, fin));
		assertTrue(lineaPersona.substring(init, fin).equals(perEdad));
		
	}
	*/
	
	@Test
	public void testDate() throws Exception {
		//TODO cambiar a un sitio más correcto
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		
		Calendar hoy = new GregorianCalendar();
		hoy.setTime(new Date());
		
		System.out.println("Fecha en min actual: " + hoy.getTimeInMillis());
		System.out.println(formatoDeFecha.format(hoy.getTime()));
		
				
		long millis = 16200000l;
		
		/*
	     for(TimeZone tim : ClsUtilsFechas.getListTimeZones()){	    	 
	    	  System.out.print("(" + ClsUtilsFechas.formateoHourMinutesGMT(tim) + ")");
	    	  System.out.print(" - " + tim.getID() + " - ");
	    	  System.out.println(tim.getDisplayName());
	    	  	
	     }
	     */
	    
		
		for (Entry<String, String> tirada : ClsUtilsFechas.getMapTZIdTZString().entrySet() ){
			
			String clave = tirada.getKey();
			String valor = tirada.getValue();
			System.out.println(clave + "  ->  "+valor);
			
			
		}
		
		
	}

	
	

	
	
	
	
}
