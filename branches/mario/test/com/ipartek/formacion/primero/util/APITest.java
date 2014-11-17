package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
	String aLower = "hola"; // todo minusculas
	String b = "Hola";
	String c = "Adios";
	String nulo = null;

	String cadenaOriginal = "HolaHolaHolaHola";
	String cadenaReemplazada = "Hol2Hol2Hol2Hol2";

	String cadenaOriginal2 = "HolaHola";
	String cadenaReemplazada2 = "AdiosAdios";

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	// String lineaPersona = "Pili;Mili;Gorriti;34";
	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

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
	public void testObjectsEqual() {

		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, nulo));
		assertFalse(Objects.equals(a, aLower));
		assertTrue(Objects.equals(a.toLowerCase(), aLower.toLowerCase()));

	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder(a);
		assertEquals(a, sb.toString());

		sb.append(b);
		assertEquals(a + b, sb.toString());

		sb = sb.replace(0, sb.length(), c);

		assertEquals(c, sb.toString());
	}

	@Test
	public void testTrocearCadenas() {
		// Array para comparar
		ArrayList<String> arrayDatos = new ArrayList<String>();
		arrayDatos.add(personaNombre);
		arrayDatos.add(personaApellido1);
		arrayDatos.add(personaApellido2);
		arrayDatos.add(personaEdad);
		int i = 0;

		// StringTokenizer
		StringTokenizer stTok = new StringTokenizer(lineaPersona, separador);

		while (stTok.hasMoreTokens()) {
			assertEquals(arrayDatos.get(i), stTok.nextToken());
			i++;
		}

		// split
		String[] personaComoArray = lineaPersona.split(";");
		i = 0;
		for (String credenciales : personaComoArray) {
			assertEquals(personaComoArray[i], credenciales);
			i++;
		}

		// subString
		int inicio = 0;
		int fin = personaNombre.length();
		assertEquals(personaNombre, lineaPersona.substring(inicio, fin));
		inicio = fin + 1;
		fin += personaApellido1.length() + 1;
		assertEquals(personaApellido1, lineaPersona.substring(inicio, fin));
		inicio = fin + 1;
		fin += personaApellido2.length() + 1;
		assertEquals(personaApellido2, lineaPersona.substring(inicio, fin));
		inicio = fin + 1;
		fin += personaEdad.length() + 1;
		assertEquals(personaEdad, lineaPersona.substring(inicio, fin));

	}

	@Test
	public void testReplaceAllStrings() {

		assertEquals(cadenaReemplazada, cadenaOriginal.replace('a', '2'));
		assertEquals(cadenaReemplazada2,
				cadenaOriginal2.replace("Hola", "Adios"));
	}

	@Test
	public void testDate() throws Exception {

		// Obtener Fecha actual con System.currrentTimeMillis
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		// test de las dos fechas iguales
		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		// Dia del mes
		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));

		// Dia de la semana
		assertEquals(GregorianCalendar.MONDAY,
				hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

		assertEquals(2, hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

		// Mes actual
		// sumar 1 al mes
		assertEquals(11, hoyDate.get(GregorianCalendar.MONTH) + 1);

		assertEquals(GregorianCalendar.NOVEMBER,
				hoyDate.get(GregorianCalendar.MONTH));

		// Anyo actual
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));

	}

}
