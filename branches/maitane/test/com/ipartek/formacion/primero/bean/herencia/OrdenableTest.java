package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrdenableTest {
	static final float DELTA = 0f;

	ArrayList<Ordenable> arrayMezcla = new ArrayList<Ordenable>();
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
		arrayMezcla.add(ch1);
		arrayMezcla.add(ch2);
		arrayMezcla.add(ve1);
		arrayMezcla.add(ve2);
	}

	@After
	public void tearDown() throws Exception {
		ch1 = null;
		ch2 = null;
		ve1 = null;
		ve2 = null;
		arrayMezcla = null;
	}

	@Test
	public void testOrdenar() {

		Collections.sort(arrayMezcla, new ComparatorOrdenable());

		assertEquals(125, arrayMezcla.get(0).getValor(), DELTA);
		assertEquals(150, arrayMezcla.get(1).getValor(), DELTA);
		assertEquals(225, arrayMezcla.get(2).getValor(), DELTA);
		assertEquals(350, arrayMezcla.get(3).getValor(), DELTA);

	}
}
