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
	GregorianCalendar hoyDate;
	String hoyStringCastellano = null;
	String hoyStringEuskera = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hoyDate = new GregorianCalendar();

		// crear cadenas para cada idioma

		hoyStringCastellano = hoyDate.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.YEAR);

		hoyStringEuskera = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);
	}

	@After
	public void tearDown() throws Exception {
		hoyDate = null;
	}

	@Test
	public void testDate() throws Exception {

		// obtener fecha actual con new Date

		hoyDate.setTime(new Date());

		// obtener fecha actual con System.currentTimeMillis()
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		// test las dos fechas iguales
		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		// Dia del mes
		assertEquals(18, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));
		assertEquals(GregorianCalendar.TUESDAY,
				hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

		// Dia de la semana
		// en java los meses empiezan por 0, por eso se le ha sumado 1
		assertEquals(11, hoyDate.get(GregorianCalendar.MONTH) + 1);

		// Mes actual
		// en java los meses empiezan por 0, por eso se le ha sumado 1
		assertEquals(GregorianCalendar.NOVEMBER,
				hoyDate.get(GregorianCalendar.MONTH));

		// Anho actual
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));

	}

	@Test
	public void testFecha() throws Exception {

		// testear cadenas contra Fecha.String()
		assertEquals(hoyStringCastellano,
				Fecha.getString(hoyDate, Idioma.CASTELLANO));
		assertEquals(hoyStringEuskera, Fecha.getString(hoyDate, Idioma.EUSKERA));

	}

	@Test
	public void testFechaLong() throws Exception {
		Date now = new Date();

		long nowLong = now.getTime();
		assertEquals(hoyStringCastellano,
				Fecha.getString(nowLong, Idioma.CASTELLANO));
		assertEquals(hoyStringEuskera, Fecha.getString(nowLong, Idioma.EUSKERA));

	}

	@Test
	public void testTodosLosMeses() throws Exception {
		assertEquals(0, GregorianCalendar.JANUARY);
		assertEquals(1, GregorianCalendar.FEBRUARY);
		assertEquals(2, GregorianCalendar.MARCH);
		assertEquals(3, GregorianCalendar.APRIL);
		assertEquals(4, GregorianCalendar.MAY);
		assertEquals(5, GregorianCalendar.JUNE);
		assertEquals(6, GregorianCalendar.JULY);
		assertEquals(7, GregorianCalendar.AUGUST);
		assertEquals(8, GregorianCalendar.SEPTEMBER);
		assertEquals(9, GregorianCalendar.OCTOBER);
		assertEquals(10, GregorianCalendar.NOVEMBER);
		assertEquals(11, GregorianCalendar.DECEMBER);

	}

}
