package com.ipartek.migracion.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
	private Persona persona;
	private static String[] validEmails, invalidEmails;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		validEmails = new String[] { "test@example.com",
				"test-101@example.com", "test.101@yahoo.com",
				"test101@example.com", "test_101@example.com",
				"test-101@test.net", "test.100@example.com.au", "test@e.com",
				"test@1.com", "test@example.com.com", "test+101@example.com",
				"101@example.com", "test-101@example-test.com" };

		invalidEmails = new String[] { "", "example", "example@.com.com",
				"exampel101@test.a", "exampel101@.com", ".example@test.com",
				"example**()@test.com", "example@%*.com",
				"example..101@test.com", "example.@test.com",
				"test@example_101.com", "example@test@test.com",
		"example@test.com.a5" };
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		persona = new Persona("", "", "", 0, "", "", "");
	}

	@After
	public void tearDown() throws Exception {
		persona = null;
	}

	@Test
	public void testEdad() {
		// Probar edades correcta
		persona.setEdad(18);
		assertTrue("18 debería ser edad correcta", persona.edadCorrecta());
		persona.setEdad(99);
		assertTrue("99 debería ser edad correcta", persona.edadCorrecta());
		persona.setEdad(40);
		assertTrue("40 debería ser edad correcta", persona.edadCorrecta());

		// Probar edades incorrectas
		persona.setEdad(17);
		assertFalse("17 debería ser edad incorrecta", persona.edadCorrecta());
		persona.setEdad(100);
		assertFalse("100 debería ser edad incorrecta", persona.edadCorrecta());
	}

	@Test
	public void testEmail() {
		// Probar emails correctos
		for (int i = 0; i < validEmails.length; i++) {
			persona.setEmail(validEmails[i]);
			assertTrue(validEmails[i] + " debería ser correcto",
					persona.emailCorrecto());
		}

		// Probar emails incorrectos
		for (int i = 0; i < invalidEmails.length; i++) {
			persona.setEmail(invalidEmails[i]);
			assertFalse(invalidEmails[i] + " debería ser incorrecto",
					persona.emailCorrecto());
		}
	}

	@Test
	public void testDni() {
		// Probar dnis correctos
		persona.setDni("3900331Z");
		assertTrue("3900331Z debería ser correcto", persona.dniCorrecto());
		persona.setDni("87642421R");
		assertTrue("87642421R debería ser correcto", persona.dniCorrecto());
		// Probar dnis incorrectos
		persona.setDni("0");
		assertFalse(" debería ser incorrecto", persona.dniCorrecto());
		persona.setDni("3900331e");
		assertFalse("3900331e debería ser incorrecto", persona.dniCorrecto());
	}
}
