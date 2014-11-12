package com.ipartek.formacion.primero.bean.herencia;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.util.Utilidades;

public class OrdenableTest {

	float[] arrayMezcla = new float[4];
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
		arrayMezcla[0] = ch1.getValor();
		arrayMezcla[1] = ch2.getValor();
		arrayMezcla[2] = ve1.getValor();
		arrayMezcla[3] = ve2.getValor();
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

		Utilidades.ordenarArrayFloat(arrayMezcla);

		for (int i = 0; i < arrayMezcla.length; i++) {
			// assertt

		}

	}
}
