package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFecha {

	GregorianCalendar hoyDate;

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
	public void testFecha() {

		String hoyCastellano = hoyDate.get(GregorianCalendar.DAY_OF_MONTH)
				+ "/" + (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.YEAR);
		String hoyEuskara = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);

		String hoyMeses;
		assertEquals(hoyCastellano, Fecha.getString(hoyDate, Idioma.CASTELLANO));
		assertEquals(hoyEuskara, Fecha.getString(hoyDate, Idioma.EUSKARA));

		for (int i = 1; i < 13; i++) {
			GregorianCalendar mydate = new GregorianCalendar(2014, (i - 1), 15);
			hoyMeses = "15/" + i + "/" + "2014";
			assertEquals(hoyMeses, Fecha.getString(mydate, Idioma.CASTELLANO));

		}
	}
}
