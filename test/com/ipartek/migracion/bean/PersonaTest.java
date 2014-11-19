package com.ipartek.migracion.bean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
	Persona persona;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void test() {
		// Probar si la persona es correcta o no
		// persona.esCorrecta();

	}

}
