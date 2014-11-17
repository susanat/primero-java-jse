package com.ipartek.formacion.proyectoclase.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;
import java.util.Objects;

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
	}
}
