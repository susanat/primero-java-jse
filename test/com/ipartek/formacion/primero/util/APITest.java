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
	String aLover = "hola";
	String b = "Hola";
	String c = "Adios";
	String nulo = null;

	String cadenaOriginal = "HolaHolaHolaHola";
	String cadenaReemplazada = "Hol2Hol2Hol2Hol2";

	String personaNombre = "Pili";
	String personaApellido1 = "Mili";
	String personaApellido2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	// lineaPersona = "Pili;Mili;Gorriti;34"
	String lineaPersona = personaNombre + separador + personaApellido1
			+ separador + personaApellido2 + separador + personaEdad;

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
	}

	@Test
	public void testObjectsEqual() {
		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, nulo));

		assertFalse(Objects.equals(a, aLover));
		assertTrue(Objects.equals(a.toLowerCase(), aLover.toLowerCase()));
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
		// StringTokenizer
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);
		int contador = 0;
		while (st.hasMoreTokens()) {
			String stAux = st.nextToken();
			switch (contador) {
			case 0:
				assertEquals(personaNombre, stAux);
				break;
			case 1:
				assertEquals(personaApellido1, stAux);
				break;
			case 2:
				assertEquals(personaApellido2, stAux);
				break;
			case 3:
				assertEquals(personaEdad, stAux);
				break;
			default:
				break;
			}
			contador++;
		}

		// Split
		String[] vPersona = lineaPersona.split(separador);
		assertEquals(4, vPersona.length);
		assertEquals(personaNombre, vPersona[0]);
		assertEquals(personaApellido1, vPersona[1]);
		assertEquals(personaApellido2, vPersona[2]);
		assertEquals(personaEdad, vPersona[3]);

		// Substring

		String auxPersona = lineaPersona.substring(0,
				lineaPersona.indexOf(separador));
		String auxLineaPersona = lineaPersona.substring(lineaPersona
				.indexOf(separador));
		assertEquals(personaNombre, auxPersona);
		assertEquals(separador + personaApellido1 + separador
				+ personaApellido2 + separador + personaEdad, auxLineaPersona);

		auxPersona = auxLineaPersona.substring(1,
				auxLineaPersona.indexOf(separador, 2));
		auxLineaPersona = auxLineaPersona.substring(auxLineaPersona.indexOf(
				separador, 2));
		assertEquals(personaApellido1, auxPersona);
		assertEquals(separador + personaApellido2 + separador + personaEdad,
				auxLineaPersona);

		auxPersona = auxLineaPersona.substring(1,
				auxLineaPersona.indexOf(separador, 2));
		auxLineaPersona = auxLineaPersona.substring(auxLineaPersona.indexOf(
				separador, 2) + 1);
		assertEquals(personaApellido2, auxPersona);
		assertEquals(personaEdad, auxLineaPersona);
	}

	@Test
	public void testReplaceAllString() throws Exception {
		String cadenaCambiada = cadenaOriginal.replaceAll("a", "2");
		assertEquals(cadenaReemplazada, cadenaCambiada);
	}

	@Test
	public void testDate() throws Exception {
		// obtener Fecha actual con new Date
		/*
		 * GregorianCalendar hoyDate = new GregorianCalendar();
		 * hoyDate.setTime(new Date());
		 */

		// obtener fecha actual con System.currentTimeMillis()
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		// test de dos fechas iguales
		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		// Dia del mes
		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));

		// Dia de la semana
		assertEquals(GregorianCalendar.MONDAY,
				hoyDate.get(GregorianCalendar.DAY_OF_WEEK));
		assertEquals(2, hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

		// Mes actual
		// acordarse de sumar 1 al mes
		assertEquals(11, hoyDate.get(GregorianCalendar.MONTH) + 1);
		assertEquals(GregorianCalendar.NOVEMBER,
				hoyDate.get(GregorianCalendar.MONTH));

		// Agno actual
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));

	}

	@Test
	public void testFecha() throws Exception {
		int dia = hoyDate.get(GregorianCalendar.DAY_OF_MONTH);
		int anio = hoyDate.get(GregorianCalendar.YEAR);

		String diaString = String.format("%02d", dia);
		for (int mes = 0; mes <= GregorianCalendar.DECEMBER; mes++) {
			hoyDate.set(GregorianCalendar.MONTH, mes);
			int auxMes = mes + 1;

			// Crear las cadenas para cada idioma
			String hoyStringCastellano = diaString + "/"
					+ String.format("%02d", auxMes) + "/" + anio;
			String hoyStringEuskera = anio + "/"
					+ String.format("%02d", auxMes) + "/" + diaString;
			// testear cadenas contra Fecha.getString()
			assertEquals(hoyStringCastellano,
					Fecha.getString(hoyDate, Idioma.CASTELLANO));
			assertEquals(hoyStringEuskera,
					Fecha.getString(hoyDate, Idioma.EUSKARA));
		}
	}
}
