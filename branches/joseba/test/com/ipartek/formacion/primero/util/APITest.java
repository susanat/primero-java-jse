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
	String c = "adios";
	String nulo = null;

	String cadenaOriginal = "HolaHolaHolaHola";
	String cadenaReemplazada = "Hol4Hol4Hol4Hol4";

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

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
	public void testObjectsEqual() {

		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, aLower));
		assertTrue(Objects.equals(a.toLowerCase(), aLower));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, nulo));

	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder(a);
		assertEquals(a, sb.toString());
		// assertTrue(Objects.equals(a, sb.toString())); //Esto es otra opcion
		// para hacer el test

		sb.append(b);
		assertEquals((a + b), sb.toString());

		sb = sb.replace(0, sb.length(), c);
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

		// Split
		String[] palabras = lineaPersona.split(separador);
		assertEquals(personaNombre, palabras[0]);
		assertEquals(personaApellido1, palabras[1]);
		assertEquals(personaApellido2, palabras[2]);
		assertEquals(personaEdad, palabras[3]);

	}

	@Test
	public void testReplace() {
		assertEquals(cadenaReemplazada, cadenaOriginal.replace("a", "4"));

	}

	/**
	 * Test que compara el uso de gregorianCalendar
	 */
	@Test
	public void testDate() {
		// obtener fecha actual con new Date

		hoyDate.setTime(new Date());

		// Obtenemos fecha actual con System.currentTimeMillis(es igual que new
		// Date)
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		// Comprobamos que es lo mismo
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));
		assertEquals(11, hoyDate.get(GregorianCalendar.MONTH) + 1);// hay que
		// sumarle
		// uno al
		// mes
		// porque el
		// conteo
		// que lleva
		// es
		// diferente
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));
		assertEquals(GregorianCalendar.NOVEMBER,
				hoyDate.get(GregorianCalendar.MONTH));
		assertEquals(GregorianCalendar.MONDAY,
				hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

	}

	@Test
	public void testFecha() {

		String hoyCastellano = hoyDate.get(GregorianCalendar.DAY_OF_MONTH)
				+ "/" + hoyDate.get(GregorianCalendar.MONTH + 1) + "/"
				+ hoyDate.get(GregorianCalendar.YEAR);
		String hoyEuskara = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);
		assertEquals("17/11/2014", Fecha.getString(hoyDate, Idioma.CASTELLANO));
		assertEquals("2014/11/17", Fecha.getString(hoyDate, Idioma.EUSKARA));
	}
}
