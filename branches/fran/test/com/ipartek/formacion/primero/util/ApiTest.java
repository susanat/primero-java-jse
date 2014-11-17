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

public class ApiTest {
	public static final int bucle = 100;

	String a = "Hola";
	String b = "Hola";
	String c = "Adios";
	String nulo = null;
	String replaceChar = "a";
	String lineaPersona = "Pili;Mili;Gorriti;34";
	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	String cadenaReemplazada = "Hol2Hol2Hol2Hol2";
	String cadena = "HolaHolaHolaHola";
	GregorianCalendar hoyDate = null;

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
	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder(a);

		assertTrue(Objects.equals(a, sb.toString()));

		sb.append(b);
		assertTrue(Objects.equals(a + b, sb.toString()));

		sb.replace(0, sb.length(), c);
		assertTrue(Objects.equals(c, sb.toString()));
	}

	@Test
	public void testTrocearCadenas() {
		// Trocear usando StringTokenizer
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);
		assertEquals(4, st.countTokens());
		assertEquals(personaNombre, st.nextToken());
		assertEquals(personaApellido1, st.nextToken());
		assertEquals(personaApellido2, st.nextToken());
		assertEquals(personaEdad, st.nextToken());

		// Trocear usando split()
		String[] split = lineaPersona.split(separador);
		assertEquals(4, split.length);
		assertEquals(personaNombre, split[0]);
		assertEquals(personaApellido1, split[1]);
		assertEquals(personaApellido2, split[2]);
		assertEquals(personaEdad, split[3]);

		// Trocear usando substring
		assertEquals(personaNombre,
				lineaPersona.substring(0, personaNombre.length()));
		assertEquals(personaApellido1, lineaPersona.substring(
				personaNombre.length() + separador.length(),
				personaNombre.length() + separador.length()
						+ personaApellido1.length()));
		assertEquals(
				personaApellido2,
				lineaPersona.substring(
						personaNombre.length() + separador.length()
								+ personaApellido1.length()
								+ separador.length(),
						personaNombre.length() + separador.length()
								+ personaApellido1.length()
								+ separador.length()
								+ personaApellido2.length()));
		assertEquals(
				personaEdad,
				lineaPersona.substring(
						personaNombre.length() + separador.length()
								+ personaApellido1.length()
								+ separador.length()
								+ personaApellido2.length()
								+ separador.length(),
						personaNombre.length() + separador.length()
								+ personaApellido1.length()
								+ separador.length()
								+ personaApellido2.length()
								+ separador.length() + personaEdad.length()));
	}

	@Test
	public void testTiemposString() {
		String content = "";
		for (int i = 0; i < bucle; i++) {
			content = content + "linea " + i + "\r\n";
		}
		assertTrue(true);
	}

	@Test
	public void testTiemposStringBuilder() {
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < bucle; i++) {
			content.append("linea " + i + "\r\n");
		}
		assertTrue(true);
	}

	@Test
	public void testReplaceString() {
		assertEquals(cadenaReemplazada, cadena.replace('a', '2'));
	}

	@Test
	public void testDate() throws Exception {
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));
	}
}
