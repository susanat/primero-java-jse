package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

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
		// obtener Fecha actual con new Date
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

	@Test
	public void testReplaceString() throws Exception {

		String cadenaCambiada = cadenaOriginal.replace('a', '2');
		assertEquals(cadenaReemplazada, cadenaCambiada);

		String cadenaCambiada2 = cadenaOriginal2.replace("Hola", "Adios");
		assertEquals(cadenaReemplazada2, cadenaCambiada2);

	}

	@Test
	public void testDate() throws Exception {

		// obtener Fecha actual con System.currentTimeMillis()
		GregorianCalendar hoyCurrent = new GregorianCalendar();
		hoyCurrent.setTimeInMillis(System.currentTimeMillis());

		// test las dos fechas iguales
		assertEquals(hoyDate, hoyCurrent);
		assertEquals(hoyDate.getTimeInMillis(), hoyCurrent.getTimeInMillis());

		// Dia del mes
		assertEquals(17, hoyDate.get(GregorianCalendar.DAY_OF_MONTH));

		// Dia de la semana
		assertEquals(GregorianCalendar.MONDAY,
				hoyDate.get(GregorianCalendar.DAY_OF_WEEK));
		assertEquals(2, hoyDate.get(GregorianCalendar.DAY_OF_WEEK));

		// Mes actual
		// acordaros de sumar 1 al mes
		assertEquals(11, (hoyDate.get(GregorianCalendar.MONTH) + 1));
		assertEquals(GregorianCalendar.NOVEMBER,
				hoyDate.get(GregorianCalendar.MONTH) );

		// Anyo actual
		assertEquals(2014, hoyDate.get(GregorianCalendar.YEAR));

	}

	@Test
	public void testFecha() throws Exception {

		// crear las cadenas para cada idioma
		String hoyStringCastellano = hoyDate
				.get(GregorianCalendar.DAY_OF_MONTH)
				+ "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1)
				+ "/"
				+ hoyDate.get(GregorianCalendar.YEAR);
		String hoyStringEuskera = hoyDate.get(GregorianCalendar.YEAR) + "/"
				+ (hoyDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ hoyDate.get(GregorianCalendar.DAY_OF_MONTH);

		// testear cadenas contra Fecha.getString()
		assertEquals(hoyStringCastellano,
				Fecha.getString(hoyDate, Idioma.CASTELLANO));

		assertEquals(hoyStringEuskera, Fecha.getString(hoyDate, Idioma.EUSKARA));

	}

}

