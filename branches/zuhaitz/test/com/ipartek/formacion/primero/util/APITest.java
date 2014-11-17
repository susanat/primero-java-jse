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
	String c = "Adiós";
	String nulo = null;

	String personaNombre = "Pili";
	String personaApe1 = "Mili";
	String personaApe2 = "Gorriti";
	String personaEdad = "34";
	String separador = ";";
	String lineaPersona = personaNombre + separador + personaApe1 + separador
			+ personaApe2 + separador + personaEdad;

	String strOriginal = "HolaHolaHolaHola";
	String strReplace = "Hol2Hol2Hol2Hol2";

	static GregorianCalendar gc1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc1 = new GregorianCalendar();
		gc1.setTime(new Date());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc1 = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testObjectsEquals() {
		assertTrue(Objects.equals(a, b));
		assertFalse(Objects.equals(a, c));
		assertFalse(Objects.equals(a, nulo));
		assertFalse(Objects.equals(a, aLower));
		assertTrue(Objects.equals(a.toLowerCase(), aLower.toLowerCase()));
	}

	@Test
	public void testStringBuilder() throws Exception {
		StringBuilder sb = new StringBuilder(a);

		assertEquals(a, sb.toString());

		sb.append(b);
		assertEquals(a + b, sb.toString());

		sb = sb.replace(0, sb.length(), c);
		assertEquals(c, sb.toString());
	}

	@Test
	public void testTrocearCadedmas() throws Exception {
		// StringTokenizer
		int count = 0;
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);

		while (st.hasMoreElements()) {
			switch (count) {
			case 0:
				assertEquals(personaNombre, st.nextElement());
				break;
			case 1:
				assertEquals(personaApe1, st.nextElement());
				break;
			case 2:
				assertEquals(personaApe2, st.nextElement());
				break;
			case 3:
				assertEquals(personaEdad, st.nextElement());
				break;
			}

			count++;
		}
		count = 0;

		// Split
		String[] aPersona = lineaPersona.split(separador);
		assertEquals(personaNombre, aPersona[0]);
		assertEquals(personaApe1, aPersona[1]);
		assertEquals(personaApe2, aPersona[2]);
		assertEquals(personaEdad, aPersona[3]);

		// Substring
		int beginIndex = 0;
		int endIndex = personaNombre.length();
		assertEquals(personaNombre,
				lineaPersona.substring(beginIndex, endIndex));

		beginIndex = endIndex + 1;
		endIndex += +personaApe1.length() + 1;
		assertEquals(personaApe1, lineaPersona.substring(beginIndex, endIndex));

		beginIndex = endIndex + 1;
		endIndex += +personaApe2.length() + 1;
		assertEquals(personaApe2, lineaPersona.substring(beginIndex, endIndex));

		beginIndex = endIndex + 1;
		endIndex += +personaEdad.length() + 1;
		assertEquals(personaEdad, lineaPersona.substring(beginIndex, endIndex));
	}

	@Test
	public void testReplaceAllString() throws Exception {
		assertEquals(strReplace, strOriginal.replace('a', '2'));
	}

	@Test
	public void testDate() throws Exception {
		// Obtener fecha actual con new Date()
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(new Date());

		// Obtener fecha actual con System.currentTimeMillis()
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.setTimeInMillis(System.currentTimeMillis());

		// Para ver que las dos fechas son iguales
		assertEquals(gc1, gc2);
		assertEquals(gc1.getTimeInMillis(), gc2.getTimeInMillis());

		// Día del mes
		// assertEquals(17, gc1.get(GregorianCalendar.DAY_OF_MONTH));

		// Día de la semana
		// assertEquals(GregorianCalendar.MONDAY,
		// gc1.get(GregorianCalendar.DAY_OF_WEEK));

		// Mes, en Java los meses empiezan por 0
		assertEquals(GregorianCalendar.NOVEMBER,
				gc1.get(GregorianCalendar.MONTH));

		// Año
		// assertEquals(2014, gc1.get(GregorianCalendar.YEAR));
	}

}
