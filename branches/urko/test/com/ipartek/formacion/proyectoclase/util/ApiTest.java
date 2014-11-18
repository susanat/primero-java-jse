package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApiTest {
	String a = "Hola";
	String b = "Hola";
	String c = "Agur";
	String aLower = "hola";
	String replaceChar = "a";
	String nulo = null;
	String cadenaOriginal = "holaholahola";
	String cadenaReemplazada = "hol2hol2hol2";
	String personaNombre = "Pili";
	String personaApe1 = "Mili";
	String personaApe2 = "Gorriti";
	String personaEdad = "34";
	static final String SEPARADOR = ",";
	static final String SALTOLINEA = ";";
	String lineaPersona = personaNombre + SEPARADOR + personaApe1 + SEPARADOR
			+ personaApe2 + SEPARADOR + personaEdad + SALTOLINEA;
	GregorianCalendar gc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		gc = new GregorianCalendar();
		gc.setTime(new Date());
	}

	@After
	public void tearDown() throws Exception {
		gc = null;
	}

	@Test
	public void testObjectEqual() {
		Locale locale = new Locale("es", "ES");
		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertTrue(Objects.equals(a.toLowerCase(locale),
				aLower.toLowerCase(locale)));

	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder(a);
		assertTrue("", Objects.equals(a, sb.toString()));
		assertEquals("", a, sb.toString());

		sb.append(b);
		assertEquals("", a + b, sb.toString());
		sb = sb.replace(0, sb.length(), c);
		assertEquals(c, sb.toString());
	}

	@Test
	public void testTrocearCadenas() {
		lineaPersona += lineaPersona;
		StringTokenizer st = new StringTokenizer(lineaPersona, SEPARADOR
				+ SALTOLINEA);
		while (st.hasMoreTokens()) {

			String pnombre = st.nextToken();
			String pape1 = st.nextToken();
			String pape2 = st.nextToken();
			String pedad = st.nextToken();
			assertTrue("", personaNombre.equals(pnombre));
			assertTrue("", personaApe1.equals(pape1));
			assertTrue("", personaApe2.equals(pape2));
			assertTrue("", personaEdad.equals(pedad));

		}

		String[] personas = lineaPersona.split(SALTOLINEA);
		String[] d_personas = null;
		for (String p : personas) {
			d_personas = p.split(SEPARADOR);
		}

		assertTrue("", personaNombre.equals(d_personas[0]));

		int indice_fin = lineaPersona.indexOf(SALTOLINEA.charAt(0));
		int indice_inicio = 0;
		// int n_lineas = 0;
		ArrayList<String> people = new ArrayList<String>();

		while (indice_fin > 0) {
			String persona = lineaPersona.substring(indice_inicio, indice_fin);
			// n_lineas++;

			indice_inicio = lineaPersona.indexOf(SALTOLINEA.charAt(0),
					indice_inicio + 1);
			indice_fin = lineaPersona.indexOf(SALTOLINEA.charAt(0),
					indice_fin + 1);
			people.add(persona);

		}
	}

	@Test
	public void testReplaceAllString() {
		String cadenaCambiada = cadenaOriginal.replace('a', '2');
		assertEquals(cadenaReemplazada, cadenaCambiada);

	}

	@Test
	public void testName() {
		Locale loc = new Locale("es", "ES");
		Calendar cal = Calendar.getInstance(loc);

		GregorianCalendar ahora = new GregorianCalendar();
		ahora.setTimeInMillis(System.currentTimeMillis());

		assertEquals(gc, ahora);
		assertEquals(gc.getTimeInMillis(), ahora.getTimeInMillis());

		assertEquals(cal.get(Calendar.DAY_OF_MONTH),
				gc.get(GregorianCalendar.DAY_OF_MONTH));

		assertEquals(cal.get(Calendar.MONTH), gc.get(GregorianCalendar.MONTH));// Jaunary=0

		assertEquals(cal.get(Calendar.YEAR), gc.get(GregorianCalendar.YEAR));
		assertEquals(cal.get(Calendar.DAY_OF_WEEK),
				gc.get(GregorianCalendar.DAY_OF_WEEK));// Empieza con el
														// Sunday=1

	}

}
