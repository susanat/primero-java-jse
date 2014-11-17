package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
	// String lineaPersona = "Pili,Mili,Gorriti,34;";
	String personaNombre = "Pili";
	String personaApe1 = "Mili";
	String personaApe2 = "Gorriti";
	String personaEdad = "34";
	static final String SEPARADOR = ",";
	static final String SALTOLINEA = ";";
	String lineaPersona = personaNombre + SEPARADOR + personaApe1 + SEPARADOR
			+ personaApe2 + SEPARADOR + personaEdad + SALTOLINEA;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

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
			System.out.println(pnombre + pape1 + pape2 + pedad);
		}

		String[] personas = lineaPersona.split(SALTOLINEA);
		for (String p : personas) {
			String[] d_personas = p.split(SEPARADOR);
			for (String dato : d_personas) {
				System.out.print(dato);
			}
			System.out.println("");
		}

		int indice_fin = lineaPersona.indexOf(SALTOLINEA.charAt(0));
		int indice_inicio = 0;
		// int n_lineas = 0;
		ArrayList<String> people = new ArrayList<String>();
		/*
		 * indice_inicio = texto.indexOf(SALTOLINEA.charAt(0), 1); indice_fin =
		 * texto.indexOf(SALTOLINEA.charAt(0), 2);
		 */
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
}
