package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class APITest {
	String a = "Hola";
	String aLower = "hola";
	String b = "Hola";
	String c = "Adios";
	String d = null;
	String replaceChar = "a";

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";

	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

	String cadenaOriginal = "HolaHolaHolaHola";
	String cadenaReemplazada = "Hol2Hol2Hol2Hol2";

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
	}

	@Test
	public void testObjectsEqual() {
		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, d));
		assertFalse(Objects.equals(a, aLower));

	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder(a);

		assertEquals(a, sb.toString());

		sb.append(b);
		assertEquals(a + b, sb.toString());

		sb.replace(0, sb.length(), c);
		assertEquals(c, sb.toString());
	}

	@Test
	public void testTrocearCadenas() {
		// StringTokenizer
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);

		assertEquals(personaNombre, st.nextToken());
		assertEquals(personaApellido1, st.nextToken());
		assertEquals(personaApellido2, st.nextToken());
		assertEquals(personaEdad, st.nextToken());

		// split
		String[] sa = lineaPersona.split(";");

		assertEquals(personaNombre, sa[0]);
		assertEquals(personaApellido1, sa[1]);
		assertEquals(personaApellido2, sa[2]);
		assertEquals(personaEdad, sa[3]);

		// subString
		int inicio = 0;
		int fin = personaNombre.length();

		assertEquals(personaNombre, lineaPersona.substring(inicio, fin));
		inicio = fin + 1;
		fin += personaApellido1.length() + 1;
		assertEquals(personaApellido1, lineaPersona.substring(inicio, fin));
	}

	@Test
	public void testReplaceString() {

		assertEquals(cadenaReemplazada, cadenaOriginal.replace('a', '2'));
	}

	@Test
	public void testDate() {
		GregorianCalendar hoyDate = new GregorianCalendar();
		hoyDate.setTime(new Date());
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());
		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());
		hoyDate.get(GregorianCalendar.DAY_OF_MONTH);
		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));
		assertEquals(11, hoyDate.get(GregorianCalendar.MONTH) + 1); // acordaros
																	// de sumar
																	// 1 al mes
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));
	}

	@Test
	public void testFecha() {
		String hoyStringCastellano = Utilidades.pad2Zeros(Integer
				.toString(hoyDate.get(GregorianCalendar.DAY_OF_MONTH)))
				+ "/"
				+ Utilidades.pad2Zeros(Integer.toString(hoyDate
						.get(GregorianCalendar.MONTH) + 1))
				+ "/"
				+ hoyDate.get(GregorianCalendar.YEAR);
		String hoyStringEuskera = hoyDate.get(GregorianCalendar.YEAR)
				+ "/"
				+ Utilidades.pad2Zeros(Integer.toString((hoyDate
						.get(GregorianCalendar.MONTH) + 1)))
				+ "/"
				+ Utilidades.pad2Zeros(Integer.toString(hoyDate
						.get(GregorianCalendar.DAY_OF_MONTH)));

		assertEquals(hoyStringCastellano,
				Fecha.getString(hoyDate, Idioma.CASTELLANO));
		assertEquals(hoyStringEuskera, Fecha.getString(hoyDate, Idioma.EUSKERA));
	}
}
