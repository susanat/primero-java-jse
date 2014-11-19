package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.util.Fecha.eIdioma;

public class FechaTest {

	GregorianCalendar hoyDate = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// obtener Fecha actual con new Date
		hoyDate = new GregorianCalendar();
		hoyDate.setTime(new Date());
	}

	@After
	public void tearDown() throws Exception {
		hoyDate = null;
	}

	@Test
	public void testDate() throws Exception {

		// obtener Fecha actual con System.currentTimeMillis()
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		/*
		 * // test las dos fechas iguales assertEquals(hoyDate, hoyCurrent);
		 * assertEquals(hoyDate.getTimeInMillis(),
		 * hoyCurrent.getTimeInMillis());
		 * 
		 * // Dia del mes assertEquals(17,
		 * hoyDate.get(GregorianCalendar.DAY_OF_MONTH));
		 * 
		 * // Dia de la semana assertEquals(GregorianCalendar.MONDAY,
		 * hoyDate.get(GregorianCalendar.DAY_OF_WEEK)); assertEquals(2,
		 * hoyDate.get(GregorianCalendar.DAY_OF_WEEK));
		 * 
		 * // Mes actual // acordaros de sumar 1 al mes assertEquals(11,
		 * (hoyDate.get(GregorianCalendar.MONTH) + 1));
		 * assertEquals(GregorianCalendar.NOVEMBER,
		 * (hoyDate.get(GregorianCalendar.MONTH) + 1));
		 * 
		 * // Anyo actual assertEquals(2014,
		 * hoyDate.get(GregorianCalendar.YEAR));
		 */

	}

	@Test
	public void testFecha() throws Exception {

		// crear las cadenas para cada idioma
		String hoyStringCastellano = hoyDate
				.get(GregorianCalendar.DAY_OF_MONTH)
				+ "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1)
				+ "/"
				+ hoyDate.get(GregorianCalendar.YEAR);
		String hoyStringEuskera = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);

		// testear cadenas contra Fecha.getString()
		assertEquals(hoyStringCastellano,
				Fecha.getString(hoyDate, eIdioma.CASTELLANO));

		assertEquals(hoyStringEuskera, Fecha.getString(hoyDate, eIdioma.EUSKARA));

		// testear cadenas contra Fecha.getString() para long
		assertEquals(hoyStringCastellano,
				Fecha.getString(hoyDate.getTimeInMillis(), eIdioma.CASTELLANO));

		assertEquals(hoyStringEuskera,
				Fecha.getString(hoyDate.getTimeInMillis(), eIdioma.EUSKARA));

	}

}
