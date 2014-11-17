package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.sergio.utils.ClsUtilsConstantes;
import com.ipartek.formacion.sergio.utils.ClsUtilsFechas;

public class FicheroText {

	static final String FICHERO_NAME_TEST1 = "filename.txt";
	static final String FICHERO_CONTENT_TEST1 = "Hello Wolrd";
	
	static final String FICHERO_NAME_MILLON = "ElMillonDeLineas";
	static final long LINEAS_FICHERO = 10000l;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		StringBuilder strb = new StringBuilder();
		
		
		//crear fichero con x lineas
		for(int i = 0; i < LINEAS_FICHERO; i++){
			strb.append("Linea ").append(i).append(ClsUtilsConstantes.SALTO_DE_LINEA);
		}
		
		Fichero.create(FICHERO_NAME_MILLON, strb.toString());
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		assertTrue(FICHERO_NAME_TEST1 + " No se pudo eliminar",
				Fichero.remove(FICHERO_NAME_TEST1));
		
		assertTrue(FICHERO_NAME_MILLON + " No se pudo eliminar",
				Fichero.remove(FICHERO_NAME_MILLON));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		assertTrue(Fichero.create(FICHERO_NAME_TEST1, FICHERO_CONTENT_TEST1));

	}
	
	@Test
	public void testRead(){
		
		String filePath = "C:\\Users\\curso\\Documents\\MainActivity.java";
		
		try{
			String res = Fichero.readStringBuilder(filePath);
			
			assertTrue(res != null);
			assertTrue(res.length() > 0);
		}catch(Exception e){
			
		}
		
	}
	
	@Test(timeout = 500)
	public void testReadWithString(){
		
		Date fInicial = new Date(); 		
		
		try{
			String res = Fichero.readString(FICHERO_NAME_MILLON);
			
			assertTrue(res != null);
			assertTrue(res.length() > 0);
		}catch(Exception e){
			
		}
		
		
		System.out.println("Tiempo con String con " + LINEAS_FICHERO + " líneas: " + ClsUtilsFechas.diferenciaHoras(fInicial, new Date()).getDiffMilisegundos() + ClsUtilsConstantes.SALTO_DE_LINEA + " milisegundos");
		System.out.println (ClsUtilsFechas.milisegundosToTimeString(ClsUtilsFechas.diferenciaHoras(fInicial, new Date()).getDiffMilisegundos()));
		
	}
	
	
	@Test(timeout = 500)
	public void testReadWithStringBuilder(){
		
		Date fInicial = new Date(); 
		
		try{
			String res = Fichero.readStringBuilder(FICHERO_NAME_MILLON);
			
			assertTrue(res != null);
			assertTrue(res.length() > 0);
		}catch(Exception e){
			
		}
		
		System.out.println("Tiempo con StringBuilder con " + LINEAS_FICHERO + " líneas: " + ClsUtilsFechas.diferenciaHoras(fInicial, new Date()).getDiffMilisegundos() + ClsUtilsConstantes.SALTO_DE_LINEA + " milisegundos") ;
		System.out.println (ClsUtilsFechas.milisegundosToTimeString(ClsUtilsFechas.diferenciaHoras(fInicial, new Date()).getDiffMilisegundos()));
	}
	

}
