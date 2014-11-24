package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Generico;

public class GenericoTest {

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
	public void test() {
		Generico<String> gString = new Generico<String>();
		gString.setAtributo("Hola");
		assertEquals("Hola", gString.getAtributo());

		Generico<Integer> gInteger = new Generico<Integer>();
		gInteger.setAtributo(3);
		assertEquals(new Integer(3), gInteger.getAtributo());
	}

}
