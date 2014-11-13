package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.ComparatorCVE.ComparatorPeso;

public class OrdenableTest {

	static String testMsg;

	ArrayList<Ordenable> aOrdenables;
	Churro churro1;
	Churro churro2;
	Churro churro3;
	VehiculoElectrico ve1;
	VehiculoElectrico ve2;
	VehiculoElectrico ve3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testMsg = "";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testMsg = null;
	}

	@Before
	public void setUp() throws Exception {
		aOrdenables = new ArrayList<Ordenable>();

		churro1 = new Churro(200);
		churro2 = new Churro(100);
		churro3 = new Churro(450);
		ve1 = new VehiculoElectrico(1000);
		ve2 = new VehiculoElectrico(1);
		ve3 = new VehiculoElectrico(300);

		aOrdenables.add(churro1);
		aOrdenables.add(churro2);
		aOrdenables.add(churro3);
		aOrdenables.add(ve1);
		aOrdenables.add(ve2);
		aOrdenables.add(ve3);
	}

	@After
	public void tearDown() throws Exception {
		aOrdenables = null;
		churro1 = null;
		churro2 = null;
		churro3 = null;
		ve1 = null;
		ve2 = null;
		ve3 = null;
	}

	@Test
	public void testOrdenable() {
		// Comparar por peso
		testMsg = "La lista de ordenables está mal ordenada por peso.";
		Collections.sort(aOrdenables, new ComparatorPeso());
		assertEquals(testMsg, ve2, aOrdenables.get(0));
		assertEquals(testMsg, churro2, aOrdenables.get(1));
		assertEquals(testMsg, churro1, aOrdenables.get(2));
		assertEquals(testMsg, ve3, aOrdenables.get(3));
		assertEquals(testMsg, churro3, aOrdenables.get(4));
		assertEquals(testMsg, ve1, aOrdenables.get(5));
	}
}
