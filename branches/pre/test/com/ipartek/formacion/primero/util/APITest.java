package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	String nulo = null;

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	// lineaPersona = "Pili;Mili;Gorriti;34"
	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

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

		// StrinTokenIzer
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);
		int cont = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			switch (cont) {
			case 0:
				assertEquals(personaNombre, token);
				break;
			case 1:
				assertEquals(personaApellido1, token);
				break;
			case 2:
				assertEquals(personaApellido2, token);
				break;
			case 3:
				assertEquals(personaEdad, token);
				break;

			default:
				break;
			}
			cont++;
		}

		// split

		String[] arrayPersona = lineaPersona.split(separador);
		assertEquals(personaNombre, arrayPersona[0]);
		assertEquals(personaApellido1, arrayPersona[1]);
		assertEquals(personaApellido2, arrayPersona[2]);
		assertEquals(personaEdad, arrayPersona[3]);

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

		assertEquals(9, lineaPersona.indexOf(separador, 8));

	}

}
