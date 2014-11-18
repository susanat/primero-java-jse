package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Objects;

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

	String cadenaOriginal = "HolaHolaHolaHola";
	String cadenaReemplazada = "Hol2Hol2Hol2Hol2";
	String cadenaReemplazada2 = "AdiosAdiosAdiosAdios";

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	// String lineaPersona = "Pili; Mili; Gorriti; 34";
	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

	// ArrayList elementosCadena = null;

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
		assertTrue(Objects.equals(a.toLowerCase(), aLower));
	}

	@Test
	public void testStringBuilder() {

		StringBuilder sb = new StringBuilder(a);
		assertTrue(Objects.equals(a, sb.toString()));

		sb.append(b);
		assertTrue(Objects.equals(a + b, sb.toString()));

		sb = sb.replace(0, sb.length(), c);
		assertTrue(Objects.equals(c, sb.toString()));

	}

	@Test
	public void testTrocearCadenas() {

		// StringTokenizer
		ArrayList<String> elementosCadena = new ArrayList<String>();
		elementosCadena = Api.SepararTokenizer(lineaPersona, separador);
		assertTrue(Objects.equals(elementosCadena.get(0), personaNombre));
		assertTrue(Objects.equals(elementosCadena.get(1), personaApellido1));
		assertTrue(Objects.equals(elementosCadena.get(2), personaApellido2));
		assertTrue(Objects.equals(elementosCadena.get(3), personaEdad));

		// split

		String[] elemsCadena = Api.separarSplit(lineaPersona, separador);
		assertTrue(Objects.equals(elemsCadena[0], personaNombre));
		assertTrue(Objects.equals(elemsCadena[1], personaApellido1));
		assertTrue(Objects.equals(elemsCadena[2], personaApellido2));
		assertTrue(Objects.equals(elemsCadena[3], personaEdad));

		// subString

		int inicio = 0;
		int fin = personaNombre.length();

		assertTrue("El nombre no es igual", Objects.equals(
				lineaPersona.substring(inicio, fin), personaNombre));
		inicio = fin + 1;
		fin += personaApellido1.length() + 1;
		assertTrue("El apellido1 no es igual", Objects.equals(
				lineaPersona.substring(inicio, fin), personaApellido1));
		inicio = fin + 1;
		fin += personaApellido2.length() + 1;
		assertTrue("El apellido2 no es igual", Objects.equals(
				lineaPersona.substring(inicio, fin), personaApellido2));
		inicio = fin + 1;
		fin += personaEdad.length() + 1;
		assertTrue("Edad no es igual", Objects.equals(
				lineaPersona.substring(inicio, fin), personaEdad));

		// substring+indexOf

		assertEquals(9, lineaPersona.indexOf(separador, 8));

	}

	@Test
	public void testReplaceAllString() {
		String cadenaCambiada = cadenaOriginal.replace('a', '2');
		assertEquals(cadenaReemplazada, cadenaCambiada);

		String cadenaCambiada2 = cadenaOriginal.replace("Hola", "Adios");
		assertEquals(cadenaReemplazada2, cadenaCambiada2);
	}

}
