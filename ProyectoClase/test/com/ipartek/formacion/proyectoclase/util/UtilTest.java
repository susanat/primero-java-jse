package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilTest {

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
	public void testIsVocal() {
		// TODO implementar test
		/* fail("Not yet implemented"); */
		final char[] VOCALES = new char[] { 'a', 'e', 'i', 'o', 'u', 'á', 'é',
				'í', 'ó', 'ú', 'ü' };
		final char[] CONSONANTES = new char[] { 'b', 'c', 'd', 'f', 'g', 'h',
				'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
				'x', 'y', 'z' };
		final char[] CHARS = new char[] { ' ', '?', '-' };
		for (int i = 0; i < VOCALES.length; i++) {
			assertTrue("LA LETRA " + VOCALES[i] + " DEBERIA SER TRUE",
					Util.isVocal(VOCALES[i]) == true);

			assertTrue("LA LETRA " + Character.toUpperCase(VOCALES[i])
					+ " DEBERIA SER TRUE",
					Util.isVocal(Character.toUpperCase(VOCALES[i])) == true);
		}
		for (int i = 0; i < CONSONANTES.length; i++) {
			assertTrue("LA LETRA " + CONSONANTES[i] + " DEBERIA SER FALSE",
					Util.isVocal(CONSONANTES[i]) == false);

			assertTrue(
					"LA LETRA " + Character.toUpperCase(CONSONANTES[i])
							+ " DEBERIA SER TRUE",
					Util.isVocal(Character.toUpperCase(CONSONANTES[i])) == false);
		}
		for (int i = 0; i < CHARS.length; i++) {
			assertTrue("EL SIMBOLO " + CHARS[i] + " DEBERIA SER FALSE",
					Util.isVocal(CHARS[i]) == false);
		}
		// assertTrue("",);

	}

}
