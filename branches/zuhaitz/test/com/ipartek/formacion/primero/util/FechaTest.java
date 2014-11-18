package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FechaTest {

	static GregorianCalendar gc1;
	static String mascaraES;
	static String mascaraEU;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mascaraES = "dd/MM/yyyy";
		mascaraEU = "yyyy/MM/dd";
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
		String castellanoFecha = "";
		String euskeraFecha = "";
		String pruebaCastellano = "";
		String pruebaEuskera = "";

		SimpleDateFormat sdf;

		for (int i = 0; i < 12; i++) {
			gc1.set(2014, i, 17);

			// Comprueba si está bien en CASTELLANO
			// Con una fecha
			sdf = new SimpleDateFormat(mascaraES);
			pruebaCastellano = sdf.format(gc1.getTime());

			castellanoFecha = Fecha.getString(gc1, Idioma.CASTELLANO);
			assertEquals(pruebaCastellano, castellanoFecha);

			// Con milisegundos
			castellanoFecha = Fecha.getString(gc1.getTimeInMillis(),
					Idioma.CASTELLANO);
			assertEquals(pruebaCastellano, castellanoFecha);

			// Comprueba si está bien en EUSKERA
			// Con una fecha
			sdf = new SimpleDateFormat(mascaraEU);
			pruebaEuskera = sdf.format(gc1.getTime());

			euskeraFecha = Fecha.getString(gc1, Idioma.EUSKERA);
			assertEquals(pruebaEuskera, euskeraFecha);

			// Con milisegundos
			euskeraFecha = Fecha.getString(gc1.getTimeInMillis(),
					Idioma.EUSKERA);
			assertEquals(pruebaEuskera, euskeraFecha);
		}

	}
}
