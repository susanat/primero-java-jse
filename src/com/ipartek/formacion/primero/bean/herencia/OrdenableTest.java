package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
		Ordenable[] o = new Ordenable[5];
		Ordenable[] ord = new Ordenable[5];

		CocheElectrico ce100 = new CocheElectrico(100);
		Churro ch50 = new Churro(50);
		Churro ch350 = new Churro(350);
		CocheElectrico ce6 = new CocheElectrico(6);
		CocheElectrico ce13 = new CocheElectrico(13);

		// array sin ordenar
		o[0] = ce100;
		o[1] = ch50;
		o[2] = ch350;
		o[3] = ce6;
		o[4] = ce13;

		// array ordenado
		ord[0] = ce6;
		ord[1] = ce13;
		ord[2] = ch50;
		ord[3] = ce100;
		ord[4] = ch350;

		Arrays.sort(o, new ComparatorCCE());

		for (int i = 0; i < 5; i++) {
			assertEquals(ord[i], o[i]);
		}
	}
}
