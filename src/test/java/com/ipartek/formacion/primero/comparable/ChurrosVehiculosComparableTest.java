package com.ipartek.formacion.primero.comparable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Churro;
import com.ipartek.formacion.primero.bean.herencia.ComparatorOrdenable;
import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;
import com.ipartek.formacion.primero.bean.interfaces.IOrdenable;

public class ChurrosVehiculosComparableTest {

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

		ArrayList<IOrdenable> lista = new ArrayList<IOrdenable>();
		lista.add(new VehiculoElectrico(100f));
		lista.add(new VehiculoElectrico(101f));
		lista.add(new VehiculoElectrico(102f));
		lista.add(new VehiculoElectrico(103f));

		lista.add(new Churro(100));
		lista.add(new Churro(120));
		lista.add(new Churro(12));
		lista.add(new Churro(1030));

		Collections.sort(lista, new ComparatorOrdenable());

		// test ordenacion del 1º y ultimo
		assertEquals(12, lista.get(0).getPeso());
		assertEquals(101, lista.get(3).getPeso());
		assertEquals(1030, lista.get((lista.size() - 1)).getPeso());

	}

}
