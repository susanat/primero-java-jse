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

	static GregorianCalendar gc1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc1 = null;
	}

	@Before
	public void setUp() throws Exception {
		gc1 = new GregorianCalendar();
		gc1.setTime(new Date());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetString() throws Exception {
		String castellanoFecha = gc1.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ gc1.get(GregorianCalendar.MONTH) + "/"
				+ gc1.get(GregorianCalendar.YEAR);
		String euskeraFecha = gc1.get(GregorianCalendar.YEAR) + "/"
				+ gc1.get(GregorianCalendar.MONTH) + "/"
				+ gc1.get(GregorianCalendar.DAY_OF_MONTH);

		String pruebaCastellano = "";
		String pruebaEuskera = "";

		for (int i = 0; i < 12; i++) {
			gc1.set(2014, i, 17);

			// Comprueba si está bien en CASTELLANO
			pruebaCastellano = gc1.get(GregorianCalendar.DAY_OF_MONTH) + "/"
					+ (gc1.get(GregorianCalendar.MONTH) + 1) + "/"
					+ gc1.get(GregorianCalendar.YEAR);

			castellanoFecha = Fecha.getString(gc1, Idioma.CASTELLANO);
			assertEquals(pruebaCastellano, castellanoFecha);
			System.out.println("Castellano => " + castellanoFecha);

			// Comprueba si está bien en EUSKERA
			pruebaEuskera = gc1.get(GregorianCalendar.YEAR) + "/"
					+ (gc1.get(GregorianCalendar.MONTH) + 1) + "/"
					+ gc1.get(GregorianCalendar.DAY_OF_MONTH);

			euskeraFecha = Fecha.getString(gc1, Idioma.EUSKERA);
			assertEquals(pruebaEuskera, euskeraFecha);
			System.out.println("Euskera => " + euskeraFecha);
		}

	}
}
