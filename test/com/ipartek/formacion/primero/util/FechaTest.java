package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FechaTest {

	GregorianCalendar hoyDate = new GregorianCalendar();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hoyDate = new GregorianCalendar();
		hoyDate.setTime(new Date());
	}

	@After
	public void tearDown() throws Exception {
		hoyDate = null;
	}

	@Test
	public void test() {
		
		String hoyCastellano = hoyDate.get(GregorianCalendar.DAY_OF_MONTH)
				+ "/" + (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.YEAR);

		String hoyEuskera = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);

		// Comprueba la fecha pasandole la fecha entera con hoyDate
		assertEquals(hoyCastellano, Fecha.getString(hoyDate, Idioma.CASTELLANO));
		assertEquals(hoyEuskera, Fecha.getString(hoyDate, Idioma.EUSKERA));

		// Comprueba la fecha pasandole la fecha en milisegundos
		assertEquals(hoyCastellano,
				Fecha.getString(hoyDate.getTimeInMillis(), Idioma.CASTELLANO));
		assertEquals(hoyEuskera,
				Fecha.getString(hoyDate.getTimeInMillis(), Idioma.EUSKERA));
	}

}
