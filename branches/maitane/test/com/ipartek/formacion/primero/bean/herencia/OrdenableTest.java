package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrdenableTest {

	float[] arrayMezcla = new float[5];
	Churro ch1;
	Churro ch2;
	VehiculoElectrico ve1;
	VehiculoElectrico ve2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ch1 = new Churro(150);
		ch2 = new Churro(350);
		ve1 = new VehiculoElectrico(125);
		ve2 = new VehiculoElectrico(225);
		// arrayMezcla[0] = ch1.get;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
