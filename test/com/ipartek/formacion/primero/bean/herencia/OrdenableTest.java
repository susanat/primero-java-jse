package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrdenableTest {

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
		Ordenable[] array = new Ordenable[5];
		array[0] = new Churros(100f);
		// array[0] = new (100f);
		array[0] = new Churros(100f);
		array[0] = new Churros(100f);
		array[0] = new Churros(100f);
		fail("Not yet implemented");
	}

}
